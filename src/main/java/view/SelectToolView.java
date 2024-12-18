package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.java.interface_adapter.selecttool.SelectToolController;
import main.java.interface_adapter.selecttool.SelectToolState;
import main.java.interface_adapter.selecttool.SelectToolViewModel;

/**
 * Select tool view.
 */
public class SelectToolView extends JPanel implements ActionListener, PropertyChangeListener {

    // instance variables

    private SelectToolViewModel viewModel;
    private String currTool = "None";
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
        topPanel.setPreferredSize(new Dimension(350, 50));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel currSelected = new JLabel("Current Tool: " + currTool);
        currSelected.setFont(new Font("Tahoma", Font.BOLD, 20));
        currSelected.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel midPanel = new JPanel(new BorderLayout());
        midPanel.add(currSelected, BorderLayout.CENTER);
        midPanel.setBackground(new java.awt.Color(169, 152, 126));
        midPanel.setPreferredSize(new Dimension(350, 50));

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
                System.out.println(currTool);
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
                System.out.println(currTool);
            }
        });

        FarmButton chooseTiller = new FarmButton("Tiller");
        chooseTiller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // notify the controller to start the use case (clean architecture)
                controller.selectTool("Tiller");
                // update the current tool to sprinkler, once the use case has executed
                // currSelected.setText("Current Tool: " + currTool);

                // haven't connected to controller yet, so temporarily just print out harvester
                currSelected.setText("Current Tool: " + currTool);
                System.out.println(currTool);
            }
        });

        FarmButton chooseFertilizer = new FarmButton("Fertilizer");
        chooseFertilizer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // notify the controller to start the use case (clean architecture)
                controller.selectTool("Fertilizer");
                // update the current tool to sprinkler, once the use case has executed
                // currSelected.setText("Current Tool: " + currTool);

                // haven't connected to controller yet, so temporarily just print out harvester
                currSelected.setText("Current Tool: " + currTool);
                System.out.println(currTool);
            }
        });

        FarmButton choosePlanter = new FarmButton("Planter");
        choosePlanter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // notify the controller to start the use case (clean architecture)
                controller.selectTool("Planter");
                // update the current tool to sprinkler, once the use case has executed
                // currSelected.setText("Current Tool: " + currTool);

                // haven't connected to controller yet, so temporarily just print out harvester
                currSelected.setText("Current Tool: " + currTool);
                System.out.println(currTool);
            }
        });

        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        bottomPanel.setBackground(new java.awt.Color(169, 152, 126));
        bottomPanel.setPreferredSize(new Dimension(350, 125));

        gbc.gridx = 0;
        gbc.gridy = 0;
        bottomPanel.add(chooseSprinkler, gbc);
        gbc.gridx = 1;
        bottomPanel.add(chooseHarvester, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        bottomPanel.add(chooseTiller, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        bottomPanel.add(chooseFertilizer, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        bottomPanel.add(choosePlanter, gbc);

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

    /**
     * Action performed.
     * @param evt the event to be processed
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Set controller.
     * @param controller .
     */
    public void setController(SelectToolController controller) {
        this.controller = controller;
    }
}
