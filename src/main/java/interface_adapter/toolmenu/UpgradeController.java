package main.java.interface_adapter.toolmenu;

import main.java.use_case.upgradetool.UpgradeToolInputBoundary;

/**
 * Upgrade controller.
 */
public class UpgradeController {
    private final UpgradeToolInputBoundary upgradeToolInputBoundary;

    public UpgradeController(UpgradeToolInputBoundary upgradeToolInputBoundary) {
        this.upgradeToolInputBoundary = upgradeToolInputBoundary;
    }

    /**
     * Upgrade.
     * @param tool .
     */
    public void upgrade(String tool) {
        upgradeToolInputBoundary.upgrade(tool);
    }
}
