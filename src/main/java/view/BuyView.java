package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BuyView {
    public static void main(String[] args) {

        // Buy Menu
        FarmLabel buyMenuTitle = new FarmLabel("Buy Menu                     ", 18);
        JPanel topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topLeftPanel.add(buyMenuTitle);
        topLeftPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Barn Bucks
        // TODO: implement barnBucks so that it updates with the amount of barnBucks the user has
        FarmLabel barnBucks = new FarmLabel("                   Barn Bucks: 0", 18);
        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRightPanel.add(barnBucks);
        topRightPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Top Panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(topLeftPanel, BorderLayout.WEST);
        topPanel.add(topRightPanel, BorderLayout.EAST);
        topPanel.setBackground(new java.awt.Color(169, 152, 126));

        // White Background
        JPanel whitePanel = new JPanel(new BorderLayout());
        whitePanel.add(topPanel, BorderLayout.NORTH);
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBorder(BorderFactory.createEmptyBorder(320, 700, 20, 20));

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(whitePanel, BorderLayout.CENTER);

        // Frame
        JFrame frame = new JFrame("Buy Menu");
        frame.setSize(741, 420);
        frame.setContentPane(mainPanel);
        frame.getContentPane().setBackground(new java.awt.Color(169, 152, 126));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
