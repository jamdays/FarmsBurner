package main.java.use_case.buytool;

/**
 * Buy tool input boundary.
 */
public interface BuyToolInputBoundary {
    /**
     * Buys tool selected.
     * @param tool tool to be bought.
     */
    void buy(String tool);
}
