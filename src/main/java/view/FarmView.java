package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FarmView {
    public static void main(String[] args) {
        // Navigation Bar
        JPanel navBar = new JPanel();
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
        GridBagConstraints gbc = new GridBagConstraints();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 8; col++) {
                FarmButton button = new FarmButton("   ");
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
        FarmLabel power = new FarmLabel("Power: 0");
        FarmLabel barnBucks = new FarmLabel("Barn Bucks: 0");
        footerPanel.add(power);
        footerPanel.add(barnBucks);

        navBar.add(farmSettings);
        navBar.add(weather);
        navBar.add(sell);
        navBar.add(buy);
        navBar.add(help);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(navBar);
        mainPanel.add(landPanel);
        mainPanel.add(footerPanel);

        JFrame frame = new JFrame("Farm View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(741, 420);
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }
}
