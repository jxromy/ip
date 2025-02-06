import java.util.Scanner;

public class Chai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ChaiBot bot = new ChaiBot();
        String input;
        String logo = "            ('-. .-.   ('-.              \n" +
                "           ( OO )  /  ( OO ).-.          \n" +
                "  '  .--./ |  | |  |  | \\-.  \\   |  |OO) \n" +
                "   .-----. ,--. ,--.  / . --. /  ,-.-')  \n" +
                "  |  |('-. |   .|  |.-'-'  |  |  |  |  \\ \n" +
                " /_) |OO  )|       | \\| |_.'  |  |  |(_/ \n" +
                " ||  |`-'| |  .-.  |  |  .-.  | ,|  |_.' \n" +
                " (_'  '--'\\ |  | |  |  |  | |  |(_|  |    \n" +
                "   `-----' `--' `--'  `--' `--'  `--'    \n";

        UserInterface.showWelcomeMessage(logo);

        boolean isRunning = true;
        while (isRunning) {
            input = in.nextLine().trim();
            isRunning = bot.handleCommand(input);
        }

        in.close();
    }
}