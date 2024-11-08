package main.java.entity;
import java.io.Serializable;
import java.util.List;

/*
int size
List<Crops> crops
boolean isDry
boolean isWet
boolean isSnowy
 */

import java.util.ArrayList;
import java.util.List;

public class Farm implements Serializable {

    //Instance Variables
    private Land farmLand;
    private int barnBucks;
    private int power;
    private List<FarmTool> farmTools;

    // Constructor
    public Farm(Land farmLand) {
        this.farmLand = farmLand;
        this.barnBucks = 0;
        this.power = 0;
        List<FarmTool> farmTools = new ArrayList<FarmTool>();
    }

    public Land getFarmLand() {
        return this.farmLand;
    }

    public int getBarnBucks() {
        return this.barnBucks;
    }

    public void setBarnBucks(int barnBucks) {
        this.barnBucks = barnBucks;
    }

    public List<FarmTool> getFarmTools() {
        return this.farmTools;
    }

    public void addFarmTools(ArrayList<FarmTool> farmTools) {
        this.farmTools.addAll(farmTools);
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
