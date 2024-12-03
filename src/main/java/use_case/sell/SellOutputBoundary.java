package main.java.use_case.sell;

/**
 * Sell output boundary.
 */
public interface SellOutputBoundary {
    /**
     * Updates the state so that the crops are sold.
     * @param quantity the number of crops being sold
     */
    void sell(int quantity);
}
