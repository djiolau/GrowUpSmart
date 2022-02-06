package project.growupsmart.sources.exceptions;

public class TaskAlreadyExistsException extends RuntimeException{
    public TaskAlreadyExistsException(String message){
        super("Task already exists!");
    }
}
