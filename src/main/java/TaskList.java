import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        UserInterface.showTaskAddedMessage(task, tasks.size());
    }

    public void markTask(int taskNumber) {
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            UserInterface.showOutOfRangeMessage(tasks.size());
            return;
        }
        tasks.get(taskNumber - 1).setDoneStatus(true);
        UserInterface.showTaskMarkedMessage(tasks.get(taskNumber - 1));
    }

    public void unmarkTask(int taskNumber) {
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            UserInterface.showOutOfRangeMessage(tasks.size());
            return;
        }
        tasks.get(taskNumber - 1).setDoneStatus(false);
        UserInterface.showTaskUnmarkedMessage(tasks.get(taskNumber - 1));
    }

    public void printTasks() {
        UserInterface.showTaskList(tasks);
    }
}