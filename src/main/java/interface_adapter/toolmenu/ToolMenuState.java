package main.java.interface_adapter.toolmenu;

public class ToolMenuState {
    int sprinklerLevel;
    boolean sprinklerPurchased;
    int planterLevel;
    boolean planterPurchased;
    int harvesterLevel;
    boolean harvesterPurchased;
    int tillerLevel;
    boolean tillerPurchased;
    int fertilizerLevel;
    boolean fertilizerPurchased;

    public ToolMenuState() {
        this.sprinklerLevel = 2;
        this.sprinklerPurchased = false;
        this.planterLevel = 2;
        this.planterPurchased = false;
        this.harvesterLevel = 2;
        this.harvesterPurchased = false;
        this.tillerLevel = 2;
        this.tillerPurchased = false;
        this.fertilizerLevel = 2;
        this.fertilizerPurchased = false;
    }

    public void buy(String tool){
        if (tool.equalsIgnoreCase("sprinkler")) {
            if (sprinklerPurchased == false) {
                sprinklerPurchased = true;
            }
        }
        if (tool.equalsIgnoreCase("planter")) {
            if (planterPurchased == false) {
                planterPurchased = true;
            }
        }
        if (tool.equalsIgnoreCase("harvester")) {
            if (harvesterPurchased == false) {
                harvesterPurchased = true;
            }
        }
        if (tool.equalsIgnoreCase("tiller")) {
            if (tillerPurchased == false) {
                tillerPurchased = true;
            }
        }
        if (tool.equalsIgnoreCase("fertilizer")) {
            if (fertilizerPurchased == false) {
                fertilizerPurchased = true;
            }
        }
    }

    public void setToolPurchased(String tool, boolean bought, int level) {
        if (tool.equalsIgnoreCase("sprinkler")) {
            sprinklerPurchased = bought;
            sprinklerLevel = level;
        }
        if (tool.equalsIgnoreCase("planter")) {
            planterPurchased = bought;
            planterLevel = level;
        }
        if (tool.equalsIgnoreCase("harvester")) {
            harvesterPurchased = bought;
            harvesterLevel = level;
        }
        if (tool.equalsIgnoreCase("tiller")) {
            tillerPurchased = bought;
            tillerLevel = level;
        }
        if (tool.equalsIgnoreCase("fertilizer")) {
            fertilizerPurchased = bought;
            fertilizerLevel = level;
        }
    }

    public void upgrade(String tool){
        if (tool.equalsIgnoreCase("sprinkler")) {
            if (sprinklerLevel < 5) {
                sprinklerLevel += 1;
            }
        }
        if (tool.equalsIgnoreCase("planter")) {
            if (planterLevel < 5) {
                planterLevel += 1;
            }
        }
        if (tool.equalsIgnoreCase("harvester")) {
            if (harvesterLevel < 5) {
                harvesterLevel += 1;
            }
        }
        if (tool.equalsIgnoreCase("tiller")) {
            if (tillerLevel < 5) {
                tillerLevel += 1;
            }
        }
        if (tool.equalsIgnoreCase("fertilizer")) {
            if (fertilizerLevel < 5) {
                fertilizerLevel += 1;
            }
        }
    }
}
