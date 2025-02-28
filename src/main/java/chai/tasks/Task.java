package chai.tasks;

/**
 * Abstract base class for all task types.
 * A task contains a description and a completion status.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task with a description and an initial completion status.
     *
     * @param description The description of the task.
     * @param isDone Whether the task is completed.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Converts the task into a format suitable for saving to a file.
     *
     * @return A formatted string representing the task.
     */
    public abstract String toSaveFormat();

    /**
     * Gets the completion status of the task.
     *
     * @return {@code true} if the task is completed, otherwise {@code false}.
     */
    public boolean getDoneStatus() {
        return isDone;
    }

    /**
     * Sets the completion status of the task.
     *
     * @param isDone {@code true} if the task is completed, otherwise {@code false}.
     */
    public void setDoneStatus(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Returns a status icon indicating if the task is completed.
     *
     * @return "[X]" if completed, "[ ]" if not completed.
     */
    public String getStatusIcon() {
        return isDone ? "[X]" : "[ ]";
    }

    /**
     * Gets the type of the task (e.g. "T" for Todo, "D" for Deadline, "E" for Event).
     *
     * @return A string representing the task type.
     */
    public abstract String getTaskType();

    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + description;
    }
}