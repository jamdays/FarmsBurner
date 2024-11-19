package main.java.view;

import main.java.interface_adapter.farm.FarmController;
import main.java.interface_adapter.farm.FarmState;
import main.java.interface_adapter.farm.FarmViewModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FarmView extends JPanel implements ActionListener, PropertyChangeListener {
    private final int WET = 0B1;
    private final int CLAIMED = 0B10;
    private final int SNOWY = 0B100;
    private final int PLANTED = 0B1000;
    private final int ALIVE = 0B100000;
    private final int FERTILIZED = 0B1000000;
    private FarmController farmController;
    private FarmLabel[][] farmLand;
    private FarmViewModel viewModel;

    public FarmView(FarmViewModel farmViewModel) {
        // Navigation Bar
        JPanel navBar = new JPanel();
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
                String weather = dao.currentInfoForCity("toronto");
                // show results
                JOptionPane.showMessageDialog(null, weather, "Current Weather", JOptionPane.DEFAULT_OPTION);
                }
        });
        FarmButton sell = new FarmButton("Sell");
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open sell menu");
            }
        });
        FarmButton buy = new FarmButton("Buy");
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open buy menu");
                // Create new JFrame for Buy Menu
                JFrame buyFrame = new JFrame("Buy Menu");
                // Set size and closeing operations for the frame
                buyFrame.setSize(400, 300);
                buyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                buyFrame.setVisible(true);
            }
        });
        FarmButton help = new FarmButton("i");
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open help menu");
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
                            farmController.claim(r, c);
                        }
                        // if plot is clicked while ctrl is held down, plant crop on plot
                        else if (e.getModifiers() == 18) {
                            farmController.plantCrop(r, c);
                        }
                        // if plot is clicked while alt is held down, water plot
                        else if (e.getModifiers() == 24) {
                            farmController.waterCrop(r, c);
                        }
                        // if plot is clicked while ctrl and alt are held down, fertilize crop
                        else if ((e.getModifiers() & (18|24)) == (18|24)) {
                            farmController.fertilize(r, c);
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

        JPanel footerPanel = new JPanel();
        FarmLabel power = new FarmLabel("Power: 0");
        FarmLabel barnBucks = new FarmLabel("Barn Bucks: 0");
        footerPanel.add(power);
        footerPanel.add(barnBucks);
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

    public void setFarmController(FarmController controller) {
        this.farmController = controller;
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
