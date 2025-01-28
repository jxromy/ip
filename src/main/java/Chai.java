import java.util.Scanner;

public class Chai {
    public static void echo(String message) {
        System.out.println("____________________________________________________________\n" +
                message + "\n" +
                "____________________________________________________________\n");
    }

    public static void main(String[] args) {
        String logo = "            ('-. .-.   ('-.              \n" +
                "           ( OO )  /  ( OO ).-.          \n" +
                "  '  .--./ |  | |  |  | \\-.  \\   |  |OO) \n" +
                "   .-----. ,--. ,--.  / . --. /  ,-.-')  \n" +
                "  |  |('-. |   .|  |.-'-'  |  |  |  |  \\ \n" +
                " /_) |OO  )|       | \\| |_.'  |  |  |(_/ \n" +
                " ||  |`-'| |  .-.  |  |  .-.  | ,|  |_.' \n" +
                " (_'  '--'\\ |  | |  |  |  | |  |(_|  |    \n" +
                "   `-----' `--' `--'  `--' `--'  `--'    \n";

        System.out.println("____________________________________________________________\n" +
                "Hello! I'm Chai\n" + logo + "What can I do for you?\n" +
                "____________________________________________________________");

        Scanner in = new Scanner(System.in);
        String input;

        while (true) {
            input = in.nextLine();
            if (input.equals("bye")) {
                System.out.println("____________________________________________________________\n" +
                        "Bye. Hope to see you again soon!\n" +
                        "____________________________________________________________");
                break;
            }
            echo(input);
        }
        in.close();
    }
}

