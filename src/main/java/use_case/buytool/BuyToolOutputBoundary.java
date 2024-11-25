package main.java.use_case.buytool;

public interface BuyToolOutputBoundary {
    /**
     * Updates state so tool is bought
     * @param tool, tool to be bought
     */
    public void buy(String tool);
}
