package main.java.view;

import javax.swing.*;
import java.awt.*;

public class Info extends JPanel {
    public Info() {
        JPanel landInfo = new JPanel();
        landInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_START;

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

        gbc.gridx = 0;
        gbc.gridy = 3;
        landInfo.add(new CropLabel(" ", 25, Color.black),gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        landInfo.add(new FarmLabel("Unclaimed", 15),gbc);

        landInfo.setBackground(new Color(169,152,126));

        JPanel controlInfo = new JPanel();
        controlInfo.setLayout(new BoxLayout(controlInfo, BoxLayout.Y_AXIS));
        controlInfo.add(new FarmLabel("Shift + Click to claim land"));
        controlInfo.add(new FarmLabel("Ctrl + Click to Plant"));
        controlInfo.add(new FarmLabel("Alt + Click to Water"));
        controlInfo.add(new FarmLabel("Ctrl + Alt to Fertilize"));
        controlInfo.setBackground(new Color(169,152,126));

        this.setBackground(new Color(169,152,126));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(landInfo, BorderLayout.CENTER);
        this.add(controlInfo);
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(271, 250);
//        frame.getContentPane().add(landInfo, BorderLayout.CENTER);
//        frame.getContentPane().add(controlInfo, BorderLayout.SOUTH);
//        frame.setVisible(true);
    }
}
