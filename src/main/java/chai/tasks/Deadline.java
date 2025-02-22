package chai.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private final LocalDateTime deadline;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Deadline(String description, LocalDateTime deadline) {
        super(description, false);
        this.deadline = deadline;
    }

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