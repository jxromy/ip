public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public boolean getDoneStatus() {
        return isDone;
    }

    public void setDoneStatus(boolean isDone) {
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        return isDone ? "[X]" : "[ ]";
    }

    public abstract String getTaskType();

    @Override
    public String toString() {
        return "[" + getTaskType() + "]" + getStatusIcon() + " " + description;
    }
}