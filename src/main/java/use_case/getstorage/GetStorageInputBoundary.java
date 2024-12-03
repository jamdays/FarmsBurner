package main.java.use_case.getstorage;

import main.java.entity.AbstractCrop;

import java.util.List;

public interface GetStorageInputBoundary {

    /**
     * executes code for getStorage use case
     */
    public List<Integer> getStorage();
}
