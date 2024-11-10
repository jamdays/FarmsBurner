package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeView {
    public static void main(String[] args) {
        // Welcome panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        JLabel welcome = new JLabel("Welcome to");
        welcome.setFont(new Font("Press Start 2P", Font.PLAIN, 24));
        JLabel title = new JLabel("Farms Burner");
        title.setFont(new Font("Press Start 2P", Font.PLAIN, 36));
        welcomePanel.add(welcome);
        welcomePanel.add(title);
        welcomePanel.setBackground(new java.awt.Color(169, 152, 126));

        // Start button
        JButton start = new JButton("Start");
        start.setFont(new Font("Press Start 2P", Font.PLAIN, 12));
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start");
            }
        });

        // Location
        JPanel locationPanel = new JPanel();
        JButton location = (new JButton("Set Location:"));
        location.setFont(new Font ("Press Start 2P", Font.PLAIN, 12));
        locationPanel.add(location);
        JTextField locationText = new JTextField(20);
        locationText.setFont(new Font("Press Start 2P", Font.PLAIN, 12));
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
