package main.java.use_case.getstorage;

import main.java.entity.AbstractCrop;
import main.java.entity.FarmSingleton;

import java.util.ArrayList;
import java.util.List;

public class GetStorageInteractor implements GetStorageInputBoundary {

    private GetStorageOutputBoundary outputBoundary;

    public GetStorageInteractor(GetStorageOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

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
