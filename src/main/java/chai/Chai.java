package chai;

import chai.exceptions.ChaiException;
import chai.tasks.Parser;
import chai.tasks.Storage;
import chai.tasks.TaskList;
import chai.ui.UserInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Chai {
    private Storage storage;
    private TaskList tasks;
    private Parser parser;

    public Chai() {
        storage = new Storage();
        try {
            tasks = new TaskList(storage.load());
        } catch (ChaiException e) {
            UserInterface.showLoadingError();
        }
        parser = new Parser(tasks);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        UserInterface.showWelcomeMessage(LocalDateTime.now().format(OUTPUT_FORMAT));
        boolean isRunning = true;
        while (isRunning) {
            String input = scanner.nextLine().trim();
            try {
                isRunning = parser.parse(input);
            } catch (ChaiException e) {
                UserInterface.showUnknownCommandMessage(e.getMessage());
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Chai().run();
    }
}