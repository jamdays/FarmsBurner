package main.java.use_case.getbarnbucks;

import main.java.entity.FarmSingleton;

public class GetBarnBucksInteractor implements GetBarnBucksInputBoundary {

    private final GetBarnBucksOutputBoundary outputBoundary;

    public GetBarnBucksInteractor(GetBarnBucksOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }


    @Override
    public int getBarnBucks() {
        outputBoundary.getBarnBucks(FarmSingleton.getInstance().getFarm().getBarnBucks());
        return FarmSingleton.getInstance().getFarm().getBarnBucks();
    }
}
