package chai;

import chai.exceptions.ChaiException;
import chai.tasks.Deadline;
import chai.tasks.Event;
import chai.tasks.TaskList;
import chai.tasks.Todo;
import chai.ui.UserInterface;

public class ChaiBot {
    public static final String DEADLINE_FORMAT_INCORRECT_MESSAGE = "Deadline format incorrect! Use: deadline <task> /by <date>";
    public static final String EVENT_FORMAT_INCORRECT_MESSAGE = "Event format incorrect! Use: event <task> /from <start> /to <end>";
    private final TaskList tasks;

    public ChaiBot() {
        this.tasks = new TaskList();
    }

    public boolean handleCommand(String input) throws ChaiException {
        String[] commands = input.split(" ", 2);
        String command = commands[0];
        String entry = commands.length > 1 ? commands[1] : "";

        switch (command) {
        case "bye": {
            UserInterface.showExitMessage();
            return false;
        }

        case "list": {
            tasks.printTasks();
            break;
        }

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

        case "todo": {
            ChaiException.descriptionCannotBeEmpty(entry);
            tasks.addTask(new Todo(entry));
            break;
        }

        case "deadline": {
            if (!entry.contains("/by")) {
                ChaiException.incorrectFormat(DEADLINE_FORMAT_INCORRECT_MESSAGE);
            }
            String[] deadlineParts = entry.split(" /by ");
            if (deadlineParts.length < 2) {
                ChaiException.missingArgument("deadline");
            }
            tasks.addTask(new Deadline(deadlineParts[0], deadlineParts[1]));
            break;
        }

        case "event": {
            if (!entry.contains("/from") || !entry.contains("/to")) {
                ChaiException.incorrectFormat(EVENT_FORMAT_INCORRECT_MESSAGE);
            }
            String[] eventParts = entry.split(" /from | /to ");
            if (eventParts.length < 3) {
                ChaiException.missingArgument("start and end time");
            }
            tasks.addTask(new Event(eventParts[0], eventParts[1], eventParts[2]));
            break;
        }

        case "delete": {
            int taskNumber = Integer.parseInt(entry);
            tasks.deleteTask(taskNumber);
            break;
        }

        default: {
            throw new ChaiException("Unknown command: " + command);
        }
        }
        return true;
    }
}