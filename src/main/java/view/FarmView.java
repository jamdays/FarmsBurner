package main.java.view;

import main.java.app.WindowBuilder;

import main.java.interface_adapter.farm.*;
import main.java.interface_adapter.selectcrop.SelectCropController;
import main.java.interface_adapter.selectcrop.SelectCropViewModel;
import main.java.interface_adapter.selecttool.SelectToolController;
import main.java.interface_adapter.sell.SellController;
import main.java.interface_adapter.sell.SellViewModel;
import main.java.interface_adapter.toolmenu.BuyController;
import main.java.interface_adapter.toolmenu.ToolMenuViewModel;
import main.java.interface_adapter.toolmenu.UpgradeController;
import main.java.interface_adapter.selecttool.SelectToolViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class FarmView extends JPanel implements ActionListener, PropertyChangeListener {
    private JLabel backgroundLabel;
    private final int WET = 0B1;
    private final int CLAIMED = 0B10;
    private final int SNOWY = 0B100;
    private final int PLANTED = 0B1000;
    private final int ALIVE = 0B100000;
    private final int FERTILIZED = 0B1000000;
    private final int CROP_MASK = 0B1100000000;
    private final int RICE = 0B0100000000;
    private final int SNOWBERRY = 0B00000000000;
    private final int CORN = 0B1100000000;
    private final int WHEAT = 0B1000000000;
    private final int READY = 0B10000000;
    private ClaimController claimController;
    private FertilizeController fertilizeController;
    private HarvestController harvestController;
    private PlantController plantController;
    private WaterController waterController;
    private FarmLabel[][] farmLand;
    private FarmViewModel viewModel;
    private ToolMenuViewModel toolMenuViewModel;
    private BuyController buyController;
    private UpgradeController upgradeController;
    private SellViewModel  sellViewModel;
    private SellController sellController;
    private SelectToolViewModel selectToolViewModel;
    private SelectToolController selectToolController;
    private WeatherController weatherController;
    private SelectCropViewModel selectCropViewModel;
    private SelectCropController selectCropController;
    private SaveController saveController;
    private SetCropController setCropController;

    public FarmView(FarmViewModel farmViewModel, ToolMenuViewModel toolMenuViewModel, SellViewModel sellViewModel, SelectToolViewModel selectToolViewModel, SelectCropViewModel selectCropViewModel) {
        //Add background as JLABEL to set images
        backgroundLabel = new JLabel();
        this.setLayout(new BorderLayout());
        this.add(backgroundLabel);
        // Navigation Bar

        JPanel navBar = new JPanel();
        this.toolMenuViewModel = toolMenuViewModel;
        this.sellViewModel = sellViewModel;
        this.selectToolViewModel = selectToolViewModel;
        viewModel = farmViewModel;
        viewModel.addPropertyChangeListener(this);
        this.setBackground(new Color(169, 152, 126));
        //FarmButton farmSettings = new FarmButton("≡");
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
                builder.addView(350, 280, new WeatherView(city, temp, conditions, cloudCoverage)).build().setVisible(true);
                }
        });
        FarmButton sell = new FarmButton("Sell");
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                SellView sellView = new SellView(sellViewModel);
                builder.addView(350, 280, sellView).build().setVisible(true);
                sellView.setSellController(sellController);
            }
        });
        FarmButton buy = new FarmButton("Buy");
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                BuyView buyView = new BuyView(toolMenuViewModel);
                builder.addView(380, 280, buyView).build().setVisible(true);
                buyView.setBuyController(buyController);
                buyView.setUpgradeController(upgradeController);

            }
        });
        FarmButton help = new FarmButton("i");
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                builder.addView(271, 250, new Info()).build().setVisible(true);
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
//                cropLabel.setBorder(new LineBorder(Color.WHITE));
//                cropLabel.setPreferredSize(new Dimension(25, 25));
                farmLand[r][c] = cropLabel;
                cropLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if ((e.getModifiers() & 1) == 1) {
                            claimController.claim(r, c);
                        }
                        // if plot is clicked while ctrl is held down, plant crop on plot
                        else if (e.getModifiers() == 18) {
                            plantController.plantCrop(r, c);
                        }
                        // if plot is clicked while alt is held down, water plot
                        else if (e.getModifiers() == 24) {
                            waterController.waterCrop(r, c);
                        }
                        // if plot is clicked while ctrl and alt are held down, fertilize crop
                        else if ((e.getModifiers() & (18|24)) == (18|24)) {
                            fertilizeController.fertilize(r, c);
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
        //footerPanel.add(power);
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
        footerPanel.setBackground(new Color(169, 152, 126,0 ));

        navBar.add(save);
        navBar.add(weather);
        navBar.add(sell);
        navBar.add(buy);
        navBar.add(help);
        navBar.setBackground(new Color(169, 152, 126, 0));

        backgroundLabel.setLayout(new BoxLayout(backgroundLabel, BoxLayout.Y_AXIS));
        backgroundLabel.add(navBar);
        backgroundLabel.add(landPanel);
        backgroundLabel.add(footerPanel);
        // JFrame frame = new JFrame("Farm View");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(741, 420);
        // frame.getContentPane().add(mainPanel);
        // frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final FarmState state = (FarmState) evt.getNewValue();
        //TODO add default background in case it doesn't exist
        if (evt.getPropertyName().equals("weather")) {
            String background = "src/main/resources/background-";
            if (state.getDay() == 0){
                background += "night";
            } else if (state.getDay() == 1){
                background += "day";
            }
            else{
                background += "dawndusk.png";
                ImageIcon backgroundIMG = new ImageIcon(background);
                System.out.println(background);
                this.backgroundLabel.setIcon(new ImageIcon(backgroundIMG.getImage()));
                return;
            }
            switch(state.getWeather()){
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
                    background = "src/main/resources/background-thunderstorm";
                    break;
                default:
                    background += "cloudy";
            }
            background += ".png";
            ImageIcon backgroundIMG = new ImageIcon(background);
            System.out.println(background);
            this.backgroundLabel.setIcon(new ImageIcon(backgroundIMG.getImage()));

        }
        else {
            Color green = new Color(20, 130, 50);
            Color dirt = new Color(75, 40, 40);
            Color wetdirt = new Color(50, 20, 20);
            for (int r = 0; r < state.getFarmLand().length; r++) {
                for (int c = 0; c < state.getFarmLand()[r].length; c++) {
                    ImageIcon dirtImg = null;
                    // if farmland is claimed, change button color to dirt
                    String file = "";
                    if ((state.getFarmLand()[r][c] & CROP_MASK) == CORN){
                        file += "Corn";
                    }
                    else if ((state.getFarmLand()[r][c] & CROP_MASK) == WHEAT){
                        file+= "Wheat";
                    }
                    //BECAUSE SNOWBERRY IS 0 so it is on by default
                    else if ((state.getFarmLand()[r][c] & CROP_MASK) == SNOWBERRY && (state.getFarmLand()[r][c] & PLANTED) == PLANTED){
                        file += "Snowberry";
                    }
                    else if ((state.getFarmLand()[r][c] & CROP_MASK) == RICE){
                        file += "Rice";
                    }
                    if ((state.getFarmLand()[r][c] & READY) == READY){
                        file += "Ready";
                    }
                    if ((state.getFarmLand()[r][c] & CLAIMED) == CLAIMED) {
                        ImageIcon dirtIMG = new ImageIcon("src/main/resources/farmtile2" + file + ".png");
                        farmLand[r][c].setIcon(new ImageIcon(dirtIMG.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                        // given the farmland is claimed, if it is wet as well as fertilized, set label image to wet and fertilized dirt
                        if (((state.getFarmLand()[r][c] & FERTILIZED) == FERTILIZED) && ((state.getFarmLand()[r][c] & WET) == WET)) {
                            ImageIcon wetfertilizeddirtIMG = new ImageIcon("src/main/resources/farmtile5" + file + ".png");
                            farmLand[r][c].setIcon(new ImageIcon(wetfertilizeddirtIMG.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                        }
                        // given the farmland is claimed, if it is wet but unfertilized, set label image to wet but unfertilized dirt
                        if (!((state.getFarmLand()[r][c] & FERTILIZED) == FERTILIZED) && ((state.getFarmLand()[r][c] & WET) == WET)) {
                            ImageIcon wetdirtIMG = new ImageIcon("src/main/resources/farmtile3" + file + ".png");
                            farmLand[r][c].setIcon(new ImageIcon(wetdirtIMG.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                        }
                        // given the farmland is claimed, if a crop has been planted there, make it appear
                        if ((state.getFarmLand()[r][c] & PLANTED) == PLANTED) {
                            farmLand[r][c].setHorizontalTextPosition(JLabel.CENTER);
                            farmLand[r][c].setForeground(Color.gray);
                            // set the plant colour to green if and only if it is alive
                            if ((state.getFarmLand()[r][c] & ALIVE) == ALIVE) {
                                farmLand[r][c].setForeground(green);

                            }
                        }
                        // given the farmland is claimed, if it has been fertilized but is dry, set label image to fertilized but dry dirt
                        if (((state.getFarmLand()[r][c] & FERTILIZED) == FERTILIZED) && !((state.getFarmLand()[r][c] & WET) == WET)) {
                            ImageIcon fertilizeddirtIMG = new ImageIcon("src/main/resources/farmtile4" +file + ".png");
                            farmLand[r][c].setIcon(new ImageIcon(fertilizeddirtIMG.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                        }
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

        JLabel overlayLabel = new JLabel(new ImageIcon(overlayIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        overlayLabel.setBounds(0, 0, 25, 25);
        layeredPane.add(overlayLabel, JLayeredPane.PALETTE_LAYER);

        label.setIcon(null); // Clear the existing icon
        label.setLayout(new BorderLayout());
        label.add(layeredPane, BorderLayout.CENTER);
    }

    public void setClaimController(ClaimController claimController) {
        this.claimController = claimController;
    }

    public void setFertilizeController(FertilizeController fertilizeController) {
        this.fertilizeController = fertilizeController;
    }

    public void setBuyController(BuyController buyController){
        this.buyController = buyController;
    }

    public void setUpgradeController(UpgradeController upgradeController){
        this.upgradeController = upgradeController;
    }
    public void setHarvestController(HarvestController harvestController) {
        this.harvestController = harvestController;
    }

    public void setPlantController(PlantController plantController) {
        this.plantController = plantController;
    }

    public void setWaterController(WaterController waterController) {
        this.waterController = waterController;
    }

    public void setSellController(SellController sellController){
        this.sellController = sellController;
    }

    public void setSelectToolController(SelectToolController selectToolController) {
        this.selectToolController = selectToolController;
    }

    public void setSelectCropController(SelectCropController selectCropController) {
        this.selectCropController = selectCropController;
    }

    public void setWeatherController(WeatherController weatherController) {
        this.weatherController = weatherController;
    }

    public void setSetCropController(SetCropController setCropController) {
        this.setCropController = setCropController;
    }

    public void setSaveController(SaveController saveController) {
        this.saveController = saveController;
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

}
