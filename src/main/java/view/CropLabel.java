package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Crop Label.
 */
public class CropLabel extends FarmLabel {

    /**
     * Crop Label.
     * @param text .
     */
    public CropLabel(String text) {
        super(text, SwingConstants.CENTER);
        this.setBorder(new LineBorder(Color.WHITE));
        this.setPreferredSize(new Dimension(25, 25));
    }

    /**
     * Crop Label.
     * @param text .
     * @param size .
     */
    public CropLabel(String text, int size) {
        super(text, SwingConstants.CENTER);
        this.setFont(new Font("Press Start 2P", Font.PLAIN, size));
        this.setBorder(new LineBorder(Color.WHITE));
        this.setPreferredSize(new Dimension(25, 25));
    }

    /**
     * Crop Label.
     * @param text .
     * @param size .
     * @param color .
     */
    public CropLabel(String text, int size, Color color) {
        super(text, SwingConstants.CENTER);
        this.setFont(new Font("Press Start 2P", Font.BOLD, size));
        setBackground(color);
        this.setOpaque(true);
        this.setBorder(new LineBorder(new Color(69, 44, 42)));
        this.setPreferredSize(new Dimension(25, 25));
    }
}
