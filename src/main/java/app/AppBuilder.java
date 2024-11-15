package main.java.app;

import main.java.data_access.OpenWeatherAccess;
import main.java.interface_adapter.farm.FarmController;
import main.java.interface_adapter.farm.FarmPresenter;
import main.java.interface_adapter.farm.FarmViewModel;
import main.java.use_case.claim.ClaimInputBoundary;
import main.java.use_case.claim.ClaimInteractor;
import main.java.use_case.claim.ClaimOutputBoundary;
import main.java.use_case.plant.PlantInteractor;
import main.java.use_case.plant.PlantOutputBoundary;
import main.java.use_case.water.WaterInteractor;
import main.java.use_case.water.WaterOutputBoundary;
import main.java.view.FarmView;
import main.java.use_case.fertilize.FertilizeInteractor;
import main.java.use_case.fertilize.FertilizeOutputBoundary;

import javax.swing.*;
import java.awt.*;

/**
 * Builder for farms burner
 */
public class AppBuilder {
    public static final int HEIGHT = 1000;
    public static final int WIDTH = 1000;
    private OpenWeatherAccess farmDAO;
    private FarmViewModel farmViewModel;
    private FarmView farmView;
    private PlantInteractor plantInteractor;
    private WaterInteractor waterInteractor;
    private ClaimInteractor claimInteractor;
    private FertilizeInteractor fertilizeInteractor;


    /**
     * Creates the objects for the Plant Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addPlantUseCase() {
        final PlantOutputBoundary plantOutputBoundary = new FarmPresenter(farmViewModel);
        final WaterOutputBoundary waterOutputBoundary = (WaterOutputBoundary) plantOutputBoundary;
        final ClaimOutputBoundary claimOutputBoundary = (ClaimOutputBoundary) waterOutputBoundary;
        final FertilizeOutputBoundary fertilizeOutputBoundary = (FertilizeOutputBoundary) claimOutputBoundary;
        plantInteractor = new PlantInteractor(plantOutputBoundary);
        waterInteractor = new WaterInteractor(waterOutputBoundary);
        claimInteractor = new ClaimInteractor(claimOutputBoundary);
        fertilizeInteractor= new FertilizeInteractor(fertilizeOutputBoundary);

        final FarmController controller = new FarmController(plantInteractor, waterInteractor, claimInteractor, fertilizeInteractor);
        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setFarmController(controller);
        return this;
    }

    /**
     * Creates the DAO
     * @return this builder
     */
    public AppBuilder setFarmDAO(OpenWeatherAccess farmDAO) {
        this.farmDAO = farmDAO;
        return this;
    }

    /**
     * Creates the FarmView and underlying FarmViewModel.
     * @return this builder
     */
    public AppBuilder addFarmView() {
        farmViewModel = new FarmViewModel();
        farmView = new FarmView(farmViewModel);
        return this;
    }
    /**
     * Builds the application.
     * @return the JFrame for the application
     */
    public JFrame build() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Farms Burner");
        frame.setSize(WIDTH, HEIGHT);
        frame.add(farmView);

        return frame;

    }

}
