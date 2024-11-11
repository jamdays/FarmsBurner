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
    FarmController farmController;

    public FarmView(FarmViewModel farmViewModel) {
        // Navigation Bar
        JPanel navBar = new JPanel();
        this.setBackground(new Color(169, 152, 126));
        FarmButton farmSettings = new FarmButton("=");
        farmSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open farm settings");
            }
        });
        FarmLabel weather = new FarmLabel("Weather:");
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
        Color green =new Color(20,130,50);
        Color brown =new Color(50,20,20);
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 8; col++) {
                FarmButton button = new FarmButton("  ", 20, Color.BLACK);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.setForeground(green);
                        button.setText("T");
                        button.setBackground(brown);
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
        final FarmState state = (FarmState) evt.getNewValue();
    }

    public void setFarmController(FarmController controller) {
        this.farmController = controller;
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
