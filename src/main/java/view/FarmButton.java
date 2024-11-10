package main.java.view;

import javax.swing.*;
import java.awt.*;

public class FarmButton extends JButton {

    public FarmButton(String text) {
        super(text);
    }

    public FarmButton(String text, int size) {
        super(text);
        this.setFont(new Font("Press Start 2P", Font.PLAIN, size));
    }
}
