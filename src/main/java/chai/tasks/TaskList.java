package chai.tasks;

import chai.exceptions.ChaiException;
import chai.ui.UserInterface;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        UserInterface.showTaskAddedMessage(task, tasks.size());
    }

    public void markTask(int taskNumber) throws ChaiException {
        if (tasks.isEmpty()) {
            ChaiException.taskListCannotBeEmpty();
            return;
        }
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            ChaiException.taskNumberOutOfRange(tasks.size());
            return;
        }
        Task task = tasks.get(taskNumber - 1);
        if (!task.getDoneStatus()) {
            task.setDoneStatus(true);
            UserInterface.showTaskMarkedMessage(task);
        } else {
            UserInterface.showTaskAlreadyMarkedMessage();
        }
    }

    public void unmarkTask(int taskNumber) throws ChaiException {
        if (tasks.isEmpty()) {
            ChaiException.taskListCannotBeEmpty();
            return;
        }
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            ChaiException.taskNumberOutOfRange(tasks.size());
            return;
        }
        Task task = tasks.get(taskNumber - 1);
        if (task.getDoneStatus()) {
            task.setDoneStatus(false);
            UserInterface.showTaskUnmarkedMessage(task);
        } else {
            UserInterface.showTaskAlreadyUnmarkedMessage();
        }
    }

    public void printTasks() {
        UserInterface.showTaskList(tasks);
    }
}