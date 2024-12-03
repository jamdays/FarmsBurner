package main.java.interface_adapter.sell;

import java.util.List;

import main.java.use_case.getstorage.GetStorageInputBoundary;

/**
 * Get storage controller.
 */
public class GetStorageController {

    private GetStorageInputBoundary inputBoundary;

    public GetStorageController(GetStorageInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Get storage.
     * @return storage.
     */
    public List<Integer> getStorage() {
        return inputBoundary.getStorage();
    }
}
