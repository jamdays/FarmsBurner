package main.java.interface_adapter.sell;

import java.util.List;

/**
 * Sell state.
 */
public class SellState {
    private int money;
    private List<Integer> storage;

    public SellState(int money) {
        this.money = money;
    }

    /**
     * Sell state.
     */
    public SellState() {
        this.money = 0;
    }

    public void getStorage(List<Integer> storage) {
        this.storage = storage;
    }
  
    /**
     * Sell.
     * @param quantity .
     */
    public void sell(int quantity) {
        this.money += quantity * 5;
    }
}
