package chai.ui;

import chai.tasks.Task;

import java.util.List;

public class UserInterface {
    private static final String LINE = "____________________________________________________________";
    private static final String LOGO =
        "            ('-. .-.   ('-.              \n" +
        "           ( OO )  /  ( OO ).-.          \n" +
        "  '  .--./ |  | |  |  | \\-.  \\   |  |OO) \n" +
        "   .-----. ,--. ,--.  / . --. /  ,-.-')  \n" +
        "  |  |('-. |   .|  |.-'-'  |  |  |  |  \\ \n" +
        " /_) |OO  )|       | \\| |_.'  |  |  |(_/ \n" +
        " ||  |`-'| |  .-.  |  |  .-.  | ,|  |_.' \n" +
        " (_'  '--'\\ |  | |  |  |  | |  |(_|  |    \n" +
        "   `-----' `--' `--'  `--' `--'  `--'    \n";

    public static void showWelcomeMessage() {
        System.out.println(LINE + "\nHello! I'm Chai\n" + LOGO + "What can I do for you?\n" + LINE);
    }

    public static void showExitMessage() {
        System.out.println(LINE + "\nBye. Hope to see you again soon!\n" + LINE);
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

    public static void showTaskAlreadyMarkedMessage() {
        System.out.println(LINE + "\nOops, this task was already been done\n" + LINE);
    }

    public static void showTaskAlreadyUnmarkedMessage() {
        System.out.println(LINE + "\nSorry, this task has not been been done\n" + LINE);
    }

    public static void showUnknownCommandMessage(String errorMessage) {
        System.out.println(LINE + "\nChai failure: " + errorMessage + '\n' + LINE);
    }
}