package main.java.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

public class FarmButton extends JButton {
    private static Color cream = new Color(169, 152, 126);

    public FarmButton(String text) {
        super(text);
        this.setFont(new Font("Press Start 2P", Font.BOLD, 20));
        setBackground(cream);
        setForeground(new Color(84, 48, 28));
        this.setFocusPainted(false);
    }

    public FarmButton(String text, int size) {
        super(text);
        this.setFont(new Font("Press Start 2P", Font.BOLD, size));
        setBackground(cream);
        this.setFocusPainted(false);
    }

    public FarmButton(String text, int size, Color color) {
        super(text);
        this.setFont(new Font("Press Start 2P", Font.BOLD, size));
        setBackground(color);
        this.setFocusPainted(false);
    }

}
