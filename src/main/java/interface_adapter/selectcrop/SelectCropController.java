package main.java.interface_adapter.selectcrop;

import main.java.use_case.selectcrop.SelectCropInputBoundary;

/**
 * Select crop controller.
 */
public class SelectCropController {
    private final SelectCropInputBoundary inputBoundary;

    public SelectCropController(SelectCropInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Select crop.
     * @param crop .
     */
    public void selectCrop(String crop) {
        inputBoundary.selectCrop(crop);
    }
}
