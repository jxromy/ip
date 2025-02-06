public class Event extends Task {
    private String from;
    private String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getTaskType() {
        return "E";
    }

    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + description +
                " (from: " + from + " to: " + to + ")";
    }
}