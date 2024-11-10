package main.java.view;

import javax.swing.*;
import java.awt.*;

public class FarmLabel extends JLabel {

    public FarmLabel(String text) {
        super(text);
    }

    public FarmLabel(String text, int size) {
        super(text);
        this.setFont(new Font("Press Start 2P", Font.PLAIN, size));
    }
}
