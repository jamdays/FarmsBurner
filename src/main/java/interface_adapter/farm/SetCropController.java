package main.java.interface_adapter.farm;

import main.java.use_case.setcrop.SetCropInputBoundary;

public class SetCropController {
    private final SetCropInputBoundary inputBoundary;

    public SetCropController(SetCropInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void selectCrop(String crop) {
        inputBoundary.setCrop(crop);
    }
}
