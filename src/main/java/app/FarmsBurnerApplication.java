package main.java.app;

import main.java.data_access.OpenWeatherAccess;

public class FarmsBurnerApplication {
    public static void main(String[] args) {
        //TODO MAKE A GENERAL DATA ACCESS FOR TESTING ETC
        final OpenWeatherAccess dao = new OpenWeatherAccess(System.getenv("WAK"));

        final AppBuilder builder = new AppBuilder();
        builder.setFarmDAO(dao)
                .addFarmView()
                .addPlantUseCase().build().setVisible(true);
    }
}
