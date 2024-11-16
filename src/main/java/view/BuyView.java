package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // Purchase Button
        // TODO: implement purchase button
        JButton purchaseButton = new JButton("Confirm Purchase");
        purchaseButton.addActionListener(new ActionListener() {
                                             @Override
                                             public void actionPerformed(ActionEvent e) {
                                                 System.out.println("Purchase button clicked");
                                             }
                                         });

        // Item Panel for Sprinkler
        // TODO: how much area does the sprinkler water?
        JPanel itemPanel1 = createItemPanel("Sprinkler", "0", "Automatically waters crops in 1 2x2 area");

        // TODO: figure out what else goes on the buy menu
        JPanel itemPanel2 = createItemPanel("item 2", "0", 1, "item 2 description");
        JPanel itemPanel3 = createItemPanel("item 3", "0", 1, "item 3 description");
        JPanel itemPanel4 = createItemPanel("item 4", "0", 1, "item 4 description");

        // Main Panel (White Background)
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        mainPanel.add(itemPanel1, gbc);
        gbc.gridy = 1;
        mainPanel.add(itemPanel2, gbc);
        gbc.gridy = 2;
        mainPanel.add(itemPanel3, gbc);
        gbc.gridy = 3;
        mainPanel.add(itemPanel4, gbc);
        gbc.gridy = 4;
        mainPanel.add(purchaseButton, gbc);
        mainPanel.setBackground(Color.WHITE);

        // Background Panel (Brown)
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.add(topPanel, BorderLayout.NORTH);
        backgroundPanel.add(mainPanel, BorderLayout.CENTER);

        // Frame
        JFrame frame = new JFrame("Buy Menu");
        frame.setSize(741, 420);
        frame.setContentPane(backgroundPanel);
        frame.getContentPane().setBackground(new java.awt.Color(169, 152, 126));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // TODO: implement updateBarnBucks so that it updates with the amount of barnBucks the user has. Not sure if this should be in the BuyView class or the Farm
    public static void updateBarnBucks(FarmLabel label, int amount) {
        label.setText("                   Barn Bucks: " + amount);
    }

    private static JPanel createItemPanel(String itemName, String price, String description) {
        // Item Label
        JLabel itemLabel = new JLabel(itemName);

        // Item Description Label
        JLabel descriptionLabel = new JLabel(description);

        // purchaseButton
        JButton purchaseButton = new JButton("Purchase");
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int priceInt = Integer.parseInt(price);
                // TODO: access barnBucks and add to tools
//                if (priceInt < barnBucks) {
//                    barnBucks -= priceInt;
//                    updateBarnBucks(barnBucksLabel, barnBucks);
//                    System.out.println("Purchased " + itemName);
//                } else {
//                    System.out.println("Not enough barn bucks");
            }
        });
        // Item Panel
        JPanel itemPanel = new JPanel(new GridBagLayout());
        itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 150, 0, 200));
        GridBagConstraints gbc = new GridBagConstraints();

        // Add Item Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        itemPanel.add(itemLabel, gbc);

        // Add Price
        gbc.gridx = 1;
        itemPanel.add(new JLabel("Price: " + price), gbc);

        // Add Purchase Button
        gbc.gridx = 4;
        itemPanel.add(descriptionLabel, gbc);

        // Add Description
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        itemPanel.add(purchaseButton, gbc);

        return itemPanel;

    }

    private static JPanel createItemPanel(String itemName, String price, int maxQuantity, String description) {
        // Item Label
        JLabel itemLabel = new JLabel(itemName);

        // Price Label
        JLabel priceLabel = new JLabel("price: " + price);

        // Quantity Label
        JLabel quantityLabel = new JLabel("0");
        quantityLabel.setPreferredSize(new Dimension(30, 20));
        quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Item Description Label
        JLabel descriptionLabel = new JLabel(description);

        // Buttons
        JButton minusButton = new JButton("-");
        JButton plusButton = new JButton("+");

        // ActionListener for minus button
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(quantityLabel.getText());
                if (currentQuantity > 0) {
                    quantityLabel.setText(String.valueOf(currentQuantity - 1));
                }
            }
        });

        // ActionListener for plus button
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(quantityLabel.getText());
                if (currentQuantity < maxQuantity) {
                    quantityLabel.setText(String.valueOf(currentQuantity + 1));
                }
            }
        });

        // Item Panel
        JPanel itemPanel = new JPanel(new GridBagLayout());
        itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 150, 0, 200));
        GridBagConstraints gbc = new GridBagConstraints();

        // Add Item Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        itemPanel.add(new JLabel(itemName), gbc);

        // Add Price
        gbc.gridx = 1;
        itemPanel.add(new JLabel("Price: " + price), gbc);

        // Add Minus Button
        gbc.gridx = 2;
        itemPanel.add(minusButton, gbc);

        // Add Quantity Label
        gbc.gridx = 3;
        quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(quantityLabel, gbc);

        // Add Plus Button
        gbc.gridx = 4;
        itemPanel.add(plusButton, gbc);

        // Add Description
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        itemPanel.add(new JLabel(description), gbc);

        return itemPanel;
    }
}
