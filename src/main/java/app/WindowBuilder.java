package main.java.app;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Window Builder.
 */
public class WindowBuilder {
    private int height;
    private int width;
    private JPanel panel;

    /**
     * Class Window Builder.
     * @param width .
     * @param height .
     * @param panel .
     * @return this.
     */
    public WindowBuilder addView(int width, int height, JPanel panel) {
        this.width = width;
        this.height = height;
        this.panel = panel;
        return this;
    }

    /**
     * Build method.
     * @return frame.
     */
    public JFrame build() {
        final JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.add(this.panel);
        frame.setAlwaysOnTop(true);
        return frame;
    }
}
