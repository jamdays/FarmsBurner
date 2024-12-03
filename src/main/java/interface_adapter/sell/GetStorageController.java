package main.java.interface_adapter.sell;

import main.java.use_case.getstorage.GetStorageInputBoundary;

import java.util.List;

public class GetStorageController {

    private GetStorageInputBoundary inputBoundary;

    public GetStorageController(GetStorageInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public List<Integer> getStorage() {
        return inputBoundary.getStorage();
    }
}
