package chai.exceptions;

public class ChaiException extends Exception {
    public ChaiException(String message) {
        super(message);
    }

    // TaskList
    public static void taskListCannotBeEmpty() throws ChaiException {
        throw new ChaiException("You have no tasks!");
    }

    public static void taskNumberOutOfRange(int max) throws ChaiException {
        throw new ChaiException("Task number is out of range! (Valid range: 1 to " + max + ")");
    }

    public static void taskDoesNotExist() throws ChaiException {
        throw new ChaiException("Task not found");
    }

    // ChaiBot
    public static void descriptionCannotBeEmpty() throws ChaiException {
            throw new ChaiException("What is your task?");
    }

    public static void missingArgument(String argument) throws ChaiException {
        throw new ChaiException("You need to specify a " + argument + "!");
    }

    public static void incorrectFormat(String message) throws ChaiException {
        throw new ChaiException(message);
    }
}