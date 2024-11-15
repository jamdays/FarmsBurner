package main.java.use_case.harvest;

public interface HarvestInputBoundary {

        /**
        * executes code for harvestCrop use case
        * @param r, row to be harvested
        * @param c, column to be harvested
        */
        void execute(int r, int c);
}
