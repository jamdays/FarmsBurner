package main.java.use_case.plant;

/**
 * Plant input boundary.
 */
public interface PlantInputBoundary {

    /**
     * Executes code for plant use case.
     * @param row row to be placed at
     * @param col column to be placed at
     */
    void execute(int row, int col);
}
