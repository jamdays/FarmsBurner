package main.java.use_case.claim;

/**
 * Claim output boundary.
 */
public interface ClaimOutputBoundary {
    /**
     * Adds the crop.
     * @param row row to be placed at
     * @param col column to be placed at
     */
    void claim(int row, int col);

}
