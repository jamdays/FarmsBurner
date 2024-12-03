package main.java.interface_adapter.sell;

import main.java.use_case.sell.SellInputBoundary;

/**
 * Sell controller.
 */
public class SellController {
    private final SellInputBoundary sellInputBoundary;

    public SellController(SellInputBoundary sellInputBoundary) {
        this.sellInputBoundary = sellInputBoundary;
    }

    /**
     * Executes the Sell Use Case.
     * @param quantity .
     */
    public void sell(int quantity) {
        this.sellInputBoundary.execute(quantity);
    }

}
