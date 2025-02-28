package chai.tasks;

import chai.exceptions.ChaiException;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Storage {
    private static final String FILE_PATH = "data/tasks.txt";
    private static final DateTimeFormatter STORAGE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public List<Task> load() throws ChaiException {
        File file = new File(FILE_PATH);
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

    private static LocalDateTime parseStoredDate(String dateStr) {
        try {
            return LocalDateTime.parse(dateStr, STORAGE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Invalid stored date format: " + dateStr, dateStr, 0);
        }
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

        try {
            switch (type) {
            case "T":
                return new Todo(description, isDone);
            case "D":
                LocalDateTime deadlineTime = parseStoredDate(parts[3].trim());
                return new Deadline(description, deadlineTime, isDone);
            case "E":
                LocalDateTime startTime = parseStoredDate(parts[3].trim());
                LocalDateTime endTime = parseStoredDate(parts[4].trim());
                return new Event(description, startTime, endTime, isDone);
            default:
                return null;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing stored date: " + e.getMessage());
            return null;
        }
    }

    public static void saveTasks(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Task task : tasks) {
                writer.write(task.toSaveFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static String formatForStorage(LocalDateTime dateTime) {
        return dateTime.format(STORAGE_FORMAT);
    }
}