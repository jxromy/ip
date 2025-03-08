package chai.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a deadline.
 * A deadline task includes a description and a due date.
 */
public class Deadline extends Task {
    private final LocalDateTime deadline;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Constructs a new Deadline task that is initially not done.
     *
     * @param description The description of the deadline task.
     * @param deadline The due date of the task.
     */
    public Deadline(String description, LocalDateTime deadline) {
        super(description, false);
        this.deadline = deadline;
    }

    /**
     * Constructs a new Deadline task with a specified completion status.
     *
     * @param description The description of the deadline task.
     * @param deadline The due date of the task.
     * @param isDone Whether the task is completed.
     */
    public Deadline(String description, LocalDateTime deadline, boolean isDone) {
        super(description, isDone);
        this.deadline = deadline;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + description + " (by: " + deadline.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String toSaveFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + Storage.formatForStorage(deadline);
    }
}