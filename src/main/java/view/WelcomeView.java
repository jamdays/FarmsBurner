package main.java.view;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeView {
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
