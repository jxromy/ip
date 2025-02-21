package chai.tasks;

import chai.exceptions.ChaiException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Storage {
    private static final String filePath = "data/tasks.txt";

    public List<Task> load() throws ChaiException {
        File file = new File(filePath);
        if (!file.exists()) {
            createFile(file);
        }

        try {
            return readTasksFromFile(file);
        } catch (ChaiException e) {
            throw new ChaiException("Error loading tasks from file: " + e.getMessage());
        }
    }

    private void createFile(File file) {
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating task file: " + e.getMessage());
        }
    }

    private List<Task> readTasksFromFile(File file) throws ChaiException {
        List<Task> tasks = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = parseTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            throw new ChaiException("Error loading tasks! " + e.getMessage());
        }
        return tasks;
    }

    private static Task parseTask(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) return null;

        String type = parts[0].trim();
        boolean isDone = parts[1].trim().equals("1");
        String description = parts[2].trim();

        if (description.isEmpty()) {
            return null;
        }

        switch (type) {
        case "T":
            return new Todo(description, isDone);
        case "D":
            return new Deadline(description, parts[3], isDone);
        case "E":
            return new Event(description, parts[3], parts[4], isDone);
        default:
            return null;
        }
    }

    public static void saveTasks(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Task task : tasks) {
                writer.write(task.toSaveFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}