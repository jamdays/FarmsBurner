package main.java.interface_adapter.sell;

/**
 * Sell state.
 */
public class SellState {
    private int money;

    public SellState(int money) {
        this.money = money;
    }

    /**
     * Sell state.
     */
    public SellState() {
        this.money = 0;
    }

    /**
     * Sell.
     * @param quantity .
     */
    public void sell(int quantity) {
        this.money += quantity * 5;
    }
}
