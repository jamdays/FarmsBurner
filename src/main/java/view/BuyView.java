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

import main.java.interface_adapter.toolmenu.*;

/**
 * Buy View.
 */
public class BuyView extends JPanel implements ActionListener, PropertyChangeListener {
    private JLabel bbLabel;
    private ToolMenuViewModel viewModel;
    private BuyController buyController;
    private UpgradeController upgradeController;
    private GetToolBoughtController getToolBoughtController;
    private GetBarnBucksController getBarnBucksController;

    public BuyView(ToolMenuViewModel viewModel, GetToolBoughtController getToolBoughtController, GetBarnBucksController getBarnBucksController) {
        // initialize instance variables
        bbLabel = new FarmLabel("Hi");
        this.viewModel = viewModel;
        viewModel.addPropertyChangeListener(this);
        this.getBarnBucksController = getBarnBucksController;
        int barnBucks = getBarnBucksController.getbb();
        bbLabel = new FarmLabel("Barn Bucks: " + barnBucks, 18);
        this.getToolBoughtController = getToolBoughtController;
        // Buy Menu
        FarmLabel buyMenuTitle = new FarmLabel("Buy Menu", 18);
        buyMenuTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        JPanel topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topLeftPanel.add(buyMenuTitle);
        topLeftPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Barn Bucks
        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRightPanel.add(bbLabel);
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
      
        createItemPanel("Sprinkler", "Waters crops in a large area.", mainPanel, gbc, 0);
        createItemPanel("Planter",  "Plants crops in a large area.", mainPanel, gbc, 1);
        createItemPanel("Harvester",  "Harvests crops in a large area.", mainPanel, gbc, 2);
        createItemPanel("Tiller",  "Claims land in a large area.", mainPanel, gbc, 3);
        createItemPanel("Fertilizer",  "Fertilizes a large area of tilled land.", mainPanel, gbc, 4);

        mainPanel.setBackground(new java.awt.Color(169, 152, 126));

        this.setBackground(new java.awt.Color(169, 152, 126));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Update Barn Bucks.
     * @param label .
     * @param amount .
     */
    public static void updateBarnBucks(FarmLabel label, int amount) {
        label.setText("Barn Bucks: " + amount);
    }

    private void createItemPanel(String itemName, String description, JPanel panel, GridBagConstraints gbc,
                                 int startY) {
        // Item Label
        int[] prices = {0, 300, 900, 2700, 8100};
        int level = (int) getToolBoughtController.getToolBought(itemName).get(1);
        JLabel itemLabel = new JLabel("Level" + " " + (level - 1) + " " + itemName + " ");
        itemLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Item Description Label
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton purchaseButton = new JButton();
        // purchaseButton
        if (!(boolean) getToolBoughtController.getToolBought(itemName).get(0)) {
            purchaseButton.setText("Purchase");
        }
        else if ((int) getToolBoughtController.getToolBought(itemName).get(1) < 5) {
            purchaseButton.setText("Upgrade");
        }
        else {
            purchaseButton.setText("Max Level");
        }
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // buy tool if unpurchased
                if (!(boolean) getToolBoughtController.getToolBought(itemName).get(0)) {
                    buyController.buy(itemName);
                    purchaseButton.setText("Upgrade");
                }
                // upgrade tool if purchased and not maxed out
                else if ((int) getToolBoughtController.getToolBought(itemName).get(1) < 5) {
                    upgradeController.upgrade(itemName);
                    itemLabel.setText("Level " + (Integer.parseInt(itemLabel.getText()
                            .replaceAll("[^0-9]", "")) + 1) + " " + itemName + " ");
                    if ((int) getToolBoughtController.getToolBought(itemName).get(1) == 5) {
                        purchaseButton.setText("Max Level");
                    }
                }
            }
        });

        // Add Item Name
        gbc.gridx = 0;
        gbc.gridy = startY * 2;
        gbc.gridwidth = 1;
        panel.add(itemLabel, gbc);

        // Add Price
        gbc.gridx = 1;
        JLabel priceLabel = new JLabel("Price: " + prices[level - 1] + " ");
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

    /**
     * Set buy controller.
     * @param buyController .
     */
    public void setBuyController(BuyController buyController) {
        this.buyController = buyController;
    }

    /**
     * Set upgrade controller.
     * @param upgradeController .
     */
    public void setUpgradeController(UpgradeController upgradeController) {
        this.upgradeController = upgradeController;
    }

    /**
     * Set get tool bought controller.
     * @param getToolBoughtController .
     */
    public void setGetToolBoughtController(GetToolBoughtController getToolBoughtController) {
        this.getToolBoughtController = getToolBoughtController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        bbLabel.setText("Barn Bucks: " + ((ToolMenuState)evt.getNewValue()).getBb());
    }
}
