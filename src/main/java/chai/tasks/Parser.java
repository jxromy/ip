package chai.tasks;

import chai.exceptions.ChaiException;
import chai.ui.UserInterface;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Handles user input and parses commands for task management.
 */
public class Parser {
    private TaskList tasks;

    private static final DateTimeFormatter[] DATE_FORMATS = {
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd HHmm"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm"),
            DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm"),
            DateTimeFormatter.ofPattern("d-MM-yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-d HHmm"),
            DateTimeFormatter.ofPattern("d-MM-yyyy HHmm"),
            DateTimeFormatter.ofPattern("yyyy/MM/d HH:mm"),
            DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy/MM/d HHmm"),
            DateTimeFormatter.ofPattern("d/MM/yyyy HHmm"),
            DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm"),
            DateTimeFormatter.ofPattern("dd-M-yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-M-dd HHmm"),
            DateTimeFormatter.ofPattern("dd-M-yyyy HHmm"),
            DateTimeFormatter.ofPattern("yyyy/M/dd HH:mm"),
            DateTimeFormatter.ofPattern("dd/M/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy/M/dd HHmm"),
            DateTimeFormatter.ofPattern("dd/M/yyyy HHmm"),
            DateTimeFormatter.ofPattern("yyyy-M-d HH:mm"),
            DateTimeFormatter.ofPattern("d-M-yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-M-d HHmm"),
            DateTimeFormatter.ofPattern("d-M-yyyy HHmm"),
            DateTimeFormatter.ofPattern("yyyy/M/d HH:mm"),
            DateTimeFormatter.ofPattern("d/M/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy/M/d HHmm"),
            DateTimeFormatter.ofPattern("d/M/yyyy HHmm"),
    };

    /**
     * Parses a date string into a LocalDateTime object using multiple possible date formats.
     * If none of the predefined formats match, an exception is thrown.
     *
     * @param dateStr The date string to be parsed.
     * @return A LocalDateTime object representing the parsed date.
     * @throws ChaiException If the date format is invalid.
     */
    private static LocalDateTime parseDate(String dateStr) throws ChaiException {
        for (DateTimeFormatter formatter : DATE_FORMATS) {
            try {
                return LocalDateTime.parse(dateStr, formatter);
            } catch (DateTimeParseException ignored) {
                // Try the next format
            }
        }
        ChaiException.incorrectFormat("Invalid date! Try: yyyy-MM-dd or dd/MM/yyyy");
        return null;
    }
  
    /**
     * Constructs a Parser that interacts with the given TaskList.
     *
     * @param tasks The TaskList to manage.
     */
    public Parser(TaskList tasks) {
        this.tasks = tasks;
    }

    /**
     * Parses the user's input and executes the given command.
     *
     * @param input The full command entered by the user.
     * @return {@code true} if the program should continue running, {@code false} if the user enters "bye" to exit.
     * @throws ChaiException If the input is invalid or an error occurs during execution.
     */
    public boolean parse(String input) throws ChaiException {
        String[] commands = input.split(" ", 2);
        String command = commands[0];
        String entry = commands.length > 1 ? commands[1] : "";

        switch (command) {
        case "bye":
            UserInterface.showExitMessage();
            return false;

        case "list":
            tasks.printTasks();
            break;

        case "mark": {
            int taskNum = Integer.parseInt(entry);
            tasks.markTask(taskNum);
            break;
        }

        case "unmark": {
            int taskNum = Integer.parseInt(entry);
            tasks.unmarkTask(taskNum);
            break;
        }

        case "todo":
            if (entry.isEmpty()) {
                ChaiException.descriptionCannotBeEmpty();
            }
            tasks.addTask(new Todo(entry));
            break;

        case "find": {
            if (entry.isEmpty()) {
                ChaiException.descriptionCannotBeEmpty();
            }
            tasks.findTasks(entry);
            break;
        }

        case "deadline": {
            if (!entry.contains("/by")) {
                ChaiException.incorrectFormat("Deadline format incorrect. Use: deadline <task> /by <date>");
            }
            String[] deadlineParts = entry.split("\\s*/by\\s*", 2);
            if (deadlineParts[1].isEmpty()) {
                ChaiException.missingArgument("date and time");
            }
            try {
                LocalDateTime deadlineTime = parseDate(deadlineParts[1]);
                tasks.addTask(new Deadline(deadlineParts[0], deadlineTime));
            } catch (ChaiException e) {
                ChaiException.incorrectFormat("I'm confused. Try: dd-MM-yyyy HHmm");
            }
            break;
        }

        case "event": {
            if (!entry.contains("/from") || !entry.contains("/to")) {
                ChaiException.incorrectFormat("Event format incorrect. Use: event <task> /from <start> /to <end>");
            }
            String[] eventParts = entry.split("\\s*/from\\s*|\\s*/to\\s*");
            if (eventParts.length < 3) {
                ChaiException.missingArgument("start and end time");
            }
            try {
                LocalDateTime startTime = parseDate(eventParts[1]);
                LocalDateTime endTime = parseDate(eventParts[2]);

                if (startTime.isAfter(endTime)) {
                    throw new ChaiException("Start time cannot be after end time.");
                }

                tasks.addTask(new Event(eventParts[0], startTime, endTime));
            } catch (ChaiException e) {
                throw new ChaiException("Invalid date format. Use: yyyy-MM-dd HH:mm");
            }
            break;
        }

        case "delete":
            int taskNumber = Integer.parseInt(entry);
            tasks.deleteTask(taskNumber);
            break;

        default:
            throw new ChaiException("Unknown command: " + command);
        }
        return true;
    }
}
