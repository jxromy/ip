package chai.tasks;

public class Todo extends Task {
    public Todo(String description) {
        super(description, false);
    }

    public Todo(String description, boolean isDone) { // New constructor
        super(description, isDone);
    }

    @Override
    public String getTaskType() {
        return "T";
    }
}