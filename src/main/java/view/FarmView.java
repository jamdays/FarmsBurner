package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.java.app.WindowBuilder;
import main.java.interface_adapter.farm.ClaimController;
import main.java.interface_adapter.farm.FarmViewModel;
import main.java.interface_adapter.farm.FarmState;
import main.java.interface_adapter.farm.FertilizeController;
import main.java.interface_adapter.farm.ForecastController;
import main.java.interface_adapter.farm.GetActiveToolController;
import main.java.interface_adapter.farm.HarvestController;
import main.java.interface_adapter.farm.PlantController;
import main.java.interface_adapter.farm.PowerRefundController;
import main.java.interface_adapter.farm.SaveController;
import main.java.interface_adapter.farm.SetCropController;
import main.java.interface_adapter.farm.UseToolController;
import main.java.interface_adapter.farm.WaterController;
import main.java.interface_adapter.farm.WeatherController;
import main.java.interface_adapter.selectcrop.SelectCropController;
import main.java.interface_adapter.selectcrop.SelectCropViewModel;
import main.java.interface_adapter.selecttool.SelectToolController;
import main.java.interface_adapter.selecttool.SelectToolViewModel;
import main.java.interface_adapter.sell.GetStorageController;
import main.java.interface_adapter.sell.SellController;
import main.java.interface_adapter.sell.SellViewModel;
import main.java.interface_adapter.toolmenu.BuyController;
import main.java.interface_adapter.toolmenu.GetBarnBucksController;
import main.java.interface_adapter.toolmenu.GetToolBoughtController;
import main.java.interface_adapter.toolmenu.ToolMenuViewModel;
import main.java.interface_adapter.toolmenu.UpgradeController;

/**
 * The view for the farm.
 */
public class FarmView extends JPanel implements ActionListener, PropertyChangeListener {
    private JLabel backgroundLabel;
    private FarmLabel power;
    private final int wet = 0B1;
    private final int claimed = 0B10;
    private final int snowy = 0B100;
    private final int planted = 0B1000;
    private final int alive = 0B100000;
    private final int fertilized = 0B1000000;
    private final int cropMask = 0B1100000000;
    private final int rice = 0B0100000000;
    private final int snowberry = 0B00000000000;
    private final int corn = 0B1100000000;
    private final int wheat = 0B1000000000;
    private final int ready = 0B10000000;
    private ClaimController claimController;
    private ForecastController forecastController;
    private FertilizeController fertilizeController;
    private HarvestController harvestController;
    private PlantController plantController;
    private WaterController waterController;
    private FarmLabel[][] farmLand;
    private FarmViewModel viewModel;
    private ToolMenuViewModel toolMenuViewModel;
    private BuyController buyController;
    private UpgradeController upgradeController;
    private SellViewModel sellViewModel;
    private SellController sellController;
    private SelectToolViewModel selectToolViewModel;
    private SelectToolController selectToolController;
    private WeatherController weatherController;
    private SelectCropViewModel selectCropViewModel;
    private SelectCropController selectCropController;
    private SaveController saveController;
    private UseToolController useToolController;
    private GetActiveToolController getActiveToolController;
    private SetCropController setCropController;
    private GetToolBoughtController getToolBoughtController;
    private GetStorageController getStorageController;
    private GetBarnBucksController getBarnBucksController;
    private PowerRefundController powerRefundController;

