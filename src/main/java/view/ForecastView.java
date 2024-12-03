package main.java.view;

import main.java.data_access.OpenWeatherAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class ForecastView extends JPanel{
    public ForecastView(List<String> conditions, String city) {
        JLabel title = new JLabel("Weather Forecast ");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.setBackground(new java.awt.Color(169, 152, 126));
        topPanel.setPreferredSize(new Dimension(350,50));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
        descriptionPanel.setBackground(new java.awt.Color(169, 152, 126));
        descriptionPanel.setBackground(new java.awt.Color(169, 152, 126));
        for (int i = 0; i < conditions.size(); i++) {
            JLabel tempDescription = new JLabel(conditions.get(i));
            tempDescription.setHorizontalAlignment(SwingConstants.CENTER);
            tempDescription.setFont(new Font("Arial", Font.PLAIN, 18));
            descriptionPanel.add(tempDescription);
            if (i > 1 && (i + 1) % 4 == 0){
                JLabel spacing = new JLabel("\n");
                spacing.setHorizontalAlignment(SwingConstants.CENTER);
                spacing.setFont(new Font("Arial", Font.PLAIN, 18));
                descriptionPanel.add(spacing);
            }
        }

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new java.awt.Color(169, 152, 126));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.add(descriptionPanel, BorderLayout.CENTER);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionPanel);
        descriptionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.setLayout(new BorderLayout());
        this.setBackground(new java.awt.Color(169, 152, 126));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(descriptionScrollPane, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
    }
}
