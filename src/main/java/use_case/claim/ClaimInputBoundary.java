package main.java.use_case.claim;

public interface ClaimInputBoundary {

    /**
     * executes code for plant use case
     * @param r, row to be claimed
     * @param c, column to be claimed
     */
    void execute(int r, int c);
}
