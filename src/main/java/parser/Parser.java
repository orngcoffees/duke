package parser;

import commands.*;

public class Parser {
    public static Command parse(String command) {
        String description;
        String by;
        String startsAt;
        String endsAt;

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
                description = command.substring(5,firstSlashIndex);

                String[] atTimes = command.split("/");
                startsAt = atTimes[1].replace("from ", ""); 
                endsAt = atTimes[2].replace("to ", "");

                return new EventCommand(description,startsAt,endsAt);

            case "deadline":
                firstSlashIndex = command.indexOf("/");
                description = command.substring(8,firstSlashIndex);
                by = command.substring(firstSlashIndex+4);

                return new DeadlineCommand(description,by);

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
        }
        return null;
    }

}