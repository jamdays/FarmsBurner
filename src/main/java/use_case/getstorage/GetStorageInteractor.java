package main.java.use_case.getstorage;

import java.util.ArrayList;
import java.util.List;

import main.java.entity.AbstractCrop;
import main.java.entity.FarmSingleton;

/**
 * Get storage interactor.
 */
public class GetStorageInteractor implements GetStorageInputBoundary {

    private GetStorageOutputBoundary outputBoundary;

    public GetStorageInteractor(GetStorageOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * Get storage.
     * @return storage.
     */
    public List<Integer> getStorage() {
        List<AbstractCrop> crops = FarmSingleton.getInstance().getFarm().getStorage().getCrops();
        List<Integer> storage = new ArrayList<>();
        for (AbstractCrop crop : crops) {
            storage.add(Integer.valueOf(crop.getPrice()));
        }
        outputBoundary.getStorage(storage);
        return storage;
    }
}
