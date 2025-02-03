public class TaskList {
    private static final int MAX_SIZE = 100;
    private Task[] list;
    private int listIndex;

    public TaskList() {
        this.list = new Task[MAX_SIZE];
        this.listIndex = 0;
    }

    public boolean addTask(String description) {
        if (listIndex >= MAX_SIZE) {
            return false;
        }
        list[listIndex++] = new Task(description);
        return true;
    }

    public void markTask(int taskNumber) {
        if (taskNumber < 1 || taskNumber > listIndex) {
            Ui.showOutOfRangeMessage();
            return;
        }
        list[taskNumber - 1].markAsDone();
        Ui.showTaskMarkedMessage(list[taskNumber - 1]);
    }

    public void unmarkTask(int taskNumber) {
        if (taskNumber < 1 || taskNumber > listIndex) {
            Ui.showOutOfRangeMessage();
            return;
        }
        list[taskNumber - 1].markAsNotDone();
        Ui.showTaskUnmarkedMessage(list[taskNumber - 1]);
    }

    public void printTasks() {
        Ui.showTaskList(list, listIndex);
    }
}