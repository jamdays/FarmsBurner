package main.java.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.swing.UIManager;

import main.java.data_access.OpenWeatherAccess;
import main.java.data_access.SaveFileAccess;

/**
 * Main FarmsBurner application.
 */
public class FarmsBurnerApplication {
    /**
     * Main method used to run the whole program.
     * @param args .
     * @throws RuntimeException .
     */
    public static void main(String[] args) {
        var props = new Properties();
        var envFile = Paths.get(".env");
        try (var inputStream = Files.newInputStream(envFile)) {
            props.load(inputStream);
        }
        catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        String apiKey = props.get("WAK").toString();
        // TODO MAKE A GENERAL DATA ACCESS FOR TESTING ETC
        final OpenWeatherAccess dao = new OpenWeatherAccess(apiKey);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        final AppBuilder builder = new AppBuilder();
        builder
                .addFarmDataAccessObject(dao)
                .addSaveDataAccessObject(new SaveFileAccess())
                .addViewManager()
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
