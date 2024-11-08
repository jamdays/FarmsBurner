package main.java.entity;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    // Constructor
    public Farm(Land farmLand) {
        this.farmLand = farmLand;
        this.barnBucks = 0;
        List<FarmTool> farmTools = new ArrayList<>(FarmTool);
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

    public ArrayList<FarmTool> getFarmTools() {
        return this.farmTools;
    }

    public void addFarmTools(ArrayList<FarmTool> farmTools) {
        this.farmTools.addAll(farmTools);
    }
}
