package main.java.view;

import main.java.interface_adapter.farm.GetBarnBucksController;
import main.java.interface_adapter.sell.GetStorageController;
import main.java.interface_adapter.sell.SellController;
import main.java.interface_adapter.sell.SellState;
import main.java.interface_adapter.sell.SellViewModel;
import main.java.entity.FarmSingleton;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.entity.FarmSingleton;
import main.java.interface_adapter.sell.SellController;
import main.java.interface_adapter.sell.SellViewModel;

/**
 * Sell view.
 */
public class SellView extends JPanel implements ActionListener, PropertyChangeListener {
    private int crops;
    private int barnBucks;
    private int cost;
    private SellViewModel sellViewModel;
    private SellController sellController;
    private GetStorageController getStorageController;
    private GetBarnBucksController getBarnBucksController;

    public SellView(SellViewModel sellViewModel, GetStorageController getStorageController, GetBarnBucksController getBarnBucksController) {
        this.getBarnBucksController = getBarnBucksController;
        this.sellViewModel = sellViewModel;
        this.crops = FarmSingleton.getInstance().getFarm().getStorage().getCrops().size();
        this.barnBucks = FarmSingleton.getInstance().getFarm().getBarnBucks();
        this.getStorageController = getStorageController;
        // TODO: Add actual cost of crops

        List<Integer> storage = getStorageController.getStorage();
        crops = storage.size();

        JLabel cropLabel = new JLabel("Crops: " + crops);
        cropLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

        barnBucks = getBarnBucksController.getBarnBucks();
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
                    // new code
                    amountLabel.setText(String.valueOf(currentQuantity - 1));
                    // store the total value of the first (amountLabel) crops in result
                    int result = 0;
                    for (int i = 0; i < Integer.parseInt(amountLabel.getText()); i++) {
                        result += storage.get(i);
                    }
                    earningLabel.setText("Total Earnings: " + result + " BarnBucks");
                    // previous code
                    // amountLabel.setText(String.valueOf(currentQuantity - 1));
                    // earningLabel.setText("Total Earnings: " + Integer.parseInt(amountLabel.getText()) * cost);
                }
            }
        });

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(amountLabel.getText());
                if (currentQuantity < crops) {
                    // new code
                    amountLabel.setText(String.valueOf(currentQuantity + 1));
                    // store the total value of the first (amountLabel) crops in result
                    int result = 0;
                    for (int i = 0; i < Integer.parseInt(amountLabel.getText()); i++) {
                        result += storage.get(i);
                    }
                    earningLabel.setText("Total Earnings: " + result + " BarnBucks");
                    // amountLabel.setText(String.valueOf(currentQuantity + 1));
                    // earningLabel.setText("Total Earnings: " + Integer.parseInt(amountLabel.getText()) * cost);
                }
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentQuantity = Integer.parseInt(amountLabel.getText());
                int barnBucks = Integer.parseInt(barnBucksLabel.getText().substring(12));
                crops = crops - currentQuantity;
                cropLabel.setText("Crops: " + crops);
                int result = 0;
                for (int i = 0; i < Integer.parseInt(amountLabel.getText()); i++) {
                    result += storage.get(i);
                }
                barnBucksLabel.setText("Barn Bucks: " + (barnBucks + result));
                amountLabel.setText("0");
                earningLabel.setText("Total Earnings: 0");
                sellController.sell(currentQuantity);
            }
        });

        this.setLayout(new BorderLayout());
        this.setBackground(new java.awt.Color(169, 152, 126));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(contentPanel);
    }

    /**
     * Action performed.
     * @param e The event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Property change.
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    /**
     * Sets the sellController, CALL BEFORE ANY BUTTONS CAN BE PRESSED.
     * @param sellController the sellController
     */
    public void setSellController(SellController sellController) {
        this.sellController = sellController;
    }
}
