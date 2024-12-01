package main.java.use_case.getweather;

public class InvalidCityException extends RuntimeException {
  public InvalidCityException(String message) {
    super(message);
  }
}
