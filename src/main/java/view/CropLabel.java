package main.java.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CropLabel extends FarmLabel{

    public CropLabel(String text){
        super(text, SwingConstants.CENTER);
        this.setBorder(new LineBorder(Color.WHITE));
        this.setPreferredSize(new Dimension(25,25));
    }
    public CropLabel(String text, int size) {
        super(text, SwingConstants.CENTER);
        this.setFont(new Font("Press Start 2P", Font.PLAIN, size));
        this.setBorder(new LineBorder(Color.WHITE));
        this.setPreferredSize(new Dimension(25,25));
    }

    public CropLabel(String text, int size, Color color) {
        super(text, SwingConstants.CENTER);
        this.setFont(new Font("Press Start 2P", Font.BOLD, size));
        setBackground(color);
        this.setOpaque(true);
        this.setBorder(new LineBorder(new Color(69, 44, 42)));
        this.setPreferredSize(new Dimension(25,25));
    }
}
