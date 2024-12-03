package main.java.use_case.claim;

/**
 * Claim input boundary.
 */
public interface ClaimInputBoundary {

    /**
     * Executes code for plant use case.
     * @param row row to be claimed
     * @param col column to be claimed
     */
    void execute(int row, int col);
}
