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
        System.out.println(LINE + "\nList is full!\n" + LINE);
    }

    public static void showTaskList(String[] list, int listIndex) {
        System.out.println(LINE);
        for (int i = 0; i < listIndex; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }
        System.out.println(LINE);
    }
}