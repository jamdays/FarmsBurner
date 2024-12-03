package main.java.use_case.save;

/**
 * Exception thrown when there is an error accessing data.
 */
public class DataAccessException extends Exception {
    public DataAccessException(String message) {
        super(message);
    }
}
