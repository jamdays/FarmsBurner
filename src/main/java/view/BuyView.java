package main.java.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyView {
    public static void main(String[] args) {
        // Buy Menu
        JPanel buyPanel = new JPanel();
        buyPanel.setLayout(new BoxLayout(buyPanel, BoxLayout.Y_AXIS));
        FarmLabel buyMenuTitle = new FarmLabel("Buy Menu", 36);
        buyPanel.add(buyMenuTitle);
        buyPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(buyPanel);

        // Frame
        JFrame frame = new JFrame("Buy Menu");
        frame.setSize(741, 420);
        frame.setContentPane(mainPanel);
        frame.getContentPane().setBackground(new java.awt.Color(169, 152, 126));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
