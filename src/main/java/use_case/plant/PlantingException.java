package main.java.use_case.plant;

/**
 * Exception thrown when there is an error accessing data
 */
public class PlantingException extends Exception {
    public PlantingException(String message) {
        super(message);
    }
}
