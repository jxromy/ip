package chai.tasks;

import chai.exceptions.ChaiException;
import chai.ui.UserInterface;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = Storage.loadTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
        Storage.saveTasks(tasks);
        UserInterface.showTaskAddedMessage(task, tasks.size());
    }

    public void markTask(int taskNumber) throws ChaiException {
        validateTaskNumber(taskNumber);
        Task task = tasks.get(taskNumber - 1);
        if (!task.getDoneStatus()) {
            task.setDoneStatus(true);
            Storage.saveTasks(tasks);
            UserInterface.showTaskMarkedMessage(task);
        } else {
            UserInterface.showTaskAlreadyMarkedMessage();
        }
    }

    public void unmarkTask(int taskNumber) throws ChaiException {
        validateTaskNumber(taskNumber);
        Task task = tasks.get(taskNumber - 1);
        if (task.getDoneStatus()) {
            task.setDoneStatus(false);
            Storage.saveTasks(tasks);
            UserInterface.showTaskUnmarkedMessage(task);
        } else {
            UserInterface.showTaskAlreadyUnmarkedMessage();
        }
    }

    private void validateTaskNumber(int taskNumber) throws ChaiException {
        if (tasks.isEmpty()) {
            ChaiException.taskListCannotBeEmpty();
        }
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            ChaiException.taskNumberOutOfRange(tasks.size());
        }
    }

    public void printTasks() {
        UserInterface.showTaskList(tasks);
    }
}