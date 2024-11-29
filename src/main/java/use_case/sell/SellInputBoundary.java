package main.java.use_case.sell;

import main.java.entity.Crop;

/**
 * Interface for selling a crop that has been harvested and is currently in storage
 */
public interface SellInputBoundary {
    /**
     * Executes the code for selling crops
     * @param quantity, the number of crops to be sold
     */
    void execute(int quantity);
}
