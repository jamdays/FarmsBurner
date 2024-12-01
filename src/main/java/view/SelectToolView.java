package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import main.java.interface_adapter.selecttool.SelectToolController;
import main.java.interface_adapter.selecttool.SelectToolState;
import main.java.interface_adapter.selecttool.SelectToolViewModel;
import main.java.view.FarmButton;

public class SelectToolView extends JPanel implements ActionListener, PropertyChangeListener {

    // instance variables

    private SelectToolViewModel viewModel;
    private String currTool = "none";
    private SelectToolController controller;

    // constructor
    public SelectToolView(SelectToolViewModel viewModel) {
        // initialize instance variables
        this.viewModel = viewModel;
        viewModel.addPropertyChangeListener(this);
        // show the view
        JLabel title = new JLabel("Select a Tool");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.setBackground(new java.awt.Color(169, 152, 126));
        topPanel.setPreferredSize(new Dimension(350,50));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel currSelected = new JLabel("Current Tool: " + currTool);
        currSelected.setFont(new Font("Tahoma", Font.BOLD, 20));
        currSelected.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel midPanel = new JPanel(new BorderLayout());
        midPanel.add(currSelected, BorderLayout.CENTER);
        midPanel.setBackground(new java.awt.Color(169, 152, 126));
        midPanel.setPreferredSize(new Dimension(350,50));

        FarmButton chooseSprinkler = new FarmButton("Sprinkler");
        chooseSprinkler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // notify the controller to start the use case (clean architecture)
                controller.selectTool("Sprinkler");
                // update the current tool to sprinkler, once the use case has executed
                // currSelected.setText("Current Tool: " + currTool);

                // haven't connected to controller yet, so temporarily just print out harvester
                currSelected.setText("Current Tool: " + currTool);
            }
        });

        FarmButton chooseHarvester = new FarmButton("Harvester");
        chooseHarvester.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // notify the controller to start the use case (clean architecture)
                controller.selectTool("Harvester");
                // update the current tool to harvester, once the use case has executed
                // currSelected.setText("Current Tool: " + currTool);

                // haven't connected to controller yet, so temporarily just print out harvester
                currSelected.setText("Current Tool: " + currTool);
            }
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(chooseSprinkler, BorderLayout.WEST);
        bottomPanel.add(chooseHarvester, BorderLayout.EAST);
        bottomPanel.setBackground(new java.awt.Color(169, 152, 126));
        bottomPanel.setPreferredSize(new Dimension(350,50));

        this.setLayout(new BorderLayout());
        this.setBackground(new java.awt.Color(169, 152, 126));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(midPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    // change the currently selected tool when a new tool is clicked
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SelectToolState state = (SelectToolState) evt.getNewValue();
        this.currTool = state.getCurrTool();
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    public void setController(SelectToolController controller) {
        this.controller = controller;
    }
}
