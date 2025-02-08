public class ChaiBot {
    private TaskList tasks;

    public ChaiBot() {
        this.tasks = new TaskList();
    }

    public boolean handleCommand(String input) throws ChaiException {
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
                throw new ChaiException("The description cannot be empty.");
            }
            tasks.addTask(new Todo(entry));
            break;

        case "deadline": {
            if (!entry.contains("/by")) {
                throw new ChaiException("Deadline format incorrect! Use: deadline <task> /by <date>");
            }
            String[] deadlineParts = entry.split(" /by ");
            if (deadlineParts.length < 2) {
                throw new ChaiException("You need to specify a deadline!");
            }
            tasks.addTask(new Deadline(deadlineParts[0], deadlineParts[1]));
            break;
        }

        case "event": {
            if (!entry.contains("/from") || !entry.contains("/to")) {
                throw new ChaiException("Event format incorrect! Use: event <task> /from <start> /to <end>");
            }
            String[] eventParts = entry.split(" /from | /to ");
            if (eventParts.length < 3) {
                throw new ChaiException("You need to specify both start and end time!");
            }
            tasks.addTask(new Event(eventParts[0], eventParts[1], eventParts[2]));
            break;
        }

        default:
            throw new ChaiException("Unknown command: " + command);
        }
        return true;
    }
}