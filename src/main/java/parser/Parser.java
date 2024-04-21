package parser;

import commands.*;
import exceptions.*;


import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a parser which will take the user input, read and execute the corresponding 
 * commands.
 * 
 */

public class Parser {
    /**
     * Format DateTime: user input string from d/MM/yyyy HHmm to MMM d yyyy hh:mma.
     * 
     */
    public static String formatDateTimeFromString(String dateString) throws IllegalDateTimeException{
        DateTimeFormatter formatterWithTime = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm");

        try{
            LocalDateTime deadlineDateTime = LocalDateTime.parse(dateString, formatterWithTime);
            return deadlineDateTime.format(DateTimeFormatter.ofPattern("MMM d yyyy hh:mma"));

        } catch (DateTimeParseException e) {
            throw new IllegalDateTimeException();
        }

    }
    /**
     * Format Date: user input string from d/MM/yyyy to MMM d yyyy.
     * 
     */
    public static String formatDateFromString(String dateString) throws IllegalDateException{
        DateTimeFormatter formatterWithoutTime = DateTimeFormatter.ofPattern("d/MM/yyyy");

        try{
            LocalDate deadlineDate = LocalDate.parse(dateString, formatterWithoutTime);
            return deadlineDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

        } catch (DateTimeParseException e) {
            throw new IllegalDateException();
        }

    }
    public static Command parse(String command) throws MissingInputException, IllegalDateTimeException, IllegalIndexNumberException, IllegalDateException,WrongDeadineFormatException, WrongCommandException, IllegalIndexFormatException {
        String description;
        String startsAt;
        String endsAt;
        String dateString;

        String[] inputArray = command.split(" ");
        String identifier = inputArray[0];
        assert !identifier.isEmpty(): "Command cannot be empty";
        switch (identifier) {
            case "":
                throw new MissingInputException();

            case "todo":
                description = command.split("todo ")[1];
                return new TodoCommand(description);

            case "event":
                int firstSlashIndex = command.indexOf("/");
                description = command.substring(6,firstSlashIndex);

                String[] atTimes = command.split("/");
                startsAt = atTimes[1].replace("from ", ""); 
                endsAt = atTimes[2].replace("to ", "");

                return new EventCommand(description,startsAt,endsAt);

            case "deadline":
                try{
                    firstSlashIndex = command.indexOf("/");
                    description = command.substring(9,firstSlashIndex);
                } catch (StringIndexOutOfBoundsException e){
                    throw new WrongDeadineFormatException();
                }
                
                try{
                    dateString = command.substring(firstSlashIndex+4);
                    String byDate = formatDateTimeFromString(dateString);
                    return new DeadlineCommand(description,byDate);
                } catch (StringIndexOutOfBoundsException e){
                    throw new MissingInputException();
                }
                
            case "fixed":
                firstSlashIndex = command.indexOf("/");
                description = command.substring(6,firstSlashIndex);
                String duration = command.substring(firstSlashIndex+7);

                return new FixedDurationCommand(description,duration);

            case "bye":
                return new ByeCommand();
            
            case "list":
                return new ListCommand();

            case "mark":
                if (inputArray.length!=2){
                    throw new MissingInputException();
                }
                String markIndex = inputArray[1];
                return new MarkCommand(markIndex);          

            case "unmark":
                if (inputArray.length!=2){
                    throw new MissingInputException();
                }
                assert (inputArray[1].matches("-?\\d+(\\d+)?")):"Index must be positive integer";
                String unmarkIndex = inputArray[1];
                return new UnmarkCommand(unmarkIndex);

            case "delete":
                if (inputArray.length!=2){
                    throw new MissingInputException();
                }
                String delIndex = inputArray[1];
                return new DeleteCommand(delIndex);

            case "find":
                if (inputArray.length!=2){
                    throw new MissingInputException();
                }
                String toFind = inputArray[1];
                return new FindCommand(toFind);

            case "schedule":
            if (inputArray.length!=2){
                throw new MissingInputException();
            }
            String scheduleDate = inputArray[1];
            scheduleDate = formatDateFromString(scheduleDate);

            return new ScheduleCommand(scheduleDate);

            default: throw new WrongCommandException();
        }
    }

}