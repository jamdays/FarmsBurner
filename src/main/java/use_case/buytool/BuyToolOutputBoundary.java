package main.java.use_case.buytool;

/**
 * Buy tool output boundary.
 */
public interface BuyToolOutputBoundary {
    /**
     * Updates state so tool is bought.
     * @param tool tool to be bought.
     */
    void buy(String tool);
}
