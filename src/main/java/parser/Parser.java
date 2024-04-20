package parser;

import commands.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a parser which will take the user input, read and execute the corresponding 
 * commands.
 * 
 */

public class Parser {
    public static String formatDateFromString(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm");
        LocalDateTime d1 = LocalDateTime.parse(dateString, formatter);

        return d1.format(DateTimeFormatter.ofPattern("MMM d yyyy hh:mma"));

    }
    public static Command parse(String command) {
        String description;
        String startsAt;
        String endsAt;
        String dateString;

        String[] inputArray = command.split(" ");
        String identifier = inputArray[0];

        switch (identifier) {
            case "todo":
                description = command.split("todo ")[1];
                if (description.length()==0){
                    throw new IndexOutOfBoundsException("! The description of a todo cannot be empty.");
                }
                return new TodoCommand(description);

            case "event":
                int firstSlashIndex = command.indexOf("/");
                description = command.substring(6,firstSlashIndex);

                String[] atTimes = command.split("/");
                startsAt = atTimes[1].replace("from ", ""); 
                endsAt = atTimes[2].replace("to ", "");

                return new EventCommand(description,startsAt,endsAt);

            case "deadline":
                firstSlashIndex = command.indexOf("/");
                description = command.substring(9,firstSlashIndex);
                dateString = command.substring(firstSlashIndex+4);
                String byDate = formatDateFromString(dateString);

                return new DeadlineCommand(description,byDate);
            
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
                String markIndex = inputArray[1];
                return new MarkCommand(markIndex);

            case "unmark":
                String unmarkIndex = inputArray[1];
                return new UnmarkCommand(unmarkIndex);

            case "delete":
                String delIndex = inputArray[1];
                return new DeleteCommand(delIndex);

            case "find":
                String toFind = inputArray[1];
                return new FindCommand(toFind);
        }
        return null;
    }

}