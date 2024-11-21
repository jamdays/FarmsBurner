package main.java.app;

import javax.swing.*;

public class WindowBuilder {
    public int HEIGHT;
    public int WIDTH;
    public JPanel panel;

    public WindowBuilder addInfoView(int width, int height, JPanel panel) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.panel = panel;
        return this;
    }

    public JFrame build() {
        final JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.add(this.panel);
        return frame;
    }
}
