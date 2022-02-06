package project.growupsmart.sources.exceptions;

public class CategoryAlreadyExists extends RuntimeException{
    public CategoryAlreadyExists(String message){
        super("Category already exists!");
    }
}
