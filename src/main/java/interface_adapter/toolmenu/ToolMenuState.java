package main.java.interface_adapter.toolmenu;

public class ToolMenuState {
    int sprinklerLevel;
    boolean sprinklerPurchased;
    int harvesterLevel;
    boolean harvesterPurchased;
    int tillerLevel;
    boolean tillerPurchased;
    int fertilizerLevel;
    boolean fertilizerPurchased;

    public ToolMenuState() {
        this.sprinklerLevel = 1;
        this.sprinklerPurchased = false;
        this.harvesterLevel = 1;
        this.harvesterPurchased = false;
        this.tillerLevel = 1;
        this.tillerPurchased = false;
        this.fertilizerLevel = 1;
        this.fertilizerPurchased = false;
    }

    public void buy(String tool){
        if (tool.equalsIgnoreCase("sprinkler")) {
            if (sprinklerPurchased == false) {
                sprinklerPurchased = true;
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

    public void upgrade(String tool){
        if (tool.equalsIgnoreCase("sprinkler")) {
            if (sprinklerLevel < 5) {
                sprinklerLevel += 1;
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
