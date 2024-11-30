package main.java.view;

import main.java.interface_adapter.sell.SellController;
import main.java.interface_adapter.sell.SellState;
import main.java.interface_adapter.sell.SellViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SellView extends JPanel implements ActionListener, PropertyChangeListener {
    int crops;
    int barnBucks;
    int cost;
    private SellViewModel sellViewModel;
    private SellController sellController;

    public SellView(SellViewModel sellViewModel) {
        this.sellViewModel = sellViewModel;
        this.crops = 10000;
        this.barnBucks = 0;
        this.cost = 15;

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
                sellController.sell(currentQuantity);
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

    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    /**
     * Sets the sellController, CALL BEFORE ANY BUTTONS CAN BE PRESSED
     * @param sellController the sellController
     */
    public void setSellController(SellController sellController) {
        this.sellController = sellController;
    }
}
