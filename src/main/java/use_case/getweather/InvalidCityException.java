package main.java.use_case.getweather;

/**
 * Invalid city exception.
 */
public class InvalidCityException extends RuntimeException {
    public InvalidCityException(String message) {
        super(message);
    }
}
