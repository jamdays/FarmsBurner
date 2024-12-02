package main.java.view;


import main.java.interface_adapter.farm.LoadFarmController;
import main.java.interface_adapter.farm.WeatherController;
import main.java.interface_adapter.welcome.*;
import main.java.use_case.getweather.InvalidCityException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WelcomeView extends JPanel implements ActionListener, PropertyChangeListener {
    private WelcomeViewModel viewModel;
    private JLabel backgroundLabel;
    FarmLabel title;
    private LoadController loadController;
    private SetCityController setCityController;
    private StartController startController;
    private WeatherController weatherController;
    private LoadFarmController loadFarmController;

    public WelcomeView(WelcomeViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);

        this.setLayout(new BorderLayout());

        // Main Panel with background image
        backgroundLabel = new JLabel();
        ImageIcon backgroundImg = new ImageIcon("src/main/resources/welcomeBg.png");
        backgroundLabel.setIcon(new ImageIcon(backgroundImg.getImage().getScaledInstance(1200, 675, Image.SCALE_SMOOTH)));
        this.add(backgroundLabel);

        // Welcome panel
//        FarmLabel welcome = new FarmLabel("Welcome to", 24);
         title = new FarmLabel("(Toronto)", 36);
//        welcomePanel.add(welcome);
//        welcomePanel.add(title);
//        welcomePanel.setBackground(new java.awt.Color(169, 152, 126));

        // Start button
        FarmButton start = new FarmButton("Start", 12);
        start.setHorizontalAlignment(SwingConstants.CENTER);
        start.setOpaque(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startController.start();
                weatherController.weather();
                System.out.println("Start");
            }
        });

        FarmButton load = new FarmButton("Load", 12);
        load.setOpaque(false);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadController.load();
                loadFarmController.load();
                weatherController.weather();
                System.out.println("Load");
            }
        });
        // Location
        JPanel locationPanel = new JPanel();
        FarmButton location = (new FarmButton("Set Location:", 12));
        locationPanel.add(location);
        locationPanel.setOpaque(false);
        locationPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        JTextField locationText = new JTextField(20);
        locationText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
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
//        locationPanel.setBackground(new java.awt.Color(169, 152, 126));

        // Spacer
        JLabel spacerLabel = new JLabel(" ");
        spacerLabel.setOpaque(false);
        spacerLabel.setFont(new Font("Arial", Font.PLAIN, 350));

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(start);
        buttonsPanel.add(load);

        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        buttonsPanel.add(title);
        // Main Panel
        backgroundLabel.setLayout(new BoxLayout(backgroundLabel, BoxLayout.Y_AXIS));
        backgroundLabel.add(spacerLabel);
        backgroundLabel.add(title);
        backgroundLabel.add(start);
        backgroundLabel.add(load);
//        backgroundLabel.add(buttonsPanel);
        backgroundLabel.add(locationPanel);

        // Set main panel layout
        this.setLayout(new BorderLayout());
        this.add(backgroundLabel);

//        this.add(welcomePanel);
//        this.add(start);
//        this.add(load);
//        this.add(locationPanel);
//        this.setBackground(new java.awt.Color(169, 152, 126));

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
            String city = ((WelcomeState) (evt.getNewValue())).getCity();
            this.title.setText("(" + city + ")");
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

    public void setLoadFarmController(LoadFarmController loadFarmController) {
        this.loadFarmController = loadFarmController;
    }
}
