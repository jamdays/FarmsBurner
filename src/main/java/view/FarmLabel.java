package main.java.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Farm Label.
 */
public class FarmLabel extends JLabel {

    public FarmLabel(String text) {
        super(text, SwingConstants.CENTER);
    }

    public FarmLabel(String text, int size) {
        super(text, SwingConstants.CENTER);
        this.setFont(new Font("Press Start 2P", Font.PLAIN, size));
    }

    public FarmLabel(String text, int size, Color color) {
        super(text, SwingConstants.CENTER);
        this.setFont(new Font("Press Start 2P", Font.BOLD, size));
        setBackground(color);
        this.setOpaque(true);
    }

}
