package chai.tasks;

import chai.exceptions.ChaiException;
import chai.ui.UserInterface;
import java.util.List;

/**
 * Manages a list of tasks and provides operations to modify the list.
 */
public class TaskList {
    private List<Task> tasks;

    /**
     * Constructs a TaskList with an initial list of tasks.
     *
     * @param tasks The list of tasks to initialize with.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a new task to the list and saves the updated list.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
        Storage.saveTasks(tasks);
        UserInterface.showTaskAddedMessage(task, tasks.size());
    }

    /**
     * Marks a task as completed.
     *
     * @param taskNumber The index of the task to mark as done.
     * @throws ChaiException If the task number is out of bounds.
     */
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

    /**
     * Marks a task as not completed.
     *
     * @param taskNumber The index of the task to unmark.
     * @throws ChaiException If the task number is out of bounds.
     */
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

    /**
     * Deletes a task from the list.
     *
     * @param taskNumber The index of the task to delete.
     * @throws ChaiException If the task number is out of bounds.
     */
    public void deleteTask(int taskNumber) throws ChaiException {
        checkTaskNumber(taskNumber);
        Task removedTask = tasks.remove(taskNumber - 1);
        Storage.saveTasks(tasks);
        UserInterface.showTaskDeletedMessage(removedTask, tasks.size());
    }

    /**
     * Validates that a task number is within range.
     *
     * @param taskNumber The index of the task to check.
     * @throws ChaiException If the task list is empty or the number is invalid.
     */
    private void checkTaskNumber(int taskNumber) throws ChaiException {
        if (tasks.isEmpty()) {
            ChaiException.taskListCannotBeEmpty();
        }
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            ChaiException.taskNumberOutOfRange(tasks.size());
        }
    }

    /**
     * Prints all tasks in the list.
     */
    public void printTasks() {
        if (tasks.isEmpty()) {
            UserInterface.showListEmpty();
        } else {
            UserInterface.showTaskList(tasks);
        }
    }
}