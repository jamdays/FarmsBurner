package main.java.interface_adapter.toolmenu;

import main.java.use_case.buytool.BuyToolInputBoundary;
import main.java.use_case.upgradetool.UpgradeToolInputBoundary;

public class ToolMenuController {
    private final BuyToolInputBoundary buyToolInputBoundary;
    private final UpgradeToolInputBoundary upgradeToolInputBoundary;

    public ToolMenuController(BuyToolInputBoundary buyToolInputBoundary, UpgradeToolInputBoundary upgradeToolInputBoundary) {
        this.buyToolInputBoundary = buyToolInputBoundary;
        this.upgradeToolInputBoundary = upgradeToolInputBoundary;
    }

    public void upgrade(String tool){
        upgradeToolInputBoundary.upgrade(tool);
    }

    public void buy(String tool){
        buyToolInputBoundary.buy(tool);
    }
}
