package main.java.view;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.app.WindowBuilder;

import main.java.interface_adapter.farm.FarmState;
import main.java.interface_adapter.farm.FarmViewModel;
import main.java.interface_adapter.selecttool.SelectToolController;
import main.java.interface_adapter.sell.SellController;
import main.java.interface_adapter.sell.SellViewModel;
import main.java.interface_adapter.toolmenu.BuyController;
import main.java.interface_adapter.toolmenu.ToolMenuViewModel;
import main.java.interface_adapter.toolmenu.UpgradeController;
import main.java.interface_adapter.farm.FertilizeController;
import main.java.interface_adapter.farm.PlantController;
import main.java.interface_adapter.farm.WaterController;
import main.java.interface_adapter.farm.HarvestController;
import main.java.interface_adapter.farm.ClaimController;
import main.java.interface_adapter.selecttool.SelectToolViewModel;



import main.java.view.SelectCropView;
import main.java.view.SelectToolView;
import main.java.view.WeatherView;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import java.util.List;

public class FarmView extends JPanel implements ActionListener, PropertyChangeListener {
    private final int WET = 0B1;
    private final int CLAIMED = 0B10;
    private final int SNOWY = 0B100;
    private final int PLANTED = 0B1000;
    private final int ALIVE = 0B100000;
    private final int FERTILIZED = 0B1000000;
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

    public FarmView(FarmViewModel farmViewModel, ToolMenuViewModel toolMenuViewModel, SellViewModel sellViewModel, SelectToolViewModel selectToolViewModel) {
        // Navigation Bar
        JPanel navBar = new JPanel();
        this.toolMenuViewModel = toolMenuViewModel;
        this.sellViewModel = sellViewModel;
        this.selectToolViewModel = selectToolViewModel;
        viewModel = farmViewModel;
        viewModel.addPropertyChangeListener(this);
        this.setBackground(new Color(169, 152, 126));
        FarmButton farmSettings = new FarmButton("≡");
        farmSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open farm settings");
            }
        });
        FarmButton weather = new FarmButton("Weather");
        // TODO: add checkweather use case and implement popup window displaying result of API call
        weather.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // call API (make this follow Clean Architecture later)
                var props = new Properties();
                var envFile = Paths.get(".env");
                try (var inputStream = Files.newInputStream(envFile)) {
                    props.load(inputStream);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String apiKey = props.get("WAK").toString();
                final main.java.data_access.OpenWeatherAccess dao = new main.java.data_access.OpenWeatherAccess(apiKey);
                List<String> currWeatherForCity = dao.currentDisplayInfoForCity("Toronto");
                String city = currWeatherForCity.get(0);
                String temp = currWeatherForCity.get(1);
                String conditions = currWeatherForCity.get(2);
                String cloudCoverage = currWeatherForCity.get(3);
                // test show results
                final WindowBuilder builder = new WindowBuilder();
                builder.addInfoView(350, 280, new WeatherView(city, temp, conditions, cloudCoverage)).build().setVisible(true);
                }
        });
        FarmButton sell = new FarmButton("Sell");
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                SellView sellView = new SellView(sellViewModel);
                builder.addInfoView(350, 280, sellView).build().setVisible(true);
                sellView.setSellController(sellController);
            }
        });
        FarmButton buy = new FarmButton("Buy");
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                BuyView buyView = new BuyView(toolMenuViewModel);
                builder.addInfoView(350, 280, buyView).build().setVisible(true);
                buyView.setBuyController(buyController);
                buyView.setUpgradeController(upgradeController);

            }
        });
        FarmButton help = new FarmButton("i");
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                builder.addInfoView(271, 250, new Info()).build().setVisible(true);
            }
        });

        JPanel landPanel = new JPanel();
        landPanel.setLayout(new GridBagLayout());
        landPanel.setSize(new Dimension(1000, 800));
        landPanel.setBackground(new Color(169, 152, 126));
        GridBagConstraints gbc = new GridBagConstraints();
        farmLand = new FarmLabel[8][10];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 10; col++) {
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
                builder.addInfoView(271, 250, new SelectCropView()).build().setVisible(true);
            }
        });

        FarmButton toolSelector = new FarmButton("Choose Tool");

        toolSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final WindowBuilder builder = new WindowBuilder();
                SelectToolView selectToolView = new SelectToolView(selectToolViewModel);
                selectToolView.setController(selectToolController);
                builder.addInfoView(271, 250, selectToolView).build().setVisible(true);
            }
        });

        footerPanel.add(cropSelector);
        footerPanel.add(toolSelector);
        footerPanel.setBackground(new Color(169, 152, 126));

        navBar.add(farmSettings);
        navBar.add(weather);
        navBar.add(sell);
        navBar.add(buy);
        navBar.add(help);
        navBar.setBackground(new Color(169, 152, 126));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(navBar);
        this.add(landPanel);
        this.add(footerPanel);
        // JFrame frame = new JFrame("Farm View");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(741, 420);
        // frame.getContentPane().add(mainPanel);
        // frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Color green =new Color(20,130,50);
        Color dirt =new Color(75,40,40);
        Color wetdirt =new Color(50,20,20);
        final FarmState state = (FarmState) evt.getNewValue();
        for (int r = 0; r < state.getFarmLand().length; r++) {
            for (int c = 0; c < state.getFarmLand()[r].length; c++) {
                // if farmland is claimed, change button color to dirt
                if ((state.getFarmLand()[r][c] & CLAIMED) == CLAIMED) {
                    ImageIcon dirtIMG = new ImageIcon("src/main/resources/farmtile2.png");
                    farmLand[r][c].setIcon(new ImageIcon(dirtIMG.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                    // given the farmland is claimed, if it is wet as well as fertilized, set label image to wet and fertilized dirt
                    if (((state.getFarmLand()[r][c] & FERTILIZED) == FERTILIZED) && ((state.getFarmLand()[r][c] & WET) == WET)) {
                        ImageIcon wetfertilizeddirtIMG = new ImageIcon("src/main/resources/farmtile5.png");
                        farmLand[r][c].setIcon(new ImageIcon(wetfertilizeddirtIMG.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                    }
                    // given the farmland is claimed, if it is wet but unfertilized, set label image to wet but unfertilized dirt
                    if (!((state.getFarmLand()[r][c] & FERTILIZED) == FERTILIZED) && ((state.getFarmLand()[r][c] & WET) == WET)) {
                        ImageIcon wetdirtIMG = new ImageIcon("src/main/resources/farmtile3.png");
                        farmLand[r][c].setIcon(new ImageIcon(wetdirtIMG.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                    }
                    // given the farmland is claimed, if a crop has been planted there, make it appear
                    if ((state.getFarmLand()[r][c] & PLANTED) == PLANTED) {
                        farmLand[r][c].setText("T");
                        farmLand[r][c].setHorizontalTextPosition(JLabel.CENTER);
                        farmLand[r][c].setForeground(Color.gray);
                        // set the plant colour to green if and only if it is alive
                        if ((state.getFarmLand()[r][c] & ALIVE) == ALIVE) {
                            farmLand[r][c].setForeground(green);

                        }
                    }
                    // given the farmland is claimed, if it has been fertilized but is dry, set label image to fertilized but dry dirt
                    if (((state.getFarmLand()[r][c] & FERTILIZED) == FERTILIZED) && !((state.getFarmLand()[r][c] & WET) == WET)) {
                        ImageIcon fertilizeddirtIMG = new ImageIcon("src/main/resources/farmtile4.png");
                        farmLand[r][c].setIcon(new ImageIcon(fertilizeddirtIMG.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
                    }
                }
            }
        }
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

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
