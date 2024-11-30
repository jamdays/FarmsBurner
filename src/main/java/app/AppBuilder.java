package main.java.app;

import main.java.data_access.OpenWeatherAccess;
import main.java.data_access.SaveFileAccess;
import main.java.interface_adapter.farm.*;
import main.java.interface_adapter.welcome.*;
import main.java.use_case.claim.ClaimInteractor;
import main.java.use_case.claim.ClaimOutputBoundary;
import main.java.use_case.harvest.HarvestInteractor;
import main.java.use_case.harvest.HarvestOutputBoundary;
import main.java.use_case.load.LoadInteractor;
import main.java.use_case.load.LoadOutputBoundary;
import main.java.use_case.plant.PlantInteractor;
import main.java.use_case.plant.PlantOutputBoundary;
import main.java.use_case.setcity.SetCityInteractor;
import main.java.use_case.setcity.SetCityOutputBoundary;
import main.java.use_case.water.WaterInteractor;
import main.java.use_case.water.WaterOutputBoundary;
import main.java.view.FarmView;
import main.java.use_case.fertilize.FertilizeInteractor;
import main.java.use_case.fertilize.FertilizeOutputBoundary;
import main.java.view.ViewManager;
import main.java.view.WelcomeView;

import javax.swing.*;
import java.awt.*;

/**
 * Builder for farms burner
 */
public class AppBuilder {
    public static final int HEIGHT = 650;
    public static final int WIDTH = 1000;
    private OpenWeatherAccess farmDAO;
    private SaveFileAccess saveFileAccess;
    private FarmViewModel farmViewModel;
    private FarmView farmView;
    private JPanel views;
    private WelcomeViewModel welcomeViewModel;
    private WelcomeView welcomeView;
    private PlantInteractor plantInteractor;
    private WaterInteractor waterInteractor;
    private ClaimInteractor claimInteractor;
    private HarvestInteractor harvestInteractor;
    private FertilizeInteractor fertilizeInteractor;
    private SetCityInteractor setCityInteractor;
    private LoadInteractor loadInteractor;
    private CardLayout cardLayout;
    private ViewManager viewManager;


    /**
     * Creates the objects for the Plant Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addPlantUseCase() {
        final PlantOutputBoundary plantOutputBoundary = new PlantPresenter(farmViewModel);
        plantInteractor = new PlantInteractor(plantOutputBoundary);


        final FarmController controller = new FarmController(plantInteractor, waterInteractor, claimInteractor, fertilizeInteractor, harvestInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setFarmController(controller);
        return this;
    }

    /**
     * Creates the objects for the Water Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addWaterUseCase() {
        final WaterOutputBoundary waterOutputBoundary = new WaterPresenter(farmViewModel);
        waterInteractor = new WaterInteractor(waterOutputBoundary);
        final FarmController controller = new FarmController(plantInteractor, waterInteractor, claimInteractor, fertilizeInteractor, harvestInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setFarmController(controller);
        return this;
    }

    /**
     * Creates the objects for the Claim Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addClaimUseCase() {
        final ClaimOutputBoundary claimOutputBoundary = new ClaimPresenter(farmViewModel);
        claimInteractor = new ClaimInteractor(claimOutputBoundary);
        final FarmController controller = new FarmController(plantInteractor, waterInteractor, claimInteractor, fertilizeInteractor, harvestInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setFarmController(controller);
        return this;
    }

    /**
     * Creates the objects for the Fertilize Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addFertilizeUseCase() {
        final FertilizeOutputBoundary fertilizeOutputBoundary = new FertilizePresenter(farmViewModel);
        fertilizeInteractor = new FertilizeInteractor(fertilizeOutputBoundary);
        final FarmController controller = new FarmController(plantInteractor, waterInteractor, claimInteractor, fertilizeInteractor, harvestInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setFarmController(controller);
        return this;
    }

    /**
     * Creates the objects for the Harvest Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addHarvestUseCase() {
        final HarvestOutputBoundary harvestOutputBoundary = new HarvestPresenter(farmViewModel);
        harvestInteractor = new HarvestInteractor(harvestOutputBoundary);
        final FarmController controller = new FarmController(plantInteractor, waterInteractor, claimInteractor, fertilizeInteractor, harvestInteractor);

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
     * Creates the Save DAO
     * MUST BE CALLED BEFORE LOAD USE CASE
     * @return this builder
     */
    public AppBuilder adSaveDAO(SaveFileAccess saveDAO) {
        this.saveFileAccess = saveDAO;
        return this;
    }

    /**
     * Creates the FarmView and underlying FarmViewModel.
     * CALL SET VIEW MANAGER FIRST
     * @return this builder
     */
    public AppBuilder addFarmView() {
        farmViewModel = new FarmViewModel();
        farmView = new FarmView(farmViewModel);
        views.add(farmView, ViewManager.FARM);

        return this;
    }

    /**
     * Creates the WelcomeView and underlying WelcomeViewModel.
     * CALL SET VIEW MANAGER FIRST
     * @return this builder
     */
    public AppBuilder addWelcomeView() {
        welcomeView = new WelcomeView(welcomeViewModel);
        views.add(welcomeView, ViewManager.WELCOME);
        cardLayout.show(views, "welcome");

        return this;
    }

    /**
     * Adds the SetCity Use Case
     * The controllers are seperated for WelcomeView
     * @return this builder
     */
    public AppBuilder addSetCityUseCase() {
        final SetCityOutputBoundary setCityOutputBoundary = new SetCityPresenter(welcomeViewModel);
        setCityInteractor = new SetCityInteractor(setCityOutputBoundary);

        final SetCityController setCityController = new SetCityController(setCityInteractor);

        if (welcomeView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }

        welcomeView.setSetCityController(setCityController);
        return this;
    }

    /**
     * Adds the Load Use Case
     * The controllers are seperated for WelcomeView
     * @return this builder
     */
    public AppBuilder addLoadUseCase() {
        final LoadOutputBoundary loadOutputBoundary = new LoadPresenter(welcomeViewModel);
        loadInteractor = new LoadInteractor(saveFileAccess, loadOutputBoundary);

        final LoadController loadController = new LoadController(loadInteractor);


        if (welcomeView == null) {
            throw new RuntimeException("addWelcomeView must be called before addUseCase");
        }

        welcomeView.setLoadController(loadController);
        return this;
    }

    /**
     * Creates and adds the View Manager
     * Should be called first
     * @return this builder
     */
    public AppBuilder addViewManager() {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.
        cardLayout = new CardLayout();
        views = new JPanel(cardLayout);

        // The data for the views. This
        // will be changed by a presenter object that is reporting the
        // results from the use case. This is an observable, and will
        // be observed by the layout manager.
        welcomeViewModel = new WelcomeViewModel();

        /*
         The observer watching for changes in the welcomeViewModel. It will
         react to changes in application state by changing which view
         is showing. This is an anonymous object because we don't need to
         refer to it later.
        */
        viewManager = new ViewManager(views, cardLayout, welcomeViewModel);
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
        frame.add(views);
        frame.pack();
        return frame;

    }

}
