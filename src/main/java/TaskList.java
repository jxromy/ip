public class TaskList {
    private static final int MAX_SIZE = 100;
    private String[] list;
    private int listIndex;

    public TaskList() {
        this.list = new String[MAX_SIZE];
        this.listIndex = 0;
    }

    public boolean addTask(String task) {
        if (listIndex >= MAX_SIZE) {
            return false;
        }
        list[listIndex++] = task;
        return true;
    }

    public void printTasks() {
        Ui.showTaskList(list, listIndex);
    }
}