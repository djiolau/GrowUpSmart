package project.growupsmart.sources.exceptions;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException() {
        super("Value is invalid");
    }
}
