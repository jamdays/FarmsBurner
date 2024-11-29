package main.java.interface_adapter.sell;

import main.java.use_case.sell.SellInputBoundary;
import main.java.use_case.sell.SellOutputBoundary;

public class SellController {
    private final SellInputBoundary sellInputBoundary;

    public SellController(SellInputBoundary sellInputBoundary) {
        this.sellInputBoundary = sellInputBoundary;
    }

    public void sell(int quantity) {
        this.sellInputBoundary.execute(quantity);
    }
}
