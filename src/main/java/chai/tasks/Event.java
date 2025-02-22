package chai.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Event(String description, LocalDateTime start, LocalDateTime end) {
        super(description, false);
        this.start = start;
        this.end = end;
    }

    public Event(String description, LocalDateTime start, LocalDateTime end, boolean isDone) {
        super(description, isDone);
        this.start = start;
        this.end = end;
    }

    @Override
    public String getTaskType() {
        return "E";
    }

    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + description +
                " (from: " + start.format(OUTPUT_FORMAT) + " to: " + end.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String toSaveFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " +
                Storage.formatForStorage(start) + " | " + Storage.formatForStorage(end);
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}