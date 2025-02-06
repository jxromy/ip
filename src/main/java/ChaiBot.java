public class ChaiBot {
    private TaskList tasks;

    public ChaiBot() {
        this.tasks = new TaskList();
    }

    public boolean handleCommand(String input) {
        if (input.equals("bye")) {
            UserInterface.showExitMessage();
            return false;
        } else if (input.equals("list")) {
            tasks.printTasks();
        } else if (input.startsWith("mark ")) {
            int taskNumber = Integer.parseInt(input.substring(5));
            tasks.markTask(taskNumber);
        } else if (input.startsWith("unmark ")) {
            int taskNumber = Integer.parseInt(input.substring(7));
            tasks.unmarkTask(taskNumber);
        } else if (input.startsWith("todo ")) {
            String description = input.substring(5);
            tasks.addTask(new Todo(description));
        } else if (input.startsWith("deadline ")) {
            String[] parts = input.substring(9).split(" /by ");
            tasks.addTask(new Deadline(parts[0], parts[1]));
        } else if (input.startsWith("event ")) {
            String[] parts = input.substring(6).split(" /from | /to ");
            tasks.addTask(new Event(parts[0], parts[1], parts[2]));
        } else {
            UserInterface.showUnknownCommandMessage();
        }
        return true;
    }
}