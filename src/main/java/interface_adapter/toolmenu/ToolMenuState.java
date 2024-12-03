package main.java.interface_adapter.toolmenu;

/**
 * Tool menu state.
 */
public class ToolMenuState {
    private int sprinklerLevel;
    private boolean sprinklerPurchased;
    private int planterLevel;
    private boolean planterPurchased;
    private int harvesterLevel;
    private boolean harvesterPurchased;
    private int tillerLevel;
    private boolean tillerPurchased;
    private int fertilizerLevel;
    private boolean fertilizerPurchased;
    private int bb;

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

    /**
     * Buy.
     * @param tool .
     */
    public void buy(String tool) {
        if ("sprinkler".equalsIgnoreCase(tool)) {
            if (!sprinklerPurchased) {
                sprinklerPurchased = true;
            }
        }
        if ("planter".equalsIgnoreCase(tool)) {
            if (!planterPurchased) {
                planterPurchased = true;
            }
        }
        if ("harvester".equalsIgnoreCase(tool)) {
            if (!harvesterPurchased) {
                harvesterPurchased = true;
            }
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            if (!tillerPurchased) {
                tillerPurchased = true;
            }
        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            if (fertilizerPurchased == false) {
                fertilizerPurchased = true;
            }
        }
    }

    /**
     * Set tool purchased.
     * @param tool .
     * @param bought .
     * @param level .
     */
    public void setToolPurchased(String tool, boolean bought, int level) {
        if ("sprinkler".equalsIgnoreCase(tool)) {
            sprinklerPurchased = bought;
            sprinklerLevel = level;
        }
        if ("planter".equalsIgnoreCase(tool)) {
            planterPurchased = bought;
            planterLevel = level;
        }
        if ("harvester".equalsIgnoreCase(tool)) {
            harvesterPurchased = bought;
            harvesterLevel = level;
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            tillerPurchased = bought;
            tillerLevel = level;
        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            fertilizerPurchased = bought;
            fertilizerLevel = level;
        }
    }

    /**
     * Upgrade.
     * @param tool .
     */
    public void upgrade(String tool) {
        if ("sprinkler".equalsIgnoreCase(tool)) {
            if (sprinklerLevel < 5) {
                sprinklerLevel += 1;
            }
        }
        if ("planter".equalsIgnoreCase(tool)) {
            if (planterLevel < 5) {
                planterLevel += 1;
            }
        }
        if ("harvester".equalsIgnoreCase(tool)) {
            if (harvesterLevel < 5) {
                harvesterLevel += 1;
            }
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            if (tillerLevel < 5) {
                tillerLevel += 1;
            }
        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            if (fertilizerLevel < 5) {
                fertilizerLevel += 1;
            }
        }
    }

    public void setBb(int bb) {
        this.bb = bb;
    }
}
