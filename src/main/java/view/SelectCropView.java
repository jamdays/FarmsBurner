package view;

import javax.swing.*;
import java.awt.*;

public class SelectCropView extends JPanel {

    // instance variables

    // constructor
    public SelectCropView() {
        // initialize instance variables

        // show the view
        JLabel title = new JLabel("Select a Crop");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.setBackground(new java.awt.Color(169, 152, 126));
        topPanel.setPreferredSize(new Dimension(350,50));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        this.setLayout(new BorderLayout());
        this.setBackground(new java.awt.Color(169, 152, 126));
        this.add(topPanel, BorderLayout.NORTH);
    }

    // @Override
    public void PropertyChange() {

    }
}
