package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FarmView {
    public static void main(String[] args) {
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
        JPanel barnBucksPanel = new JPanel();

        navBar.add(farmSettings);
        navBar.add(weather);
        navBar.add(sell);
        navBar.add(buy);
        navBar.add(help);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(navBar);
        mainPanel.add(landPanel);
        mainPanel.add(barnBucksPanel);

        JFrame frame = new JFrame("Farm View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(741, 420);
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }
}
