package main.java.use_case.harvest;

public interface HarvestOutputBoundary {
    /**
     * harvests the crop
     * @param r, row to be harvested
     * @param c, column to be harvested
     */
    void harvestCrop(int r, int c);
}
