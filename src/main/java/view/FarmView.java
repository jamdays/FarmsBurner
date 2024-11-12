package main.java.view;

import main.java.interface_adapter.farm.FarmController;
import main.java.interface_adapter.farm.FarmState;
import main.java.interface_adapter.farm.FarmViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FarmView extends JPanel implements ActionListener, PropertyChangeListener {
    private final int WET = 0B1;
    private final int CLAIMED = 0B10;
    private final int SNOWY = 0B100;
    private final int PLANTED = 0B1000;
    private final int ALIVE = 0B100000;
    private FarmController farmController;
    private FarmButton[][] farmLand;
    private FarmViewModel viewModel;

    public FarmView(FarmViewModel farmViewModel) {
        // Navigation Bar
        JPanel navBar = new JPanel();
        viewModel = farmViewModel;
        viewModel.addPropertyChangeListener(this);
        this.setBackground(new Color(169, 152, 126));
        FarmButton farmSettings = new FarmButton("=");
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
            public void actionPerformed(ActionEvent e) { System.out.println("Open popup with current weather"); }
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
        farmLand = new FarmButton[8][10];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 10; col++) {
                final int r = row;
                final int c = col;
                FarmButton button = new FarmButton("  ", 20, Color.BLACK);
                farmLand[r][c] = button;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if ((e.getModifiers() & 1) == 1) {
                            farmController.claim(r, c);
                        }
                        else if ((e.getModifiers() & 2) == 2) {
                            farmController.plantCrop(r, c);
                        }
                        else {
                            farmController.waterCrop(r, c);
                        }
                    }
                });
                button.setSize(new Dimension(80, 80));
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.gridx = col;
                gbc.gridy = row;
                landPanel.add(button, gbc);
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
                if ((state.getFarmLand()[r][c] & CLAIMED) == CLAIMED) {
                    farmLand[r][c].setBackground(dirt);
                    if ((state.getFarmLand()[r][c] & WET) == WET) {
                        farmLand[r][c].setBackground(wetdirt);

                    }
                    if ((state.getFarmLand()[r][c] & PLANTED) == PLANTED) {
                        farmLand[r][c].setText("T");
                        farmLand[r][c].setForeground(Color.gray);
                        if ((state.getFarmLand()[r][c] & ALIVE) == ALIVE) {
                            farmLand[r][c].setForeground(green);

                        }
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
