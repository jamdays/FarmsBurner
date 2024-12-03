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
    private int barnBucks;
    private final int[] prices = {0, 300, 900, 2700, 8100};

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
                barnBucks -= prices[sprinklerLevel - 1];
                if (barnBucks < 0) {
                    barnBucks += prices[sprinklerLevel - 1];
                    return;
                }
                sprinklerPurchased = true;
            }
        }
        if ("planter".equalsIgnoreCase(tool)) {
            if (!planterPurchased) {
                barnBucks -= prices[planterLevel - 1];
                if (barnBucks < 0) {
                    barnBucks += prices[planterLevel - 1];
                    return;
                }
                planterPurchased = true;
            }
        }
        if ("harvester".equalsIgnoreCase(tool)) {
            if (!harvesterPurchased) {
                barnBucks -= prices[harvesterLevel - 1];
                if (barnBucks < 0) {
                    barnBucks += prices[harvesterLevel - 1];
                    return;
                }
                harvesterPurchased = true;
            }
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            if (!tillerPurchased) {
                barnBucks -= prices[tillerLevel - 1];
                if (barnBucks < 0) {
                    barnBucks += prices[tillerLevel - 1];
                    return;
                }
                tillerPurchased = true;
            }
        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            if (!fertilizerPurchased) {
                barnBucks -= prices[fertilizerLevel - 1];
                if (barnBucks < 0) {
                    barnBucks += prices[fertilizerLevel - 1];
                    return;
                }
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
                barnBucks -= prices[sprinklerLevel];
                if (barnBucks < 0) {
                    barnBucks += prices[sprinklerLevel];
                    return;
                }
                sprinklerLevel += 1;
            }
        }
        if ("planter".equalsIgnoreCase(tool)) {
            if (planterLevel < 5) {
                barnBucks -= prices[planterLevel];
                if (barnBucks < 0) {
                    barnBucks += prices[planterLevel];
                    return;
                }
                planterLevel += 1;
            }
        }
        if ("harvester".equalsIgnoreCase(tool)) {
            if (harvesterLevel < 5) {
                barnBucks -= prices[harvesterLevel];
                if (barnBucks < 0) {
                    barnBucks += prices[harvesterLevel];
                    return;
                }
                harvesterLevel += 1;
            }
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            if (tillerLevel < 5) {
                barnBucks -= prices[tillerLevel];
                if (barnBucks < 0) {
                    barnBucks += prices[tillerLevel];
                    return;
                }
                tillerLevel += 1;
            }
        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            if (fertilizerLevel < 5) {
                barnBucks -= prices[fertilizerLevel];
                if (barnBucks < 0) {
                    barnBucks += prices[fertilizerLevel];
                    return;
                }
                fertilizerLevel += 1;
            }
        }
    }

    /**
     * Set BarnBucks.
     * @param barnBucks .
     */
    public void setBarnBucks(int barnBucks) {
        this.barnBucks = barnBucks;
    }

    /**
     * Get barnBucks.
     * @return barnbucks.
     */
    public int getBarnBucks() {
        return barnBucks;
    }

    /**
     * Get levels.
     * @return levels.
     */
    public int[] getLevels() {
        return new int[]{sprinklerLevel, planterLevel, harvesterLevel ,tillerLevel, fertilizerLevel};
    }

    /**
     * Get purchased.
     * @return purchased.
     */
    public boolean[] getPurchased() {
        return new boolean[]{sprinklerPurchased, planterPurchased, harvesterPurchased, tillerPurchased, fertilizerPurchased};
    }
}
