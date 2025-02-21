package chai;

import chai.exceptions.ChaiException;
import chai.tasks.Parser;
import chai.tasks.Storage;
import chai.tasks.Task;
import chai.tasks.TaskList;
import chai.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chai {
    private Storage storage;
    private TaskList tasks;
    private Parser parser;

    public Chai(String filePath) throws ChaiException {
        storage = new Storage(filePath);

        List<Task> loadedTasks;
        try {
            loadedTasks = storage.load();
        } catch (ChaiException e) {
            UserInterface.showLoadingError();
            loadedTasks = new ArrayList<>();
        }

        tasks = new TaskList(loadedTasks, storage);
        parser = new Parser(tasks);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        UserInterface.showWelcomeMessage();

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

    public static void main(String[] args) throws ChaiException {
        new Chai("data/tasks.txt").run();
    }
}