package main.java.view;

import javax.swing.*;
import java.awt.*;

public class Info {
    public static void main(String[] args) {
        JPanel landInfo = new JPanel();
        landInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;

//        JPanel wetLandInfo = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        landInfo.add(new CropLabel(" ", 25, new Color(50,20,20)),gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        landInfo.add(new FarmLabel("Wet Land", 15), gbc);

//        JPanel dryLandInfo = new JPanel();

        gbc.gridx = 0;
        gbc.gridy = 1;
        landInfo.add(new CropLabel(" ", 25, new Color(75,40,40)),gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        landInfo.add(new FarmLabel("Dry Land", 15),gbc);

        CropLabel sprout = new CropLabel("T", 25, new Color(75,40,40));
        sprout.setForeground(new Color(20,130,50));
        sprout.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 2;
        landInfo.add(sprout, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        landInfo.add(new FarmLabel("Sprout", 15), gbc);

//        landInfo.add(wetLandInfo);
//        landInfo.add(dryLandInfo);
//        landInfo.add(sproutInfo);
        landInfo.setBackground(new Color(169,152,126));

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(271, 438);
        frame.setBackground(new Color(169, 152, 126));
        frame.getContentPane().add(landInfo, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
