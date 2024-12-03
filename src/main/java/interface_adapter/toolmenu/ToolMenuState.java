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
    private final int[] prices = {300, 900, 2700, 8100};

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
                bb -= prices[sprinklerLevel - 1];
                sprinklerPurchased = true;
            }
        }
        if ("planter".equalsIgnoreCase(tool)) {
            if (!planterPurchased) {
                bb -= prices[planterLevel - 1];
                planterPurchased = true;
            }
        }
        if ("harvester".equalsIgnoreCase(tool)) {
            if (!harvesterPurchased) {
                bb -= prices[harvesterLevel - 1];
                harvesterPurchased = true;
            }
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            if (!tillerPurchased) {
                bb -= prices[tillerLevel - 1];
                tillerPurchased = true;
            }
        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            if (!fertilizerPurchased) {
                bb -= prices[fertilizerLevel - 1];
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
                bb -= prices[sprinklerLevel - 1];
                sprinklerLevel += 1;
            }
        }
        if ("planter".equalsIgnoreCase(tool)) {
            if (planterLevel < 5) {
                bb -= prices[planterLevel - 1];
                planterLevel += 1;
            }
        }
        if ("harvester".equalsIgnoreCase(tool)) {
            if (harvesterLevel < 5) {
                bb -= prices[harvesterLevel - 1];
                harvesterLevel += 1;
            }
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            if (tillerLevel < 5) {
                bb -= prices[tillerLevel - 1];
                tillerLevel += 1;
            }
        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            if (fertilizerLevel < 5) {
                bb -= prices[fertilizerLevel - 1];
                fertilizerLevel += 1;
            }
        }
    }

    public void setBb(int bb) {
        this.bb = bb;
    }

    public int getBb(){
        return bb;
    }
}
