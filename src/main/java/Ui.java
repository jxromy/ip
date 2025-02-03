public class Ui {
    private static final String LINE = "____________________________________________________________";

    public static void showWelcomeMessage(String logo) {
        System.out.println(LINE + "\nHello! I'm Chai\n" + logo + "What can I do for you?\n" + LINE);
    }

    public static void showExitMessage() {
        System.out.println(LINE + "\nBye. Hope to see you again soon!\n" + LINE);
    }

    public static void showAddedMessage(String message) {
        System.out.println(LINE + "\nadded: " + message + "\n" + LINE);
    }

    public static void showListFullMessage() {
        System.out.println(LINE + "\nError: List is full!\n" + LINE);
    }

    public static void showInvalidNumberMessage() {
        System.out.println(LINE + "\nError: Please enter a valid task number!\n" + LINE);
    }

    public static void showOutOfRangeMessage() {
        System.out.println(LINE + "\nError: Task number out of range!\n" + LINE);
    }

    public static void showTaskMarkedMessage(Task task) {
        System.out.println(LINE + "\n Nice! I've marked this task as done:\n   " + task + "\n" + LINE);
    }

    public static void showTaskUnmarkedMessage(Task task) {
        System.out.println(LINE + "\n OK, I've marked this task as not done yet:\n   " + task + "\n" + LINE);
    }

    public static void showTaskList(Task[] list, int listIndex) {
        System.out.println(LINE);
        System.out.println(" Here are the tasks in your list:");
        for (int i = 0; i < listIndex; i++) {
            System.out.println(" " + (i + 1) + "." + list[i]);
        }
        System.out.println(LINE);
    }
}