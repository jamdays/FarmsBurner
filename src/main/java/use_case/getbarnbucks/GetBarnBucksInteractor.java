package main.java.use_case.getbarnbucks;

import main.java.entity.FarmSingleton;

/**
 * Get bb interactor.
 */
public class GetBarnBucksInteractor implements GetBarnBucksInputBoundary {

    private final GetBarnBucksOutputBoundary outputBoundary;

    public GetBarnBucksInteractor(GetBarnBucksOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * Get bb.
     * @return bb.
     */
    public int getBarnBucks() {
        int bb = FarmSingleton.getInstance().getFarm().getBarnBucks();
        System.out.println(bb);
        outputBoundary.bucks(bb);
        return bb;
    }
}
