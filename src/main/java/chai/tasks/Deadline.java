package chai.tasks;

/**
 * Represents a task with a deadline.
 * A deadline task includes a description and a due date.
 */
public class Deadline extends Task {
    private final String by;

    /**
     * Constructs a new Deadline task that is initially not done.
     *
     * @param description The description of the deadline task.
     * @param by The due date of the task.
     */
    public Deadline(String description, String by) {
        super(description, false);
        this.by = by;
    }

    /**
     * Constructs a new Deadline task with a specified completion status.
     *
     * @param description The description of the deadline task.
     * @param by The due date of the task.
     * @param isDone Whether the task is completed.
     */
    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + description + " (by: " + by + ")";
    }

    @Override
    public String toSaveFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}