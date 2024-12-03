package main.java.app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import main.java.data_access.OpenWeatherAccess;
import main.java.data_access.OpenWeatherAccessInterface;
import main.java.data_access.SaveFileAccess;
import main.java.interface_adapter.farm.ClaimController;
import main.java.interface_adapter.farm.ClaimPresenter;
import main.java.interface_adapter.farm.FarmViewModel;
import main.java.interface_adapter.farm.FertilizeController;
import main.java.interface_adapter.farm.FertilizePresenter;
import main.java.interface_adapter.farm.GetActiveToolController;
import main.java.interface_adapter.farm.GetActiveToolPresenter;
import main.java.interface_adapter.farm.HarvestController;
import main.java.interface_adapter.farm.HarvestPresenter;
import main.java.interface_adapter.farm.LoadFarmController;
import main.java.interface_adapter.farm.LoadFarmPresenter;
import main.java.interface_adapter.farm.PlantController;
import main.java.interface_adapter.farm.PlantPresenter;
import main.java.interface_adapter.farm.SaveController;
import main.java.interface_adapter.farm.SavePresenter;
import main.java.interface_adapter.farm.SetCropController;
import main.java.interface_adapter.farm.SetCropPresenter;
import main.java.interface_adapter.farm.UseToolController;
import main.java.interface_adapter.farm.UseToolPresenter;
import main.java.interface_adapter.farm.WaterController;
import main.java.interface_adapter.farm.WaterPresenter;
import main.java.interface_adapter.farm.WeatherController;
import main.java.interface_adapter.farm.WeatherPresenter;
import main.java.interface_adapter.selectcrop.SelectCropController;
import main.java.interface_adapter.selectcrop.SelectCropPresenter;
import main.java.interface_adapter.selectcrop.SelectCropViewModel;
import main.java.interface_adapter.selecttool.SelectToolController;
import main.java.interface_adapter.selecttool.SelectToolPresenter;
import main.java.interface_adapter.selecttool.SelectToolViewModel;
import main.java.interface_adapter.sell.*;
import main.java.interface_adapter.toolmenu.BuyController;
import main.java.interface_adapter.toolmenu.BuyPresenter;
import main.java.interface_adapter.toolmenu.GetToolBoughtController;
import main.java.interface_adapter.toolmenu.GetToolBoughtPresenter;
import main.java.interface_adapter.toolmenu.ToolMenuViewModel;
import main.java.interface_adapter.toolmenu.UpgradeController;
import main.java.interface_adapter.toolmenu.UpgradePresenter;
import main.java.interface_adapter.welcome.LoadController;
import main.java.interface_adapter.welcome.LoadPresenter;
import main.java.interface_adapter.welcome.SetCityController;
import main.java.interface_adapter.welcome.SetCityPresenter;
import main.java.interface_adapter.welcome.StartController;
import main.java.interface_adapter.welcome.StartPresenter;
import main.java.interface_adapter.welcome.WelcomeViewModel;
import main.java.use_case.buytool.BuyToolInteractor;
import main.java.use_case.buytool.BuyToolOutputBoundary;
import main.java.use_case.claim.ClaimInteractor;
import main.java.use_case.claim.ClaimOutputBoundary;
import main.java.use_case.fertilize.FertilizeInteractor;
import main.java.use_case.fertilize.FertilizeOutputBoundary;
import main.java.use_case.getactivetool.GetActiveToolInteractor;
import main.java.use_case.getactivetool.GetActiveToolOutputBoundary;
import main.java.use_case.getstorage.GetStorageInteractor;
import main.java.use_case.getstorage.GetStorageOutputBoundary;
import main.java.use_case.gettoolbought.GetToolBoughtInteractor;
import main.java.use_case.gettoolbought.GetToolBoughtOutputBoundary;
import main.java.use_case.getweather.GetWeatherInteractor;
import main.java.use_case.getweather.GetWeatherOutputBoundary;
import main.java.use_case.harvest.HarvestInteractor;
import main.java.use_case.harvest.HarvestOutputBoundary;
import main.java.use_case.load.LoadInteractor;
import main.java.use_case.load.LoadOutputBoundary;
import main.java.use_case.loadFarm.LoadFarmInteractor;
import main.java.use_case.loadFarm.LoadFarmOutputBoundary;
import main.java.use_case.plant.PlantInteractor;
import main.java.use_case.plant.PlantOutputBoundary;
import main.java.use_case.save.SaveInteractor;
import main.java.use_case.save.SaveOutputBoundary;
import main.java.use_case.selectcrop.SelectCropInteractor;
import main.java.use_case.selectcrop.SelectCropOutputBoundary;
import main.java.use_case.selecttool.SelectToolInteractor;
import main.java.use_case.selecttool.SelectToolOutputBoundary;
import main.java.use_case.sell.SellInteractor;
import main.java.use_case.sell.SellOutputBoundary;
import main.java.use_case.setcity.SetCityInteractor;
import main.java.use_case.setcity.SetCityOutputBoundary;
import main.java.use_case.setcrop.SetCropInteractor;
import main.java.use_case.setcrop.SetCropOutputBoundary;
import main.java.use_case.start.StartInteractor;
import main.java.use_case.start.StartOutputBoundary;
import main.java.use_case.upgradetool.UpgradeToolInteractor;
import main.java.use_case.upgradetool.UpgradeToolOutputBoundary;
import main.java.use_case.usetool.UseToolInteractor;
import main.java.use_case.usetool.UseToolOutputBoundary;
import main.java.use_case.water.WaterInteractor;
import main.java.use_case.water.WaterOutputBoundary;
import main.java.view.FarmView;
import main.java.view.ViewManager;
import main.java.view.WelcomeView;

