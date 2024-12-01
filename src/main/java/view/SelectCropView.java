package main.java.view;

import main.java.interface_adapter.selectcrop.SelectCropState;
import main.java.interface_adapter.selectcrop.SelectCropViewModel;
import main.java.interface_adapter.selecttool.SelectToolState;
import main.java.view.FarmButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SelectCropView extends JPanel implements ActionListener, PropertyChangeListener {

    // instance variables

    private String currCrop;
    private SelectCropViewModel viewModel;

    // constructor
    public SelectCropView() {
        // initialize instance variables

        // show the view
        JLabel title = new JLabel("Select a Crop");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.setBackground(new java.awt.Color(169, 152, 126));
        topPanel.setPreferredSize(new Dimension(350,50));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel currSelected = new JLabel("Current Crop: " + currCrop);
        currSelected.setFont(new Font("Tahoma", Font.BOLD, 20));
        currSelected.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel midPanel = new JPanel(new BorderLayout());
        midPanel.add(currSelected, BorderLayout.CENTER);
        midPanel.setBackground(new java.awt.Color(169, 152, 126));
        midPanel.setPreferredSize(new Dimension(350,25));

        FarmButton chooseSnowberry = new FarmButton("Snowberry");
        chooseSnowberry.setPreferredSize(new Dimension(175,25));

        chooseSnowberry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // haven't connected to controller yet, so temporarily just print out snowberry
                currSelected.setText("Current Crop: Snowberry");
            }
        });

        FarmButton chooseRice = new FarmButton("     Rice     ");
        chooseRice.setPreferredSize(new Dimension(175,25));

        chooseRice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // haven't connected to controller yet, so temporarily just print out rice
                currSelected.setText("Current Crop: Rice");
            }
        });

        FarmButton chooseWheat = new FarmButton("    Wheat    ");
        chooseWheat.setPreferredSize(new Dimension(175,25));

        chooseWheat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // haven't connected to controller yet, so temporarily just print out wheat
                currSelected.setText("Current Crop: Wheat");
            }
        });

        FarmButton chooseCorn = new FarmButton("     Corn    ");
        chooseCorn.setPreferredSize(new Dimension(175,25));

        chooseCorn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // haven't connected to controller yet, so temporarily just print out harvester
                currSelected.setText("Current Crop: Corn");
            }
        });

        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        bottomPanel.setBackground(new java.awt.Color(169, 152, 126));
        bottomPanel.setPreferredSize(new Dimension(350,100));

        gbc.gridx = 0;
        gbc.gridy = 0;
        bottomPanel.add(chooseSnowberry, gbc);
        gbc.gridx = 1;
        bottomPanel.add(chooseRice, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        bottomPanel.add(chooseWheat, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        bottomPanel.add(chooseCorn, gbc);

        this.setLayout(new BorderLayout());
        this.setBackground(new java.awt.Color(169, 152, 126));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(midPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SelectCropState state = (SelectCropState) evt.getNewValue();
        this.currCrop = state.getCurrCrop();
    }
}
