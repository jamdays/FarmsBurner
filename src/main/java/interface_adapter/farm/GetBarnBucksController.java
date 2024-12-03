package main.java.interface_adapter.farm;

import main.java.use_case.getbarnbucks.GetBarnBucksInputBoundary;

public class GetBarnBucksController {

    private GetBarnBucksInputBoundary inputBoundary;

    public GetBarnBucksController(GetBarnBucksInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public int getBarnBucks() {
        return inputBoundary.getBarnBucks();
    }
}
