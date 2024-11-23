package main.java.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellView {
    public static void main(String[] args) {
        int crops = 5;
        int barnBucks = 0;
        int cost = 3;
        JLabel cropLabel = new JLabel("Crops: " + crops);
        JLabel barnBucksLabel = new JLabel("Barn Bucks: " + barnBucks);
        JLabel description = new JLabel("Today you can sell your crops for " + cost + " Barn Bucks");

        JPanel sellPanel = new JPanel();
        JLabel sellLabel = new JLabel("Sell crops");
        JButton minusButton = new JButton("-");
        JLabel amountLabel = new JLabel("0");
        JButton plusButton = new JButton("+");

        sellPanel.add(sellLabel);
        sellPanel.add(minusButton);
        sellPanel.add(amountLabel);
        sellPanel.add(plusButton);

        JLabel earningLabel = new JLabel("Total Earnings: " + Integer.parseInt(amountLabel.getText()) * cost);
        JButton confirmButton = new JButton("Confirm Sale");

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(amountLabel.getText());
                if (currentQuantity > 0) {
                    amountLabel.setText(String.valueOf(currentQuantity - 1));
                    earningLabel.setText("Total Earnings: " + Integer.parseInt(amountLabel.getText()) * cost);
                }
            }
        });

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(amountLabel.getText());
                if (currentQuantity < Integer.parseInt(cropLabel.getText().substring(7))) {
                    amountLabel.setText(String.valueOf(currentQuantity + 1));
                    earningLabel.setText("Total Earnings: " + Integer.parseInt(amountLabel.getText()) * cost);
                }
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int crops = Integer.parseInt(cropLabel.getText().substring(7));
                int currentQuantity = Integer.parseInt(amountLabel.getText());
                int barnBucks = Integer.parseInt(barnBucksLabel.getText().substring(12));
                cropLabel.setText("Crops: " + (crops - currentQuantity));
                barnBucksLabel.setText("Barn Bucks: " + (barnBucks + Integer.parseInt(amountLabel.getText()) * cost));
                amountLabel.setText("0");
                earningLabel.setText("Total Earnings: 0");
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(cropLabel);
        mainPanel.add(barnBucksLabel);
        mainPanel.add(description);
        mainPanel.add(sellPanel);
        mainPanel.add(earningLabel);
        mainPanel.add(confirmButton);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 280);
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);

    }
}
