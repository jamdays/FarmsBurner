package main.java.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.interface_adapter.farm.GetBarnBucksController;
import main.java.interface_adapter.toolmenu.BuyController;
import main.java.interface_adapter.toolmenu.GetToolBoughtController;
import main.java.interface_adapter.toolmenu.ToolMenuViewModel;
import main.java.interface_adapter.toolmenu.UpgradeController;

/**
 * Buy View.
 */
public class BuyView extends JPanel implements ActionListener, PropertyChangeListener {
    private ToolMenuViewModel viewModel;
    private BuyController buyController;
    private UpgradeController upgradeController;
    private GetToolBoughtController getToolBoughtController;
    private GetBarnBucksController getBarnBucksController;
    private int barnBucks;

    public BuyView(ToolMenuViewModel viewModel, GetToolBoughtController getToolBoughtController, GetBarnBucksController getBarnBucksController) {
        // initialize instance variables
        this.viewModel = viewModel;
        viewModel.addPropertyChangeListener(this);
        this.barnBucks = 10;
        this.getToolBoughtController = getToolBoughtController;
        this.getBarnBucksController = getBarnBucksController;

        // Buy Menu
        FarmLabel buyMenuTitle = new FarmLabel("Buy Menu", 18);
        buyMenuTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        JPanel topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topLeftPanel.add(buyMenuTitle);
        topLeftPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Barn Bucks
        barnBucks = getBarnBucksController.getBarnBucks();
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
      
        createItemPanel("Sprinkler", 5, "Waters crops in a large area.", mainPanel, gbc, 0, barnBucksLabel);
        createItemPanel("Planter", 10, "Plants crops in a large area.", mainPanel, gbc, 1, barnBucksLabel);
        createItemPanel("Harvester", 10, "Harvests crops in a large area.", mainPanel, gbc, 2, barnBucksLabel);
        createItemPanel("Tiller", 15, "Claims land in a large area.", mainPanel, gbc, 3, barnBucksLabel);
        createItemPanel("Fertilizer", 20, "Fertilizes a large area of tilled land.", mainPanel, gbc, 4, barnBucksLabel);

        mainPanel.setBackground(new java.awt.Color(169, 152, 126));

        this.setBackground(new java.awt.Color(169, 152, 126));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    // TODO: implement updateBarnBucks so that it updates with the amount of barnBucks the user has. Not sure if this should be in the BuyView class or the Farm

    /**
     * Update Barn Bucks.
     * @param label .
     * @param amount .
     */
    public static void updateBarnBucks(FarmLabel label, int amount) {
        label.setText("Barn Bucks: " + amount);
    }

    private void createItemPanel(String itemName, int price, String description, JPanel panel, GridBagConstraints gbc,
                                 int startY, FarmLabel barnBucksLabel) {
        // Item Label
        int level = (int)getToolBoughtController.getToolBought(itemName).get(1);
        JLabel itemLabel = new JLabel("Level" + " " + (level - 1) + " " + itemName + " ");
        itemLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Item Description Label
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton purchaseButton = new JButton();
        // purchaseButton
        if (!(boolean)getToolBoughtController.getToolBought(itemName).get(0)) {
            purchaseButton.setText("Purchase");
        }
        else if ((int)getToolBoughtController.getToolBought(itemName).get(1) < 5) {
            purchaseButton.setText("Upgrade");
        }
        else {
            purchaseButton.setText("Max Level");
        }
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // buy tool if unpurchased
                if (!(boolean)getToolBoughtController.getToolBought(itemName).get(0)) {
                    buyController.buy(itemName);
                    purchaseButton.setText("Upgrade");
                    barnBucksLabel.setText("Barn Bucks: " + barnBucks);
                }
                // upgrade tool if purchased and not maxed out
                else if ((int)getToolBoughtController.getToolBought(itemName).get(1) < 5) {
                    upgradeController.upgrade(itemName);
                    barnBucksLabel.setText("Barn Bucks: " + barnBucks);
                    itemLabel.setText("Level " + (Integer.parseInt(itemLabel.getText().replaceAll("[^0-9]", "")) + 1) + " " + itemName + " ");
                    if ((int)getToolBoughtController.getToolBought(itemName).get(1) == 5) {
                        purchaseButton.setText("Max Level");
                    }
                }
                // TODO: access barnBucks and add to tools

//                if (priceInt < barnBucks) {
//                    barnBucks -= priceInt;
//                    updateBarnBucks(barnBucksLabel, barnBucks);
//                    System.out.println("Purchased " + itemName);
//                } else {
//                    System.out.println("Not enough barn bucks");
                barnBucks -= price;
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

    public void setGetToolBoughtController(GetToolBoughtController getToolBoughtController) {
        this.getToolBoughtController = getToolBoughtController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Change the level and Barnbucks somehow

    }
}
