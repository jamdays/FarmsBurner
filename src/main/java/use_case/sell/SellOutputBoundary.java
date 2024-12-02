package main.java.use_case.sell;

public interface SellOutputBoundary {
    /**
     * updates the state so that the crops are sold
     * @param quantity, the number of crops being sold
     */
    public void sell(int quantity);
}
