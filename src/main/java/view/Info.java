package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Info view.
 */
public class Info extends JPanel {
    public Info() {
        String imgurlstr = "";
        URL imgurl = Info.class.getResource(imgurlstr);
        JPanel landInfo = new JPanel();
        landInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        FarmLabel wetLandLabel = new CropLabel("", 20, Color.BLACK);
        ImageIcon dirtImage = new ImageIcon("src/main/resources/farmtile3.png");
        imgurlstr = "/main/resources/farmtile3.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            dirtImage = new ImageIcon(imgurl);
        }
        wetLandLabel.setIcon(new ImageIcon(dirtImage.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        landInfo.add(wetLandLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        landInfo.add(new FarmLabel("Wet Land", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        FarmLabel wetFertilizedLandLabel = new CropLabel("", 20, Color.BLACK);
        ImageIcon wetAndFertilizedImg = new ImageIcon("src/main/resources/farmtile5.png");
        imgurlstr = "/main/resources/farmtile5.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            wetAndFertilizedImg = new ImageIcon(imgurl);
        }
        wetFertilizedLandLabel.setIcon(new ImageIcon(wetAndFertilizedImg.getImage().getScaledInstance(25, 25,
                Image.SCALE_SMOOTH)));
        landInfo.add(wetFertilizedLandLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        landInfo.add(new FarmLabel("Wet and Fertilized Land", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        FarmLabel dryLandLabel = new CropLabel("", 20, Color.BLACK);
        ImageIcon dryLandImg = new ImageIcon("src/main/resources/farmtile2.png");
        imgurlstr = "/main/resources/farmtile2.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            dryLandImg = new ImageIcon(imgurl);
        }
        dryLandLabel.setIcon(new ImageIcon(dryLandImg.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        landInfo.add(dryLandLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        landInfo.add(new FarmLabel("Dry Land", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        FarmLabel dryLandFertilizedLabel = new CropLabel("", 20, Color.BLACK);
        ImageIcon dryLandFertilizedImg = new ImageIcon("src/main/resources/farmtile4.png");
        imgurlstr = "/main/resources/farmtile4.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            dryLandFertilizedImg = new ImageIcon(imgurl);
        }
        dryLandFertilizedLabel.setIcon(new ImageIcon(dryLandFertilizedImg.getImage().getScaledInstance(25,
                25, Image.SCALE_SMOOTH)));
        landInfo.add(dryLandFertilizedLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        landInfo.add(new FarmLabel("Dry and Fertilized Land", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        FarmLabel unclaimedLabel = new CropLabel("", 20, Color.BLACK);
        ImageIcon grass = new ImageIcon("src/main/resources/farmtile1.png");
        imgurlstr = "/main/resources/farmtile1.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            grass = new ImageIcon(imgurl);
        }
        unclaimedLabel.setIcon(new ImageIcon(grass.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        landInfo.add(unclaimedLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        landInfo.add(new FarmLabel("Unclaimed Land", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        FarmLabel riceLabel = new CropLabel("", 20, new Color(169, 152, 126));
        ImageIcon riceImg = new ImageIcon("src/main/resources/RiceUnready.png");
        imgurlstr = "/main/resources/RiceUnready.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            riceImg = new ImageIcon(imgurl);
        }
        riceLabel.setIcon(new ImageIcon(riceImg.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        landInfo.add(riceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        landInfo.add(new FarmLabel("Not ready to harvest rice", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        FarmLabel riceReadyLabel = new CropLabel("", 20, new Color(169, 152, 126));
        ImageIcon riceReadyImg = new ImageIcon("src/main/resources/RiceReady.png");
        imgurlstr = "/main/resources/RiceReady.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            riceReadyImg = new ImageIcon(imgurl);
        }
        riceReadyLabel.setIcon(new ImageIcon(riceReadyImg.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        landInfo.add(riceReadyLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        landInfo.add(new FarmLabel("Ready to harvest rice", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        FarmLabel cornLabel = new CropLabel("", 20, new Color(169, 152, 126));
        ImageIcon cornImg = new ImageIcon("src/main/resources/CornUnready.png");
        imgurlstr = "/main/resources/CornUnready.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            cornImg = new ImageIcon(imgurl);
        }
        cornLabel.setIcon(new ImageIcon(cornImg.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        landInfo.add(cornLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        landInfo.add(new FarmLabel("Not ready to harvest corn", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        FarmLabel cornReadyLabel = new CropLabel("", 20, new Color(169, 152, 126));
        ImageIcon cornReadyImg = new ImageIcon("src/main/resources/CornReady.png");
        imgurlstr = "/main/resources/CornReady.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            cornReadyImg = new ImageIcon(imgurl);
        }
        cornReadyLabel.setIcon(new ImageIcon(cornReadyImg.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        landInfo.add(cornReadyLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        landInfo.add(new FarmLabel("Ready to harvest corn", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        FarmLabel wheatLabel = new CropLabel("", 20, new Color(169, 152, 126));
        ImageIcon wheatImg = new ImageIcon("src/main/resources/WheatUnready.png");
        imgurlstr = "/main/resources/WheatUnready.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            wheatImg = new ImageIcon(imgurl);
        }
        wheatLabel.setIcon(new ImageIcon(wheatImg.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        landInfo.add(wheatLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        landInfo.add(new FarmLabel("Not ready to harvest wheat", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        FarmLabel wheatReadyLabel = new CropLabel("", 20, new Color(169, 152, 126));
        ImageIcon wheatReadyImg = new ImageIcon("src/main/resources/WheatReady.png");
        imgurlstr = "/main/resources/WheatReady.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            wheatReadyImg = new ImageIcon(imgurl);
        }
        wheatReadyLabel.setIcon(new ImageIcon(wheatReadyImg.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        landInfo.add(wheatReadyLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        landInfo.add(new FarmLabel("Ready to harvest wheat", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        FarmLabel snowberryLabel = new CropLabel("", 20, new Color(169, 152, 126));
        ImageIcon snowberryImg = new ImageIcon("src/main/resources/SnowberryUnready.png");
        imgurlstr = "/main/resources/SnowyberryUnready.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            snowberryImg = new ImageIcon(imgurl);
        }
        snowberryLabel.setIcon(new ImageIcon(snowberryImg.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        landInfo.add(snowberryLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        landInfo.add(new FarmLabel("Not ready to harvest snowberry", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        FarmLabel snowberryReadyLabel = new CropLabel("", 20, new Color(169, 152, 126));
        ImageIcon snowberryReadyImg = new ImageIcon("src/main/resources/SnowberryReady.png");
        imgurlstr = "/main/resources/SnowberryReady.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            snowberryReadyImg = new ImageIcon(imgurl);
        }
        snowberryReadyLabel.setIcon(new ImageIcon(snowberryReadyImg.getImage().getScaledInstance(25, 25,
                Image.SCALE_SMOOTH)));
        landInfo.add(snowberryReadyLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 12;
        landInfo.add(new FarmLabel("Ready to harvest snowberry", 15), gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        FarmLabel deadPlantLabel = new CropLabel("", 20, new Color(169, 152, 126));
        ImageIcon deadPlantImg = new ImageIcon("src/main/resources/deadPlant.png");
        imgurlstr = "/main/resources/deadPlant.png";
        imgurl = Info.class.getResource(imgurlstr);
        if (imgurl != null) {
            deadPlantImg = new ImageIcon(imgurl);
        }
        deadPlantLabel.setIcon(new ImageIcon(deadPlantImg.getImage().getScaledInstance(25, 25,
                Image.SCALE_SMOOTH)));
        landInfo.add(deadPlantLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 13;
        landInfo.add(new FarmLabel("Dead Plant", 15), gbc);

        landInfo.setBackground(new Color(169, 152, 126));

        JPanel controlInfo = new JPanel();
        controlInfo.setLayout(new BoxLayout(controlInfo, BoxLayout.Y_AXIS));
        controlInfo.add(new FarmLabel("Shift + Click to claim land"));
        controlInfo.add(new FarmLabel("Ctrl + Click to Plant"));
        controlInfo.add(new FarmLabel("Alt + Click to Water"));
        controlInfo.add(new FarmLabel("Ctrl + Alt to Fertilize"));
        controlInfo.setBackground(new Color(169, 152, 126));

        this.setBackground(new Color(169, 152, 126));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(landInfo, BorderLayout.WEST);
        this.add(controlInfo);
    }
}
