package main.java.app;

import main.java.data_access.OpenWeatherAccess;
import main.java.interface_adapter.farm.FarmController;
import main.java.interface_adapter.farm.FarmPresenter;
import main.java.interface_adapter.farm.FarmViewModel;
import main.java.use_case.plant.PlantInteractor;
import main.java.use_case.plant.PlantOutputBoundary;
import main.java.use_case.water.WaterInteractor;
import main.java.use_case.water.WaterOutputBoundary;
import main.java.view.FarmView;

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


    /**
     * Creates the objects for the Plant Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addNoteView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addPlantUseCase() {
        final PlantOutputBoundary plantOutputBoundary = new FarmPresenter(farmViewModel);
        final WaterOutputBoundary waterOutputBoundary = new FarmPresenter(farmViewModel);
        plantInteractor = new PlantInteractor(plantOutputBoundary);
        waterInteractor = new WaterInteractor(waterOutputBoundary);
        final FarmController controller = new FarmController(plantInteractor, waterInteractor);
        if (farmView == null) {
            throw new RuntimeException("addNoteView must be called before addNoteUseCase");
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
        frame.getContentPane().setBackground(new Color(169, 152, 126));

        return frame;

    }

}
