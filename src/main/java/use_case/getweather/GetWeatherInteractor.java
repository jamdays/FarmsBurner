package main.java.use_case.getweather;

public class GetWeatherInteractor implements GetWeatherInputBoundary {
    private final GetWeatherOutputBoundary outputBoundary;

    public GetWeatherInteractor(GetWeatherOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public void execute() {
        outputBoundary.getWeather();
    }
}