/**
 * Builder for farms burner.
 */
public class AppBuilder {
    // CONSTANTS
    public static final int HEIGHT = 675;
    public static final int WIDTH = 1000;
    // PANELS
    private JPanel views;
    private CardLayout cardLayout;
    private ViewManager viewManager;
    // DAOS
    private OpenWeatherAccessInterface farmDataAccessObject;
    private SaveFileAccess saveFileAccess;
    // THE WELCOME VIEW, MODEL, AND INTERACTORS
    private WelcomeView welcomeView;
    private WelcomeViewModel welcomeViewModel;
    private SetCityInteractor setCityInteractor;
    private LoadInteractor loadInteractor;
    private StartInteractor startInteractor;
    // FARM VIEW, MODEL, AND INTERACTORS
    private FarmView farmView;
    private FarmViewModel farmViewModel;
    private PlantInteractor plantInteractor;
    private WaterInteractor waterInteractor;
    private ClaimInteractor claimInteractor;
    private HarvestInteractor harvestInteractor;
    private FertilizeInteractor fertilizeInteractor;
    private GetWeatherInteractor weatherInteractor;
    private SaveInteractor saveInteractor;
    private LoadFarmInteractor loadFarmInteractor;
    private GetActiveToolInteractor getActiveToolInteractor;
    private UseToolInteractor useToolInteractor;
    private SetCropInteractor setCropInteractor;
    // TOOL MENU VIEW, MODEL, AND INTERACTORS
    private ToolMenuViewModel toolMenuViewModel;
    private BuyToolInteractor buyToolInteractor;
    private UpgradeToolInteractor upgradeToolInteractor;
    private GetToolBoughtInteractor getToolBoughtInteractor;
    // SELL MENU VIEW, MODEL, AND INTERACTORS
    private SellViewModel sellViewModel;
    private SelectToolViewModel selectToolViewModel;
    private SellInteractor sellInteractor;
    private SelectToolInteractor selectToolInteractor;
    private SelectCropViewModel selectCropViewModel;
    private SelectCropInteractor selectCropInteractor;
    private GetStorageInteractor getStorageInteractor;

