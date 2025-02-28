package chai.tasks;

import chai.exceptions.ChaiException;
import chai.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        Storage.saveTasks(tasks);
        UserInterface.showTaskAddedMessage(task, tasks.size());
    }

    public void markTask(int taskNumber) throws ChaiException {
        checkTaskNumber(taskNumber);
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
        checkTaskNumber(taskNumber);
        Task task = tasks.get(taskNumber - 1);
        if (task.getDoneStatus()) {
            task.setDoneStatus(false);
            Storage.saveTasks(tasks);
            UserInterface.showTaskUnmarkedMessage(task);
        } else {
            UserInterface.showTaskAlreadyUnmarkedMessage();
        }
    }

    public void deleteTask(int taskNumber) throws ChaiException {
        checkTaskNumber(taskNumber);
        Task removedTask = tasks.remove(taskNumber - 1);
        Storage.saveTasks(tasks);
        UserInterface.showTaskDeletedMessage(removedTask, tasks.size());
    }

    private void checkTaskNumber(int taskNumber) throws ChaiException {
        if (tasks.isEmpty()) {
            ChaiException.taskListCannotBeEmpty();
        }
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            ChaiException.taskNumberOutOfRange(tasks.size());
        }
    }

    public void findTasks(String taskName) throws ChaiException {
        if (tasks.isEmpty()) {
            ChaiException.taskListCannotBeEmpty();
        }
        if (taskName.isEmpty()) {
            ChaiException.taskDoesNotExist();
            return;
        }
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(taskName.toLowerCase())) {
                matchingTasks.add(task);
            }
        }
        UserInterface.showMatchingTaskMessage(matchingTasks);
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            UserInterface.showListEmpty();
        } else {
            UserInterface.showTaskList(tasks);
        }
    }
}