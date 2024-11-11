package main.java.use_case.claim;

public interface ClaimOutputBoundary {
    /**
     * adds the crop
     * @param r, row to be placed at
     * @param c, column to be placed at
     */
    void claim(int r, int c);
}
