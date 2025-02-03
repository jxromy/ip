public class ChaiBot {
    private TaskList tasks;

    public ChaiBot() {
        this.tasks = new TaskList();
    }

    public boolean handleInput(String input) {
        if (input.equals("bye")) {
            Ui.showExitMessage();
            return false;
        } else if (input.equals("list")) {
            tasks.printTasks();
        } else if (input.startsWith("mark ")) {
            try {
                int taskNumber = Integer.parseInt(input.substring(5));
                tasks.markTask(taskNumber);
            } catch (NumberFormatException e) {
                Ui.showInvalidNumberMessage();
            }
        } else if (input.startsWith("unmark ")) {
            try {
                int taskNumber = Integer.parseInt(input.substring(7));
                tasks.unmarkTask(taskNumber);
            } catch (NumberFormatException e) {
                Ui.showInvalidNumberMessage();
            }
        } else {
            if (tasks.addTask(input)) {
                Ui.showAddedMessage(input);
            } else {
                Ui.showListFullMessage();
            }
        }
        return true;
    }
}