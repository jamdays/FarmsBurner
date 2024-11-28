package use_case.sell;

import main.java.entity.Crop;

public interface SellOutputBoundary {
    /**
     * updates the state so that the crops are sold
     * @param quantity, the number of crops being sold
     */
    public void sell(int quantity);
}
