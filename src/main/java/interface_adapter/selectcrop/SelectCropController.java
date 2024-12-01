package main.java.interface_adapter.selectcrop;

import main.java.use_case.selectcrop.*;

public class SelectCropController {
    private final SelectCropInputBoundary inputBoundary;

    public SelectCropController(SelectCropInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void selectCrop(String crop) {
        inputBoundary.selectCrop(crop);
    }
}