package main.java.interface_adapter.toolmenu;

import main.java.use_case.buytool.BuyToolInputBoundary;

/**
 * Buy controller.
 */
public class BuyController {
    private final BuyToolInputBoundary buyToolInputBoundary;

    public BuyController(BuyToolInputBoundary buyToolInputBoundary) {
        this.buyToolInputBoundary = buyToolInputBoundary;
    }

    /**
     * Buy.
     * @param tool .
     */
    public void buy(String tool) {
        buyToolInputBoundary.buy(tool);
    }

}
