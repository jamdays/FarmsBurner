package main.java.interface_adapter.farm;

import main.java.use_case.setcrop.SetCropInputBoundary;

/**
 * Set crop controller.
 */
public class SetCropController {
    private final SetCropInputBoundary inputBoundary;

    public SetCropController(SetCropInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Select crop.
     * @param crop .
     */
    public void selectCrop(String crop) {
        inputBoundary.setCrop(crop);
    }
}
