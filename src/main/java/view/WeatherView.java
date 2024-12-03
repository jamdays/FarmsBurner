package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Weather View.
 */
public class WeatherView extends JPanel {
    private String city;
    private String temp;
    private String conditions;
    private String cloudCoverage;

    public WeatherView(String city, String temp, String conditions, String cloudCoverage) {
        this.city = city;
        this.temp = temp;
        this.conditions = conditions;
        this.cloudCoverage = cloudCoverage;

        JLabel title = new JLabel("Current Weather For " + city);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.setBackground(new java.awt.Color(169, 152, 126));
        topPanel.setPreferredSize(new Dimension(350, 50));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setBackground(new java.awt.Color(169, 152, 126));
        JLabel tempDescription = new JLabel(temp);
        tempDescription.setHorizontalAlignment(SwingConstants.CENTER);
        tempDescription.setFont(new Font("Arial", Font.PLAIN, 18));
        JLabel conditionsDescription = new JLabel(conditions);
        conditionsDescription.setHorizontalAlignment(SwingConstants.CENTER);
        conditionsDescription.setFont(new Font("Arial", Font.PLAIN, 18));
        JLabel cloudCoverageDescription = new JLabel(cloudCoverage);
        cloudCoverageDescription.setHorizontalAlignment(SwingConstants.CENTER);
        cloudCoverageDescription.setFont(new Font("Arial", Font.PLAIN, 18));
        descriptionPanel.add(tempDescription);
        descriptionPanel.add(conditionsDescription);
        descriptionPanel.add(cloudCoverageDescription);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new java.awt.Color(169, 152, 126));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(descriptionPanel, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.setBackground(new java.awt.Color(169, 152, 126));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(contentPanel, BorderLayout.CENTER);
    }
}
