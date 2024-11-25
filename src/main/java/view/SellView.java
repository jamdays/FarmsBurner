package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellView extends JPanel {
    int crops;
    int barnBucks;
    int cost;
    public SellView(int crops, int barnBucks, int cost) {
        this.crops = crops;
        this.barnBucks = barnBucks;
        this.cost = cost;

        JLabel cropLabel = new JLabel("Crops: " + crops);
        cropLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

        JLabel barnBucksLabel = new JLabel("Barn Bucks: " + barnBucks);
        barnBucksLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(cropLabel, BorderLayout.WEST);
        topPanel.add(barnBucksLabel, BorderLayout.EAST);
        topPanel.setBackground(new java.awt.Color(169, 152, 126));
        topPanel.setPreferredSize(new Dimension(350,50));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setBackground(new java.awt.Color(169, 152, 126));
        JLabel description = new JLabel("You can sell your crops for ");
        description.setFont(new Font("Arial", Font.PLAIN, 18));
        JLabel costLabel = new JLabel(cost + " Barn Bucks");
        costLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        descriptionPanel.add(description);
        descriptionPanel.add(costLabel);
        JPanel sellPanel = new JPanel();
        sellPanel.setBackground(new java.awt.Color(169, 152, 126));
        JLabel sellLabel = new JLabel("Sell crops:");
        sellLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JButton minusButton = new JButton("-");
        JLabel amountLabel = new JLabel("0");
        JButton plusButton = new JButton("+");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        sellPanel.add(sellLabel);
        sellPanel.add(minusButton);
        sellPanel.add(amountLabel);
        sellPanel.add(plusButton);

        JLabel earningLabel = new JLabel("Total Earnings: " + Integer.parseInt(amountLabel.getText()) * cost);
        earningLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JButton confirmButton = new JButton("Confirm Sale");

        JPanel earningPanel = new JPanel();
        earningPanel.setBackground(new java.awt.Color(169, 152, 126));
        earningPanel.add(earningLabel);
        earningPanel.add(confirmButton);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new java.awt.Color(169, 152, 126));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(descriptionPanel);
        contentPanel.add(sellPanel);
        contentPanel.add(earningPanel);

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

        this.setLayout(new BorderLayout());
        this.setBackground(new java.awt.Color(169, 152, 126));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(contentPanel);

//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(350, 280);
//        frame.getContentPane().add(mainPanel);
//        frame.setVisible(true);

    }
}
