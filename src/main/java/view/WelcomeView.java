package main.java.view;


import main.java.interface_adapter.welcome.LoadController;
import main.java.interface_adapter.welcome.SetCityController;
import main.java.interface_adapter.welcome.WelcomeViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WelcomeView extends JPanel implements ActionListener, PropertyChangeListener {
    private WelcomeViewModel viewModel;
    private LoadController loadController;
    private SetCityController setCityController;

    public WelcomeView(WelcomeViewModel viewModel) {
        this.viewModel = viewModel;
        // Welcome panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        FarmLabel welcome = new FarmLabel("Welcome to", 24);
        FarmLabel title = new FarmLabel("Farms Burner", 36);
        this.add(welcome);
        this.add(title);
        this.setBackground(new java.awt.Color(169, 152, 126));

        // Start button
        FarmButton start = new FarmButton("Start",12);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start");
            }
        });

        FarmButton load = new FarmButton("Load",12);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadController.load();
                System.out.println("Load");
            }
        });
        // Location
        JPanel locationPanel = new JPanel();
        FarmButton location = (new FarmButton("Set Location:", 12));
        locationPanel.add(location);
        JTextField locationText = new JTextField(20);
        location.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCityController.setCity(locationText.getText());
                System.out.println("Set location to " + locationText.getText());
            }
        });
        locationPanel.add(locationText);
        locationPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(this);
        mainPanel.add(start);
        mainPanel.add(locationPanel);

        // Frame
        JFrame frame = new JFrame("Farms Burner");
        frame.setSize(741, 420);
        frame.setContentPane(mainPanel);
        frame.getContentPane().setBackground(new java.awt.Color(169, 152, 126));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public void setSetCityController(SetCityController setCityController) {
        this.setCityController = setCityController;
    }

    public void setLoadController(LoadController loadController) {
        this.loadController = loadController;
    }

    public static void main(String[] args) {
        // Welcome panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        FarmLabel welcome = new FarmLabel("Welcome to", 24);
        FarmLabel title = new FarmLabel("Farms Burner", 36);
        welcomePanel.add(welcome);
        welcomePanel.add(title);
        welcomePanel.setBackground(new java.awt.Color(169, 152, 126));

        // Start button
        FarmButton start = new FarmButton("Start",12);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start");
            }
        });

        // Location
        JPanel locationPanel = new JPanel();
        FarmButton location = (new FarmButton("Set Location:", 12));
        locationPanel.add(location);
        JTextField locationText = new JTextField(20);
        location.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Set location to " + locationText.getText());
            }
        });
        locationPanel.add(locationText);
        locationPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(welcomePanel);
        mainPanel.add(start);
        mainPanel.add(locationPanel);

        // Frame
        JFrame frame = new JFrame("Farms Burner");
        frame.setSize(741, 420);
        frame.setContentPane(mainPanel);
        frame.getContentPane().setBackground(new java.awt.Color(169, 152, 126));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
