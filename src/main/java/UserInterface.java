import java.util.List;

public class UserInterface {
    private static final String LINE = "____________________________________________________________";

    public static void showWelcomeMessage(String logo) {
        System.out.println(LINE + "\nHello! I'm Chai\n" + logo + "What can I do for you?\n" + LINE);
    }

    public static void showExitMessage() {
        System.out.println(LINE + "\nBye. Hope to see you again soon!\n" + LINE);
    }

    public static void showOutOfRangeMessage(int max) {
        System.out.println(LINE + "\nError: Task number is out of range! (Valid range: 1 to " + max + ")\n" + LINE);
    }

    public static void showTaskList(List<Task> tasks) {
        System.out.println(LINE);
        System.out.println(" Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(" " + (i + 1) + "." + tasks.get(i));
        }
        System.out.println(LINE);
    }

    public static void showTaskAddedMessage(Task task, int size) {
        System.out.println(LINE + "\nGot it. I've added this task:\n " + task +
                "\nNow you have " + size + " tasks in the list.\n" + LINE);
    }

    public static void showTaskMarkedMessage(Task task) {
        System.out.println(LINE + "\nNice! I've marked this task as done:\n " + task + "\n" + LINE);
    }

    public static void showTaskUnmarkedMessage(Task task) {
        System.out.println(LINE + "\nOK, I've marked this task as not done yet:\n " + task + "\n" + LINE);
    }

    public static void showUnknownCommandMessage(String errorMessage) {
        System.out.println(LINE + "\nChai failure: " + errorMessage + '\n' + LINE);
    }
}