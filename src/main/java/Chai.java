import java.util.Arrays;
import java.util.Scanner;

public class Chai {
    static String[] list = new String[100];
    static int listIndex = 0;

    public static void getList() {
        System.out.println("____________________________________________________________");
        for (int i = 0; i < listIndex; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }
        System.out.println("____________________________________________________________");
    }

    public static void echo(String message) {
        System.out.println("____________________________________________________________\n" +
                "added: " + message + "\n" +
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
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("____________________________________________________________\n" +
                "Hello! I'm Chai\n" + logo + "What can I do for you?\n" +
                "____________________________________________________________");

        while (true) {
            input = in.nextLine();
            if (input.equals("bye")) {
                System.out.println("____________________________________________________________\n" +
                        "Bye. Hope to see you again soon!\n" +
                        "____________________________________________________________");
                break;
            } else if (input.equals("list")) {
                getList();
            } else {
                if (listIndex >= list.length) {
                    System.out.println("__________________________________________________________\n" +
                             "List is full!\n" +
                            "______________________________________________________________");
                } else {
                    list[listIndex] = input;
                    echo(list[listIndex]);
                    listIndex++;
                }
            }
        }
        in.close();
    }
}

