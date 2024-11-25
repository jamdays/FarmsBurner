package view;

import javax.swing.*;
import java.awt.*;

public class WeatherView extends JPanel {
    public WeatherView(String city, String temp, String conditions, String cloudCoverage) {
        this.setBackground(new Color(169,152,126));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_START;

        JLabel header = new JLabel();
        header.setText("Current Weather for " + city);
        JLabel tempPanel = new JLabel();
        tempPanel.setText("Temperature: " + temp + "°C");
        JPanel conditionsPanel = new JPanel();
        JPanel cloudCoveragePanel = new JPanel();

        this.add(header);
        this.add(tempPanel);
        this.add(conditionsPanel);
        this.add(cloudCoveragePanel);
    }
}
