package main.java.interface_adapter.toolmenu;

import main.java.use_case.getbarnbucks.GetBarnBucksInputBoundary;

/**
 * Get BarnBucks Controller.
 */
public class GetBarnBucksController {

    private final GetBarnBucksInputBoundary inputBoundary;

    public GetBarnBucksController(GetBarnBucksInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Get bb.
     * @return barn bucks.
     */
    public int getbb() {
        return inputBoundary.getBarnBucks();
    }
}
