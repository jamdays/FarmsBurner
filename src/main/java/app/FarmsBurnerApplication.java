package main.java.app;

import main.java.data_access.OpenWeatherAccess;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FarmsBurnerApplication {
    public static void main(String[] args) {
        var props = new Properties();
        var envFile = Paths.get(".env");
        try (var inputStream = Files.newInputStream(envFile)) {
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String apiKey = props.get("WAK").toString();
        //TODO MAKE A GENERAL DATA ACCESS FOR TESTING ETC
        final OpenWeatherAccess dao = new OpenWeatherAccess(apiKey);

        final AppBuilder builder = new AppBuilder();
        builder.setFarmDAO(dao)
                .addFarmView()
                .addPlantUseCase().build().setVisible(true);
        System.out.println(dao.getWeatherForCity("Toronto"));
    }
}
