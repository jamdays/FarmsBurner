package main.java.view;

import main.java.interface_adapter.toolmenu.BuyController;
import main.java.interface_adapter.toolmenu.ToolMenuViewModel;
import main.java.interface_adapter.toolmenu.UpgradeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BuyView extends JPanel implements ActionListener, PropertyChangeListener {
    private ToolMenuViewModel viewModel;
    private BuyController buyController;
    private UpgradeController upgradeController;
    private int barnBucks;

    public BuyView(ToolMenuViewModel viewModel) {
        // initialize instance variables
        this.viewModel = viewModel;
        viewModel.addPropertyChangeListener(this);
        this.barnBucks = 10;
        // Buy Menu
        FarmLabel buyMenuTitle = new FarmLabel("Buy Menu", 18);
        buyMenuTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        JPanel topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topLeftPanel.add(buyMenuTitle);
        topLeftPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Barn Bucks
        // TODO: implement barnBucks so that it updates with the amount of barnBucks the user has
        FarmLabel barnBucksLabel = new FarmLabel("Barn Bucks: " + this.barnBucks, 18);
        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRightPanel.add(barnBucksLabel);
        topRightPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Top Panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(topLeftPanel, BorderLayout.WEST);
        topPanel.add(topRightPanel, BorderLayout.EAST);
        topPanel.setBackground(new java.awt.Color(169, 152, 126));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.setSize(new Dimension(500, 400));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // Item Panel for Sprinkler
        // TODO: how much area does the sprinkler water?
      
        createItemPanel("Sprinkler", 5,"Waters crops in a large area.", mainPanel, gbc, 0);
        createItemPanel("Planter", 10, "Plants crops in a large area.", mainPanel, gbc, 1)
        createItemPanel("Harvester", 10, "Harvests crops in a large area.", mainPanel, gbc, 2);
        createItemPanel("Tiller", 15, "Claims land in a large area.", mainPanel, gbc, 3);
        createItemPanel("Fertilizer", 20, "Fertilizes a large area of tilled land.", mainPanel, gbc, 4);

        mainPanel.setBackground(new java.awt.Color(169, 152, 126));

        this.setBackground(new java.awt.Color(169, 152, 126));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    // TODO: implement updateBarnBucks so that it updates with the amount of barnBucks the user has. Not sure if this should be in the BuyView class or the Farm
    public static void updateBarnBucks(FarmLabel label, int amount) {
        label.setText("Barn Bucks: " + amount);
    }

    private void createItemPanel(String itemName, int price, String description, JPanel panel, GridBagConstraints gbc, int startY) {
        // Item Label
        JLabel itemLabel = new JLabel("Level 0 " + itemName + " ");
        itemLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Item Description Label
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        // purchaseButton
        JButton purchaseButton = new JButton("Purchase");
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyController.buy(itemName);
                // TODO: access barnBucks and add to tools
//                if (priceInt < barnBucks) {
//                    barnBucks -= priceInt;
//                    updateBarnBucks(barnBucksLabel, barnBucks);
//                    System.out.println("Purchased " + itemName);
//                } else {
//                    System.out.println("Not enough barn bucks");
                purchaseButton.setText("Upgrade");
                barnBucks -= price;
                itemLabel.setText("Level " + (Integer.parseInt(itemLabel.getText().replaceAll("[^0-9]", "")) + 1) + " " + itemName + " ");
            }
        });

        // Add Item Name
        gbc.gridx = 0;
        gbc.gridy = startY * 2;
        gbc.gridwidth = 1;
        panel.add(itemLabel, gbc);

        // Add Price
        gbc.gridx = 1;
        JLabel priceLabel = new JLabel("Price: " + price + " ");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(priceLabel, gbc);

        // Add Purchase Button
        gbc.gridx = 3;
        panel.add(purchaseButton, gbc);

        // Add Description
        gbc.gridx = 0;
        gbc.gridy = startY * 2 + 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(descriptionLabel, gbc);

    }

    public void setBuyController(BuyController buyController) {
        this.buyController = buyController;
    }

    public void setUpgradeController(UpgradeController upgradeController) {
        this.upgradeController = upgradeController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("buy")){
            System.out.println("Property Change fired (Buying)");
        }
    }
}
