package main.java.view;


import main.java.interface_adapter.farm.WeatherController;
import main.java.interface_adapter.welcome.*;
import main.java.use_case.getweather.InvalidCityException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WelcomeView extends JPanel implements ActionListener, PropertyChangeListener {
    private WelcomeViewModel viewModel;
    FarmLabel title;
    private LoadController loadController;
    private SetCityController setCityController;
    private StartController startController;
    private WeatherController weatherController;

    public WelcomeView(WelcomeViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);
        // Welcome panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        FarmLabel welcome = new FarmLabel("Welcome to", 24);
        title = new FarmLabel("Farms Burner (Toronto)", 36);
        welcomePanel.add(welcome);
        welcomePanel.add(title);
        welcomePanel.setBackground(new java.awt.Color(169, 152, 126));
        // Start button
        FarmButton start = new FarmButton("Start",12);
        start.setHorizontalAlignment(SwingConstants.CENTER);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startController.start();
                weatherController.weather();
                System.out.println("Start");
            }
        });

        FarmButton load = new FarmButton("Load",12);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadController.load();
                weatherController.weather();
                System.out.println("Load");
            }
        });
        // Location
        JPanel locationPanel = new JPanel();
        FarmButton location = (new FarmButton("Set Location:", 12));
        locationPanel.add(location);
        JTextField locationText = new JTextField(20);
        locationText.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        setCityController.setCity(locationText.getText());
                        weatherController.weather();
                        locationText.setText("");
                    }
                    catch (InvalidCityException exception) {
                        setCityController.setCity("Toronto");
                        System.out.println("InvalidCityException");
                        locationText.setText("");
                    }
                }
            }
        });
        location.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setCityController.setCity(locationText.getText());
                    weatherController.weather();
                    locationText.setText("");
                }
                catch (InvalidCityException exception) {
                    setCityController.setCity("Toronto");
                    System.out.println("InvalidCityException");
                    locationText.setText("");
                }
            }
        });
        locationPanel.add(locationText);
        locationPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Main Panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(welcomePanel);
        this.add(start);
        this.add(load);
        this.add(locationPanel);
        this.setBackground(new java.awt.Color(169, 152, 126));

        // Frame
        //JFrame frame = new JFrame("Farms Burner");
        //frame.setSize(741, 420);
        //frame.setContentPane(mainPanel);
        //frame.getContentPane().setBackground(new java.awt.Color(169, 152, 126));
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("city")) {
            String city = ((WelcomeState)(evt.getNewValue())).getCity();
            this.title.setText("Farms Burner (" + city + ")");
        }
    }

    public void setSetCityController(SetCityController setCityController) {
        this.setCityController = setCityController;
    }

    public void setLoadController(LoadController loadController) {
        this.loadController = loadController;
    }

    public void setStartController(StartController startController) {
        this.startController = startController;
    }


    public void setWeatherController(WeatherController weatherController) {
        this.weatherController = weatherController;
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
