package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * Forecast view.
 */
public class ForecastView extends JPanel {
    public ForecastView(List<String> conditions, String city) {
        JLabel title = new JLabel("Weather Forecast " + city);
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
            if (i > 1 && (i + 1) % 4 == 0) {
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

}
