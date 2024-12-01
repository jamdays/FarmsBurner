package main.java.app;

import main.java.data_access.OpenWeatherAccess;
import main.java.data_access.SaveFileAccess;
import main.java.interface_adapter.farm.*;
import main.java.interface_adapter.selecttool.SelectToolController;
import main.java.interface_adapter.selecttool.SelectToolPresenter;
import main.java.interface_adapter.selecttool.SelectToolViewModel;
import main.java.interface_adapter.sell.SellController;
import main.java.interface_adapter.sell.SellPresenter;
import main.java.interface_adapter.sell.SellViewModel;
import main.java.interface_adapter.toolmenu.*;
import main.java.interface_adapter.welcome.*;
import main.java.use_case.buytool.BuyToolInteractor;
import main.java.use_case.buytool.BuyToolOutputBoundary;
import main.java.use_case.claim.ClaimInteractor;
import main.java.use_case.claim.ClaimOutputBoundary;
import main.java.use_case.getweather.GetWeatherInteractor;
import main.java.use_case.getweather.GetWeatherOutputBoundary;
import main.java.use_case.harvest.HarvestInteractor;
import main.java.use_case.harvest.HarvestOutputBoundary;
import main.java.use_case.load.LoadInteractor;
import main.java.use_case.load.LoadOutputBoundary;
import main.java.use_case.plant.PlantInteractor;
import main.java.use_case.plant.PlantOutputBoundary;
import main.java.use_case.selecttool.SelectToolInteractor;
import main.java.use_case.selecttool.SelectToolOutputBoundary;
import main.java.use_case.sell.SellInteractor;
import main.java.use_case.sell.SellOutputBoundary;
import main.java.use_case.setcity.SetCityInteractor;
import main.java.use_case.setcity.SetCityOutputBoundary;
import main.java.use_case.upgradetool.UpgradeToolInteractor;
import main.java.use_case.upgradetool.UpgradeToolOutputBoundary;
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
    public static final int HEIGHT = 675;
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
    private GetWeatherInteractor weatherInteractor;
    private SetCityInteractor setCityInteractor;
    private LoadInteractor loadInteractor;
    private CardLayout cardLayout;
    private ViewManager viewManager;
    private ToolMenuViewModel toolMenuViewModel;
    private BuyToolInteractor buyToolInteractor;
    private UpgradeToolInteractor upgradeToolInteractor;
    private SellViewModel sellViewModel;
    private SellInteractor sellInteractor;
    private SelectToolViewModel selectToolViewModel;
    private SelectToolInteractor selectToolInteractor;


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


        final PlantController plantController = new PlantController(plantInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setPlantController(plantController);
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
        final WaterController controller = new WaterController(waterInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setWaterController(controller);
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
        final ClaimController controller = new ClaimController(claimInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setClaimController(controller);
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
        final FertilizeController controller = new FertilizeController(fertilizeInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setFertilizeController(controller);
        return this;
    }

    /**
     * Creates the objects for the Weather Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addWeatherUseCase() {
        final GetWeatherOutputBoundary weatherOutputBoundary = new WeatherPresenter(farmViewModel);
        weatherInteractor = new GetWeatherInteractor(weatherOutputBoundary, farmDAO);
        final WeatherController controller = new WeatherController(weatherInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setWeatherController(controller);
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
        final HarvestController controller = new HarvestController(harvestInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setHarvestController(controller);
        return this;
    }

    /**
     * Creates the DAO
     * @return this builder
     */
    public AppBuilder addFarmDAO(OpenWeatherAccess farmDAO) {
        this.farmDAO = farmDAO;
        return this;
    }

    /**
     * Creates the Save DAO
     * MUST BE CALLED BEFORE LOAD USE CASE
     * @return this builder
     */
    public AppBuilder addSaveDAO(SaveFileAccess saveDAO) {
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
        toolMenuViewModel = new ToolMenuViewModel();
        sellViewModel = new SellViewModel();
        selectToolViewModel = new SelectToolViewModel();
        farmView = new FarmView(farmViewModel, toolMenuViewModel, sellViewModel, selectToolViewModel);
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
            throw new RuntimeException("addWelcomeView must be called before addUseCase");
        }

        welcomeView.setSetCityController(setCityController);
        return this;
    }

    /**
     * Adds the Buy Controller Use Case
     * @return this builder
     */
    public AppBuilder addBuyToolUseCase() {
        final BuyToolOutputBoundary buyToolOutputBoundary = new BuyPresenter(toolMenuViewModel);
        buyToolInteractor = new BuyToolInteractor(buyToolOutputBoundary);

        final BuyController buyController = new BuyController(buyToolInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }

        farmView.setBuyController(buyController);
        return this;
    }


    /**
     * Adds the Upgrade Controller Use Case
     * @return this builder
     */
    public AppBuilder addUpgradeUseCase() {
        final UpgradeToolOutputBoundary upgradeToolOutputBoundary = new UpgradePresenter(toolMenuViewModel);
        upgradeToolInteractor = new UpgradeToolInteractor(upgradeToolOutputBoundary);

        final UpgradeController uogradeController = new UpgradeController(upgradeToolInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }

        farmView.setUpgradeController(uogradeController);
        return this;
    }

    /**
     * Adds the Sell Use Case
     * @return this builder
     */
    public AppBuilder addSellUseCase() {
        final SellOutputBoundary sellOutputBoundary = new SellPresenter(sellViewModel);
        sellInteractor = new SellInteractor(sellOutputBoundary);

        final SellController sellController = new SellController(sellInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }

        farmView.setSellController(sellController);
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
     * Adds the Select Tool Use Case
     * @return this builder
     */
    public AppBuilder addSelectToolUseCase() {
        final SelectToolOutputBoundary selectToolOutputBoundary = new SelectToolPresenter(selectToolViewModel);
        selectToolInteractor = new SelectToolInteractor(selectToolOutputBoundary);

        final SelectToolController selectToolController = new SelectToolController(selectToolInteractor);


        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }

        farmView.setSelectToolController(selectToolController);
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
        frame.add(views);
        frame.pack();
        frame.setSize(WIDTH, HEIGHT);
        return frame;

    }

}
