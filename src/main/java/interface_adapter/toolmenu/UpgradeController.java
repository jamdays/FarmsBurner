package main.java.interface_adapter.toolmenu;

import main.java.use_case.upgradetool.UpgradeToolInputBoundary;

public class UpgradeController {
    private final UpgradeToolInputBoundary upgradeToolInputBoundary;

    public UpgradeController(UpgradeToolInputBoundary upgradeToolInputBoundary) {
        this.upgradeToolInputBoundary = upgradeToolInputBoundary;
    }

    public void upgrade(String tool){
        upgradeToolInputBoundary.upgrade(tool);
    }
}
