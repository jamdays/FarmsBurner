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
        JButton farmSettings = new JButton("=");
        farmSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open farm settings");
            }
        });
        JLabel weather = new JLabel("Weather:");
        JButton sell = new JButton("Sell");
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open sell menu");
            }
        });
        JButton buy = new JButton("Buy");
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open buy menu");
            }
        });
        JButton help = new JButton("i");
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open help menu");
            }
        });

        JPanel landPanel = new JPanel();
        landPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 8; col++) {
                JButton button = new JButton("   ");
                button.setFont(new Font ("Press Start 2P", Font.PLAIN, 12));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.setText("T");
                    }
                });
                button.setPreferredSize(new Dimension(50, 50));
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.gridx = col;
                gbc.gridy = row;
                landPanel.add(button, gbc);
            }
        }

        JPanel footerPanel = new JPanel();
        JLabel power = new JLabel("Power: 0");
        JLabel barnBucks = new JLabel("Barn Bucks: 0");
        footerPanel.add(power);
        footerPanel.add(barnBucks);

        navBar.add(farmSettings);
        navBar.add(weather);
        navBar.add(sell);
        navBar.add(buy);
        navBar.add(help);

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
