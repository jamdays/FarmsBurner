package main.java.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.interface_adapter.farm.LoadFarmController;
import main.java.interface_adapter.farm.WeatherController;
import main.java.interface_adapter.welcome.LoadController;
import main.java.interface_adapter.welcome.SetCityController;
import main.java.interface_adapter.welcome.StartController;
import main.java.interface_adapter.welcome.WelcomeState;
import main.java.interface_adapter.welcome.WelcomeViewModel;
import main.java.use_case.getweather.InvalidCityException;

/**
 * Welcome-view.
 */
public class WelcomeView extends JPanel implements ActionListener, PropertyChangeListener {
    private FarmLabel title;
    private WelcomeViewModel viewModel;
    private JLabel backgroundLabel;
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
        String imgurlstr = "/main/resources/welcomeBg.png";
        URL imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            backgroundImg = new ImageIcon(imgurl);
        }
        backgroundLabel.setIcon(new ImageIcon(backgroundImg.getImage()
                .getScaledInstance(1200, 675, Image.SCALE_SMOOTH)));
        this.add(backgroundLabel);

        title = new FarmLabel("(Toronto)", 36);

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
        FarmButton location = new FarmButton("Set Location:", 12);
        locationPanel.add(location);
        locationPanel.setOpaque(false);
        locationPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
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

        // Spacer
        JLabel spacerLabel = new JLabel(" ");
        spacerLabel.setOpaque(false);
        spacerLabel.setFont(new Font("Arial", Font.PLAIN, 350));

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(start);
        buttonsPanel.add(load);

        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonsPanel.add(title);
        // Main Panel
        backgroundLabel.setLayout(new BoxLayout(backgroundLabel, BoxLayout.Y_AXIS));
        backgroundLabel.add(spacerLabel);
        backgroundLabel.add(title);
        backgroundLabel.add(start);
        backgroundLabel.add(load);
        backgroundLabel.add(locationPanel);

        // Set main panel layout
        this.setLayout(new BorderLayout());
        this.add(backgroundLabel);

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

    /**
     * Set set city controller.
     * @param setCityController .
     */
    public void setSetCityController(SetCityController setCityController) {
        this.setCityController = setCityController;
    }

    /**
     * Set load controller.
     * @param loadController .
     */
    public void setLoadController(LoadController loadController) {
        this.loadController = loadController;
    }

    /**
     * Set start controller.
     * @param startController .
     */
    public void setStartController(StartController startController) {
        this.startController = startController;
    }

    /**
     * Set weather controller.
     * @param weatherController .
     */
    public void setWeatherController(WeatherController weatherController) {
        this.weatherController = weatherController;
    }

    /**
     * Set load farm controller.
     * @param loadFarmController .
     */
    public void setLoadFarmController(LoadFarmController loadFarmController) {
        this.loadFarmController = loadFarmController;
    }
}
