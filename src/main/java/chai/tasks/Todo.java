package chai.tasks;

/**
 * Represents a simple task without a specific deadline or time range.
 */
public class Todo extends Task {

    /**
     * Constructs a Todo task that is initially not done.
     *
     * @param description The description of the Todo task.
     */
    public Todo(String description) {
        super(description, false);
    }

    /**
     * Constructs a Todo task with a specified completion status.
     *
     * @param description The description of the Todo task.
     * @param isDone Whether the task is completed.
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String getTaskType() {
        return "T";
    }

    @Override
    public String toSaveFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}