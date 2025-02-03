import java.util.Scanner;

public class ChaiBot {
    private TaskList taskList;
    private Scanner scanner;

    public ChaiBot() {
        this.taskList = new TaskList();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String logo = "            ('-. .-.   ('-.              \n" +
                "           ( OO )  /  ( OO ).-.          \n" +
                "  '  .--./ |  | |  |  | \\-.  \\   |  |OO) \n" +
                "   .-----. ,--. ,--.  / . --. /  ,-.-')  \n" +
                "  |  |('-. |   .|  |.-'-'  |  |  |  |  \\ \n" +
                " /_) |OO  )|       | \\| |_.'  |  |  |(_/ \n" +
                " ||  |`-'| |  .-.  |  |  .-.  | ,|  |_.' \n" +
                " (_'  '--'\\ |  | |  |  |  | |  |(_|  |    \n" +
                "   `-----' `--' `--'  `--' `--'  `--'    \n";

        Ui.showWelcomeMessage(logo);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                Ui.showExitMessage();
                break;
            } else if (input.equals("list")) {
                taskList.printTasks();
            } else {
                if (taskList.addTask(input)) {
                    Ui.showAddedMessage(input);
                } else {
                    Ui.showListFullMessage();
                }
            }
        }
        scanner.close();
    }
}