    public FarmView(FarmViewModel farmViewModel, ToolMenuViewModel toolMenuViewModel, SellViewModel sellViewModel, SelectToolViewModel selectToolViewModel, SelectCropViewModel selectCropViewModel) {
        // Add background as JLABEL to set images
        backgroundLabel = new JLabel();
        power = new FarmLabel("Power: 0");
        power.setFont(new Font("Press Start 2P", Font.BOLD, 20));
        power.setForeground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.add(backgroundLabel);
        // Navigation Bar
        this.toolMenuViewModel = toolMenuViewModel;
        this.sellViewModel = sellViewModel;
        this.selectToolViewModel = selectToolViewModel;
        viewModel = farmViewModel;
        viewModel.addPropertyChangeListener(this);
        this.setBackground(new Color(169, 152, 126));
        // FarmButton farmSettings = new FarmButton("≡");
        FarmButton save = new FarmButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveController.save();
                System.out.println("Save");
            }
        });
        FarmButton weather = new FarmButton("Weather");
        // TODO: add checkweather use case and implement popup window displaying result of API call
        weather.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> currWeatherForCity = weatherController.weather();
                String city = currWeatherForCity.get(0);
                String temp = currWeatherForCity.get(1);
                String conditions = currWeatherForCity.get(2);
                String cloudCoverage = currWeatherForCity.get(3);
                // test show results
                final WindowBuilder builder = new WindowBuilder();
                builder.addView(350, 280, new WeatherView(city, temp, conditions, cloudCoverage)).build()
                        .setVisible(true);
                }
        });
        FarmButton sell = new FarmButton("Sell");
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                SellView sellView = new SellView(sellViewModel, getStorageController, getBarnBucksController);
                builder.addView(350, 280, sellView).build().setVisible(true);
                sellView.setSellController(sellController);
            }
        });
        FarmButton buy = new FarmButton("Buy");
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                System.out.println(getToolBoughtController.toString());
                BuyView buyView = new BuyView(toolMenuViewModel, getToolBoughtController, getBarnBucksController);
                builder.addView(380, 300, buyView).build().setVisible(true);
                buyView.setBuyController(buyController);
                buyView.setUpgradeController(upgradeController);

            }
        });
        FarmButton help = new FarmButton("i");
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                builder.addView(300, 500, new Info()).build().setVisible(true);
            }
        });
        FarmButton forecast = new FarmButton("Forecast");
        forecast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                builder.addView(400, 500, new ForecastView(forecastController.forecast(), "Forecast"))
                        .build().setVisible(true);
            }
        });

        JPanel landPanel = new JPanel();
        landPanel.setLayout(new GridBagLayout());
        landPanel.setSize(new Dimension(1000, 800));
        landPanel.setBackground(new Color(169, 152, 126, 0));
        GridBagConstraints gbc = new GridBagConstraints();
        farmLand = new FarmLabel[16][20];
        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 20; col++) {
                final int r = row;
                final int c = col;
                FarmLabel cropLabel = new CropLabel("", 20, Color.BLACK);
                ImageIcon grass = new ImageIcon("src/main/resources/farmtile1.png");
                cropLabel.setIcon(new ImageIcon(grass.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                farmLand[r][c] = cropLabel;
                cropLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent mouseEvent) {
                        // if plot is clicked while shift is held down, claim land
                        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                            if ((mouseEvent.getModifiers() & 1) == 1) {
                                // make it so that if tiller is active, you till an area
                                if (getActiveToolController.getActiveTool().equalsIgnoreCase("tiller")) {
                                    int amt = useToolController.useTool("tiller", r, c);
                                    powerRefundController.powerRefund(amt);
                                }
                                else {
                                    claimController.claim(r, c);
                                }
                            }
                            // if plot is clicked while ctrl is held down, plant crop on plot
                            else if (mouseEvent.getModifiers() == 18) {
                                if (getActiveToolController.getActiveTool().equalsIgnoreCase("planter")) {
                                    int amt = useToolController.useTool("planter", r, c);
                                    powerRefundController.powerRefund(amt);
                                }
                                else {
                                    plantController.plantCrop(r, c);
                                }
                            }
                            // if plot is clicked while alt is held down, water plot
                            else if (mouseEvent.getModifiers() == 24) {
                                if (getActiveToolController.getActiveTool().equalsIgnoreCase("sprinkler")) {
                                    int amt = useToolController.useTool("sprinkler", r, c);
                                    powerRefundController.powerRefund(amt);
                                }
                                else {
                                    waterController.waterCrop(r, c);
                                }
                            }
                            // if plot is clicked while ctrl and alt are held down, fertilize crop
                            else if ((mouseEvent.getModifiers() & (18 | 24)) == (18 | 24)) {
                                if (getActiveToolController.getActiveTool().equalsIgnoreCase("fertilizer")) {
                                    int amt = useToolController.useTool("fertilizer", r, c);
                                    powerRefundController.powerRefund(amt);
                                }
                                else {
                                    fertilizeController.fertilize(r, c);
                                }
                            }
                            // if plot is clicked with nothing held down, harvest crop
                            else {
                                if (getActiveToolController.getActiveTool().equalsIgnoreCase("harvester")) {
                                    int amt = useToolController.useTool("harvester", r, c);
                                    powerRefundController.powerRefund(amt);
                                }
                                else {
                                    harvestController.harvestCrop(r, c);
                                }
                            }
                        }
                        else if (mouseEvent.getButton() == 3) {
                            if (getActiveToolController.getActiveTool().equalsIgnoreCase("sprinkler")) {
                                useToolController.useTool("sprinkler", r, c);
                            }
                            else {
                                waterController.waterCrop(r, c);
                            }
                        }
                    }
                });
                cropLabel.setSize(new Dimension(80, 80));
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.gridx = col;
                gbc.gridy = row;
                landPanel.add(cropLabel, gbc);
            }
        }

        // Tool and Plant Selector Panel
        JPanel footerPanel = new JPanel();
        // FarmLabel power = new FarmLabel("Power: 0");
        // FarmLabel barnBucks = new FarmLabel("Barn Bucks: 0");
        // footerPanel.add(power);
        // footerPanel.add(barnBucks);
        FarmButton cropSelector = new FarmButton("Choose Crop");

        cropSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                final WindowBuilder builder = new WindowBuilder();
                SelectCropView selectCropView = new SelectCropView(selectCropViewModel);
                selectCropView.setController(selectCropController);
                selectCropView.setCropController(setCropController);
                builder.addView(271, 250, selectCropView).build().setVisible(true);
            }
        });

        FarmButton toolSelector = new FarmButton("Choose Tool");

        toolSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                SelectToolView selectToolView = new SelectToolView(selectToolViewModel);
                selectToolView.setController(selectToolController);
                builder.addView(271, 250, selectToolView).build().setVisible(true);
            }
        });

        footerPanel.add(cropSelector);
        footerPanel.add(toolSelector);
        footerPanel.setBackground(new Color(169, 152, 126, 0));

        JPanel navBar = new JPanel();
        navBar.add(save);
        navBar.add(weather);
        navBar.add(forecast);
        navBar.add(sell);
        navBar.add(buy);
        navBar.add(help);
        navBar.setBackground(new Color(169, 152, 126, 0));

        backgroundLabel.setLayout(new BoxLayout(backgroundLabel, BoxLayout.Y_AXIS));
        backgroundLabel.add(navBar);
        backgroundLabel.add(landPanel);
        backgroundLabel.add(footerPanel);
        backgroundLabel.add(power);
        // JFrame frame = new JFrame("Farm View");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(741, 420);
        // frame.getContentPane().add(mainPanel);
        // frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final FarmState state = (FarmState) evt.getNewValue();
        power.setText("Power: " + state.getPower());
        if (evt.getPropertyName().equals("weather")) {
            String background = "/main/resources/background-";
            if (state.getDay() == 0) {
                background += "night";
            }
            else if (state.getDay() == 1) {
                background += "day";
            }
            else {
                background += "dawndusk.png";
                ImageIcon backgroundImage = new ImageIcon(background);
                System.out.println(background);
                this.backgroundLabel.setIcon(new ImageIcon(backgroundImage.getImage()));
                return;
            }
            switch (state.getWeather()) {
                case "Clear":
                    background += "clear";
                    break;
                case "Rain":
                case "Drizzle":
                    background += "rainy";
                    break;
                case "Snow":
                    background += "snowy";
                    break;
                case "Fog":
                case "Mist":
                case "Smoke":
                case "Haze":
                case "Dust":
                case "Sand":
                case "Squall":
                case "Ash":
                    background += "fog";
                    break;
                case "Thunderstorm":
                    background = "main/resources/background-thunderstorm";
                    break;
                default:
                    background += "cloudy";
            }
            background += ".png";
            ImageIcon backgroundImage = new ImageIcon(background);
            URL imgurl = FarmView.class.getResource(background);
            if (imgurl != null) {
                backgroundImage = new ImageIcon(imgurl);
            }
            System.out.println(background);
            this.backgroundLabel.setIcon(new ImageIcon(backgroundImage.getImage()));

        }
        Color green = new Color(20, 130, 50);
        Color dirt = new Color(75, 40, 40);
        Color wetDirt = new Color(50, 20, 20);
        for (int r = 0; r < state.getFarmLand().length; r++) {
            for (int c = 0; c < state.getFarmLand()[r].length; c++) {
                ImageIcon dirtImg = null;
                // if farmland is claimed, change button color to dirt
                if ((state.getFarmLand()[r][c] & claimed) == claimed) {
                    farmLand[r][c].removeAll();
                    farmLand[r][c].setFont(new Font("Press Start 2P", Font.PLAIN, 20));
                    farmLand[r][c].setBorder(new LineBorder(new Color(69, 44, 42)));
                    farmLand[r][c].setPreferredSize(new Dimension(25, 25));
                    // Snowy & Claimed
                    if ((state.getFarmLand()[r][c] & snowy) == snowy) {
                        String dirtImgicon = "/main/resources/snowytiles2.png";
                        URL imgurl = FarmView.class.getResource(dirtImgicon);
                        dirtImg = new ImageIcon("src/main/resources/snowytiles2.png");
                        if (imgurl != null) {
                            dirtImg = new ImageIcon(imgurl);
                        }
                        String snowdirturl = "/main/resources/snowytiles2.png";
                        imgurl = FarmView.class.getResource(snowdirturl);
                        ImageIcon snowyDirtImage = new ImageIcon("src/main/resources/snowytiles2.png");
                        if (imgurl != null) {
                            snowyDirtImage = new ImageIcon(imgurl);
                        }
                        farmLand[r][c].setIcon(new ImageIcon(snowyDirtImage.getImage()
                                .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                    }
                    else {
                        String dirtImgicon = "/main/resources/farmtile2.png";
                        URL imgurl = FarmView.class.getResource(dirtImgicon);
                        dirtImg = new ImageIcon("src/main/resources/farmtile2.png");
                        if (imgurl != null) {
                            dirtImg = new ImageIcon(imgurl);
                        }
                        String dirturl = "/main/resources/farmtile2.png";
                        imgurl = FarmView.class.getResource(dirturl);
                        ImageIcon dirtImage = new ImageIcon("src/main/resources/farmtile2.png");
                        if (imgurl != null) {
                            dirtImage = new ImageIcon(imgurl);
                        }
                        farmLand[r][c].setIcon(new ImageIcon(dirtImage.getImage()
                                .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                    }
                    // given the farmland is claimed, if it is wet as well as fertilized,
                    // set label image to wet and fertilized dirt
                    if ((state.getFarmLand()[r][c] & fertilized) == fertilized
                            && (state.getFarmLand()[r][c] & wet) == wet) {
                        // Snowy & Wet & Fertilized
                        if ((state.getFarmLand()[r][c] & snowy) == snowy) {
                            String dirtImgicon = "/main/resources/snowytiles5.png";
                            URL imgurl = FarmView.class.getResource(dirtImgicon);
                            dirtImg = new ImageIcon("src/main/resources/snowytiles5.png");
                            if (imgurl != null) {
                                dirtImg = new ImageIcon(imgurl);
                            }
                            String dirturl = "/main/resources/snowytiles5.png";
                            imgurl = FarmView.class.getResource(dirturl);
                            ImageIcon snowyDirtImage = new ImageIcon("src/main/resources/snowytiles5.png");
                            if (imgurl != null) {
                                snowyDirtImage = new ImageIcon(imgurl);
                            }
                            farmLand[r][c].setIcon(new ImageIcon(snowyDirtImage.getImage()
                                    .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                        }
                        else {
                            String dirtImgicon = "/main/resources/farmtile5.png";
                            URL imgurl = FarmView.class.getResource(dirtImgicon);
                            dirtImg = new ImageIcon("src/main/resources/farmtile5.png");
                            if (imgurl != null) {
                                dirtImg = new ImageIcon(imgurl);
                            }
                            String dirturl = "/main/resources/farmtile5.png";
                            imgurl = FarmView.class.getResource(dirturl);
                            ImageIcon wetfertilizeddirtImage = new ImageIcon("src/main/resources/farmtile5.png");
                            if (imgurl != null) {
                                wetfertilizeddirtImage= new ImageIcon(imgurl);
                            }
                            farmLand[r][c].setIcon(new ImageIcon(wetfertilizeddirtImage.getImage()
                                    .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                        }
                    }
                    // given the farmland is claimed, if it is wet but unfertilized,
                    // set label image to wet but unfertilized dirt
                    if (!((state.getFarmLand()[r][c] & fertilized) == fertilized)
                            && (state.getFarmLand()[r][c] & wet) == wet) {
                        // Snowy & Wet
                        if ((state.getFarmLand()[r][c] & snowy) == snowy) {
                            String dirtImgicon = "/main/resources/snowytiles3.png";
                            URL imgurl = FarmView.class.getResource(dirtImgicon);
                            dirtImg = new ImageIcon("src/main/resources/snowytiles3.png");
                            if (imgurl != null) {
                                dirtImg = new ImageIcon(imgurl);
                            }
                            String dirturl = "/main/resources/snowytiles3.png";
                            imgurl = FarmView.class.getResource(dirturl);
                            ImageIcon snowyDirtImage = new ImageIcon("src/main/resources/snowytiles3.png");
                            if (imgurl != null) {
                                snowyDirtImage= new ImageIcon(imgurl);
                            }
                            farmLand[r][c].setIcon(new ImageIcon(snowyDirtImage.getImage()
                                    .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                        }
                        else {
                            String dirtImgicon = "/main/resources/farmtile3.png";
                            URL imgurl = FarmView.class.getResource(dirtImgicon);
                            dirtImg = new ImageIcon("src/main/resources/farmtile3.png");
                            if (imgurl != null) {
                                dirtImg = new ImageIcon(imgurl);
                            }
                            String dirturl = "/main/resources/farmtile3.png";
                            imgurl = FarmView.class.getResource(dirturl);
                            ImageIcon wetdirtImage = new ImageIcon("src/main/resources/farmtile3.png");
                            if (imgurl != null) {
                                wetdirtImage= new ImageIcon(imgurl);
                            }
                            farmLand[r][c].setIcon(new ImageIcon(wetdirtImage.getImage()
                                    .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                        }
                    }
                    if ((state.getFarmLand()[r][c] & fertilized) == fertilized
                            && !((state.getFarmLand()[r][c] & wet) == wet)) {
                        // Snowy & Fertilized
                        if ((state.getFarmLand()[r][c] & snowy) == snowy) {
                            String dirtImgicon = "/main/resources/snowytiles4.png";
                            URL imgurl = FarmView.class.getResource(dirtImgicon);
                            dirtImg = new ImageIcon("src/main/resources/snowytiles4.png");
                            if (imgurl != null) {
                                dirtImg = new ImageIcon(imgurl);
                            }
                            String dirturl = "/main/resources/snowytiles4.png";
                            imgurl = FarmView.class.getResource(dirturl);
                            ImageIcon snowyDirtImage = new ImageIcon("src/main/resources/snowytiles4.png");
                            if (imgurl != null) {
                                snowyDirtImage= new ImageIcon(imgurl);
                            }
                            farmLand[r][c].setIcon(new ImageIcon(snowyDirtImage.getImage()
                                    .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                        }
                        else {
                            String dirtImgicon = "/main/resources/farmtile4.png";
                            URL imgurl = FarmView.class.getResource(dirtImgicon);
                            dirtImg = new ImageIcon("src/main/resources/farmtile4.png");
                            if (imgurl != null) {
                                dirtImg = new ImageIcon(imgurl);
                            }
                            String dirturl = "/main/resources/farmtile4.png";
                            imgurl = FarmView.class.getResource(dirturl);
                            ImageIcon wetdirtImage = new ImageIcon("src/main/resources/farmtile4.png");
                            if (imgurl != null) {
                                wetdirtImage= new ImageIcon(imgurl);
                            }
                            farmLand[r][c].setIcon(new ImageIcon(wetdirtImage.getImage()
                                    .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                        }
                    }
                }
                // Snowy & Unclaimed
                else if ((state.getFarmLand()[r][c] & snowy) == snowy) {
                    String dirtImgicon = "/main/resources/snowytiles1.png";
                    URL imgurl = FarmView.class.getResource(dirtImgicon);
                    dirtImg = new ImageIcon("src/main/resources/snowytiles1.png");
                    if (imgurl != null) {
                        dirtImg = new ImageIcon(imgurl);
                    }
                    String dirturl = "/main/resources/snowytiles1.png";
                    imgurl = FarmView.class.getResource(dirturl);
                    ImageIcon snowyDirtImage = new ImageIcon("src/main/resources/snowytiles1.png");
                    if (imgurl != null) {
                        snowyDirtImage= new ImageIcon(imgurl);
                    }
                    farmLand[r][c].setIcon(new ImageIcon(snowyDirtImage.getImage()
                            .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                }
                else {
                    String dirtImgicon = "/main/resources/farmtile1.png";
                    URL imgurl = FarmView.class.getResource(dirtImgicon);
                    dirtImg = new ImageIcon("src/main/resources/farmtile1.png");
                    if (imgurl != null) {
                        dirtImg = new ImageIcon(imgurl);
                    }
                    String dirturl = "/main/resources/farmtile1.png";
                    imgurl = FarmView.class.getResource(dirturl);
                    ImageIcon wetdirtImage = new ImageIcon("src/main/resources/farmtile1.png");
                    if (imgurl != null) {
                        wetdirtImage= new ImageIcon(imgurl);
                    }
                    farmLand[r][c].setIcon(new ImageIcon(wetdirtImage.getImage()
                            .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                }

                // given the farmland is claimed, if a crop has been planted there, make it appear
                if ((state.getFarmLand()[r][c] & planted) == planted
                        && (state.getFarmLand()[r][c] & ready) != ready) {
                    ImageIcon cropImg = null;
                    if ((state.getFarmLand()[r][c] & alive) != alive) {
                        String cropImgicon = "/main/resources/deadPlant.png";
                        URL imgurl = FarmView.class.getResource(cropImgicon);
                        cropImg = new ImageIcon("src/main/resources/deadPlant.png");
                        if (imgurl != null) {
                            cropImg = new ImageIcon(imgurl);
                        }
                    }
                    else if ((state.getFarmLand()[r][c] & cropMask) == rice) {
                        String cropImgicon = "/main/resources/RiceUnready.png";
                        URL imgurl = FarmView.class.getResource(cropImgicon);
                        cropImg = new ImageIcon("src/main/resources/RiceUnready.png");
                        if (imgurl != null) {
                            cropImg = new ImageIcon(imgurl);
                        }
                    }
                    else if ((state.getFarmLand()[r][c] & cropMask) == corn) {
                        String cropImgicon = "/main/resources/CornUnready.png";
                        URL imgurl = FarmView.class.getResource(cropImgicon);
                        cropImg = new ImageIcon("src/main/resources/CornUnready.png");
                        if (imgurl != null) {
                            cropImg = new ImageIcon(imgurl);
                        }
                    }
                    else if ((state.getFarmLand()[r][c] & cropMask) == wheat) {
                        String cropImgicon = "/main/resources/WheatUnready.png";
                        URL imgurl = FarmView.class.getResource(cropImgicon);
                        cropImg = new ImageIcon("src/main/resources/WheatUnready.png");
                        if (imgurl != null) {
                            cropImg = new ImageIcon(imgurl);
                        }
                    }
                    else if ((state.getFarmLand()[r][c] & cropMask) == snowberry) {
                        String cropImgicon = "/main/resources/SnowberryUnready.png";
                        URL imgurl = FarmView.class.getResource(cropImgicon);
                        cropImg = new ImageIcon("src/main/resources/SnowyberryUnready.png");
                        if (imgurl != null) {
                            cropImg = new ImageIcon(imgurl);
                        }
                    }
                    if (cropImg != null) {
                        setLayeredIcons(farmLand[r][c], dirtImg, cropImg);
                    }
                }
                if ((state.getFarmLand()[r][c] & planted) == planted
                        && (state.getFarmLand()[r][c] & ready) == ready) {
                    ImageIcon cropImg = null;
                    if ((state.getFarmLand()[r][c] & alive) != alive) {
                        String cropImgicon = "/main/resources/deadPlant.png";
                        URL imgurl = FarmView.class.getResource(cropImgicon);
                        cropImg = new ImageIcon("src/main/resources/deadPlant.png");
                        if (imgurl != null) {
                            cropImg = new ImageIcon(imgurl);
                        }
                    }
                    else if ((state.getFarmLand()[r][c] & cropMask) == rice) {
                        String cropImgicon = "/main/resources/RiceReady.png";
                        URL imgurl = FarmView.class.getResource(cropImgicon);
                        cropImg = new ImageIcon("src/main/resources/RiceReady.png");
                        if (imgurl != null) {
                            cropImg = new ImageIcon(imgurl);
                        }
                    }
                    else if ((state.getFarmLand()[r][c] & cropMask) == corn) {
                        String cropImgicon = "/main/resources/CornReady.png";
                        URL imgurl = FarmView.class.getResource(cropImgicon);
                        cropImg = new ImageIcon("src/main/resources/CornReady.png");
                        if (imgurl != null) {
                            cropImg = new ImageIcon(imgurl);
                        }
                    }
                    else if ((state.getFarmLand()[r][c] & cropMask) == wheat) {
                        String cropImgicon = "/main/resources/WheatReady.png";
                        URL imgurl = FarmView.class.getResource(cropImgicon);
                        cropImg = new ImageIcon("src/main/resources/WheatReady.png");
                        if (imgurl != null) {
                            cropImg = new ImageIcon(imgurl);
                        }
                    }
                    else if ((state.getFarmLand()[r][c] & cropMask) == snowberry) {
                        String cropImgicon = "/main/resources/SnowberryReady.png";
                        URL imgurl = FarmView.class.getResource(cropImgicon);
                        cropImg = new ImageIcon("src/main/resources/SnowberryReady.png");
                        if (imgurl != null) {
                            cropImg = new ImageIcon(imgurl);
                        }
                    }
                    if (cropImg != null) {
                        setLayeredIcons(farmLand[r][c], dirtImg, cropImg);
                    }
                }
            }
        }
    }

    private void setLayeredIcons(JLabel label, ImageIcon baseIcon, ImageIcon overlayIcon) {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(label.getSize());
        JLabel baseLabel = new JLabel(new ImageIcon(baseIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        baseLabel.setBounds(0, 0, 25, 25);
        layeredPane.add(baseLabel, JLayeredPane.DEFAULT_LAYER);

        JLabel overlayLabel = new JLabel(new ImageIcon(overlayIcon.getImage()
                .getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        overlayLabel.setBounds(0, 0, 25, 25);
        layeredPane.add(overlayLabel, JLayeredPane.PALETTE_LAYER);

        // Clear the existing icon
        label.setLayout(new BorderLayout());
        label.add(layeredPane, BorderLayout.CENTER);
    }

    /**
     * Set Claim Controller.
     * @param claimController .
     */
    public void setClaimController(ClaimController claimController) {
        this.claimController = claimController;
    }

    /**
     * Set Fertilize Controller.
     * @param fertilizeController .
     */
    public void setFertilizeController(FertilizeController fertilizeController) {
        this.fertilizeController = fertilizeController;
    }

    /**
     * Set Buy Controller.
     * @param buyController .
     */
    public void setBuyController(BuyController buyController) {
        this.buyController = buyController;
    }

    /**
     * Set Upgrade Controller.
     * @param upgradeController .
     */
    public void setUpgradeController(UpgradeController upgradeController) {
        this.upgradeController = upgradeController;
    }

    /**
     * Set Harvest Controller.
     * @param harvestController .
     */
    public void setHarvestController(HarvestController harvestController) {
        this.harvestController = harvestController;
    }

    /**
     * Set Plant Controller.
     * @param plantController .
     */
    public void setPlantController(PlantController plantController) {
        this.plantController = plantController;
    }

    /**
     * Set Water Controller.
     * @param waterController .
     */
    public void setWaterController(WaterController waterController) {
        this.waterController = waterController;
    }

    /**
     * Set Sell Controller.
     * @param sellController .
     */
    public void setSellController(SellController sellController) {
        this.sellController = sellController;
    }

    /**
     * Set Select Tool Controller.
     * @param selectToolController .
     */
    public void setSelectToolController(SelectToolController selectToolController) {
        this.selectToolController = selectToolController;
    }

    /**
     * Set Select Crop Controller.
     * @param selectCropController .
     */
    public void setSelectCropController(SelectCropController selectCropController) {
        this.selectCropController = selectCropController;
    }

    /**
     * Set Weather Controller.
     * @param weatherController .
     */
    public void setWeatherController(WeatherController weatherController) {
        this.weatherController = weatherController;
    }

    /**
     * Set SetCrop Controller.
     * @param setCropController .
     */
    public void setSetCropController(SetCropController setCropController) {
        this.setCropController = setCropController;
    }

    /**
     * Set Use Tool Controller.
     * @param useToolController .
     */
    public void setUseToolController(UseToolController useToolController) {
        this.useToolController = useToolController;
    }

    /**
     * Set Get Active Tool Controller.
     * @param getActiveToolController .
     */
    public void setGetActiveToolController(GetActiveToolController getActiveToolController) {
        this.getActiveToolController = getActiveToolController;
    }

    /**
     * Set Save Controller.
     * @param saveController .
     */
    public void setSaveController(SaveController saveController) {
        this.saveController = saveController;
    }

    /**
     * Set get tool bought controller.
     * @param getToolBoughtController .
     */
    public void setGetToolBoughtController(GetToolBoughtController getToolBoughtController) {
        this.getToolBoughtController = getToolBoughtController;
    }

    /**
     * Set action performed listener.
     * @param evt the event to be processed
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Set forecast controller.
     * @param forecastController .
     */
    public void setForecastController(ForecastController forecastController) {
        this.forecastController = forecastController;
    }

    /**
     * Get storage controller.
     * @param getStorageController .
     */
    public void setGetStorageController(GetStorageController getStorageController) {
        this.getStorageController = getStorageController;
    }

    /**
     * Set get BarnBucks controller.
     * @param getBarnBucksController .
     */
    public void setGetBarnBucksController(GetBarnBucksController getBarnBucksController) {
        this.getBarnBucksController = getBarnBucksController;
    }

    /**
     * Set power refund controller.
     * @param powerRefundController .
     */
    public void setPowerRefundController(PowerRefundController powerRefundController) {
        this.powerRefundController = powerRefundController;
    }
}
