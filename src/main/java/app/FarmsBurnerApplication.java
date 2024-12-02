package main.java.app;

import javax.swing.UIManager;

import main.java.data_access.OpenWeatherAccess;
import main.java.data_access.OpenWeatherAccessInterface;
import main.java.app.AppBuilder;
import main.java.data_access.SaveFileAccess;

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
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        String apiKey = props.get("WAK").toString();
        //TODO MAKE A GENERAL DATA ACCESS FOR TESTING ETC
        final OpenWeatherAccess dao = new OpenWeatherAccess(apiKey);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        final AppBuilder builder = new AppBuilder();
        builder.
                addFarmDAO(dao).
                addSaveDAO(new SaveFileAccess()).
                addViewManager()
                .addWelcomeView()
                .addStartUseCase()
                .addSetCityUseCase()
                .addLoadUseCase()
                .addFarmView()
                .addSaveUseCase()
                .addSellUseCase()
                .addBuyToolUseCase()
                .addUpgradeUseCase()
                .addPlantUseCase().
                addClaimUseCase().
                addFertilizeUseCase().
                addWeatherUseCase().
                addHarvestUseCase().
                addWaterUseCase().
                addSelectToolUseCase().
                addLoadFarmUseCase().
                addSelectCropUseCase().
                addGetActiveToolUseCase().
                addUseToolUseCase().
                addSetCropUseCase().
                addGetToolBoughtUseCase().
                build().setVisible(true);
    }
}
