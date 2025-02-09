import java.util.Scanner;

public class Chai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ChaiBot bot = new ChaiBot();

        UserInterface.showWelcomeMessage();

        boolean isRunning = true;
        while (isRunning) {
            String input = in.nextLine().trim();
            try {
                isRunning = bot.handleCommand(input);
            } catch (ChaiException e) {
                UserInterface.showUnknownCommandMessage(e.getMessage());
            }
        }

        in.close();
    }
}