    /**
     * Creates the objects for the Save Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addSaveUseCase() {
        final SaveOutputBoundary saveOutputBoundary = new SavePresenter(farmViewModel);
        saveInteractor = new SaveInteractor(saveFileAccess, saveOutputBoundary, farmDataAccessObject);

        final SaveController saveController = new SaveController(saveInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }

        farmView.setSaveController(saveController);
        return this;
    }

    /**
     * Creates the objects for the Plant Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addPlantUseCase() {
        final PlantOutputBoundary plantOutputBoundary = new PlantPresenter(farmViewModel);
        plantInteractor = new PlantInteractor(plantOutputBoundary, farmDataAccessObject);

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
     * Creates the objects for the Set Crop Use Case and connects the FarmView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addFarmView
     */
    public AppBuilder addSetCropUseCase() {
        final SetCropOutputBoundary setCropOutputBoundary = new SetCropPresenter(farmViewModel);
        setCropInteractor = new SetCropInteractor(setCropOutputBoundary);
        final SetCropController controller = new SetCropController(setCropInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setSetCropController(controller);
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
        weatherInteractor = new GetWeatherInteractor(weatherOutputBoundary, farmDataAccessObject);
        final WeatherController controller = new WeatherController(weatherInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        if (welcomeView == null) {
            throw new RuntimeException("addWelcomeView must be called before addUseCase");
        }

        farmView.setWeatherController(controller);
        welcomeView.setWeatherController(controller);
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
     * Creates the DAO.
     * @return this builder
     */
    public AppBuilder addFarmDataAccessObject(OpenWeatherAccessInterface farmDataAccessObject) {
        this.farmDataAccessObject = farmDataAccessObject;
        return this;
    }

    /**
     * Creates the Save DAO.
     * MUST BE CALLED BEFORE LOAD USE CASE
     * @param saveDataAccessObject .
     * @return this builder
     */
    public AppBuilder addSaveDataAccessObject(SaveFileAccess saveDataAccessObject) {
        this.saveFileAccess = saveDataAccessObject;
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
        selectCropViewModel = new SelectCropViewModel();
        farmView = new FarmView(farmViewModel, toolMenuViewModel, sellViewModel, selectToolViewModel,
                selectCropViewModel);
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
     * Creates the objects for the LoadFarm Use Case and connects the WelcomeView to its
     * controller.
     * <p>This method must be called after addWelcomeView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addWelcomeView
     */
    public AppBuilder addLoadFarmUseCase() {
        final LoadFarmOutputBoundary loadFarmOutputBoundary = new LoadFarmPresenter(farmViewModel);
        loadFarmInteractor = new LoadFarmInteractor(loadFarmOutputBoundary);
        final LoadFarmController controller = new LoadFarmController(loadFarmInteractor);

        if (welcomeView == null) {
            throw new RuntimeException("addWelcomeView must be called before addUseCase");
        }

        welcomeView.setLoadFarmController(controller);
        return this;
    }

    /**
     * Adds the SetCity Use Case.
     * The controllers are seperated for WelcomeView
     * @return this builder
     * @throws RuntimeException .
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
     * Adds the Buy Controller Use Case.
     * @return this builder
     * @throws RuntimeException .
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
     * Adds the GetToolBought Use Case.
     * @return this builder
     * @throws RuntimeException .
     */
    public AppBuilder addGetToolBoughtUseCase() {
        final GetToolBoughtOutputBoundary getToolBoughtOutputBoundary = new GetToolBoughtPresenter(toolMenuViewModel);
        getToolBoughtInteractor = new GetToolBoughtInteractor(getToolBoughtOutputBoundary);

        final GetToolBoughtController getToolBoughtController = new GetToolBoughtController(getToolBoughtInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }

        farmView.setGetToolBoughtController(getToolBoughtController);
        return this;
    }
    /**
     * Creates the objects for the Start Use Case and connects the WelcomeView to its
     * controller.
     * <p>This method must be called after addFarmView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addWelcomeView
     */

    public AppBuilder addStartUseCase() {
        final StartOutputBoundary startOutputBoundary = new StartPresenter(welcomeViewModel);
        startInteractor = new StartInteractor(startOutputBoundary);
        final StartController controller = new StartController(startInteractor);

        if (welcomeView == null) {
            throw new RuntimeException("addWelcomeView must be called before addUseCase");
        }
        welcomeView.setStartController(controller);
        return this;
    }

    /**
     * Adds the Upgrade Controller Use Case.
     * @return this builder
     * @throws RuntimeException .
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
     * Adds the Sell Use Case.
     * @return this builder
     * @throws RuntimeException .
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
     * Adds the Get Storage Use Case.
     * @return this builder
     * @throws RuntimeException .
     */
    public AppBuilder addGetStorageUseCase() {
        final GetStorageOutputBoundary getStorageOutputBoundary = new GetStoragePresenter(sellViewModel);
        getStorageInteractor = new GetStorageInteractor(getStorageOutputBoundary);

        final GetStorageController getStorageController = new GetStorageController(getStorageInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }

        farmView.setGetStorageController(getStorageController);
        return this;
    }

    /**
     * Adds the Load Use Case.
     * The controllers are seperated for WelcomeView
     * @return this builder
     * @throws RuntimeException .
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
     * Adds the Select Tool Use Case.
     * @return this builder
     * @throws RuntimeException .
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
     * Adds the get active Tool Use Case.
     * @return this builder
     * @throws RuntimeException .
     */
    public AppBuilder addGetActiveToolUseCase() {
        final GetActiveToolOutputBoundary getActiveToolOutputBoundary = new GetActiveToolPresenter(farmViewModel);
        getActiveToolInteractor = new GetActiveToolInteractor(getActiveToolOutputBoundary);
        final GetActiveToolController controller = new GetActiveToolController(getActiveToolInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setGetActiveToolController(controller);
        return this;
    }

    /**
     * Adds the useTool Use Case.
     * @return this builder
     * @throws RuntimeException .
     */
    public AppBuilder addUseToolUseCase() {
        final UseToolOutputBoundary useToolOutputBoundary = new UseToolPresenter(farmViewModel);
        useToolInteractor = new UseToolInteractor(useToolOutputBoundary, farmDataAccessObject);
        final UseToolController controller = new UseToolController(useToolInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }
        farmView.setUseToolController(controller);
        return this;
    }

    /**
     * Adds the Select Crop Use Case.
     * @return this builder
     * @throws RuntimeException .
     */
    public AppBuilder addSelectCropUseCase() {
        final SelectCropOutputBoundary selectCropOutputBoundary = new SelectCropPresenter(selectCropViewModel);
        selectCropInteractor = new SelectCropInteractor(selectCropOutputBoundary);

        final SelectCropController selectCropController = new SelectCropController(selectCropInteractor);

        if (farmView == null) {
            throw new RuntimeException("addFarmView must be called before addUseCase");
        }

        farmView.setSelectCropController(selectCropController);
        return this;
    }

    /**
     * Creates and adds the View Manager.
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
