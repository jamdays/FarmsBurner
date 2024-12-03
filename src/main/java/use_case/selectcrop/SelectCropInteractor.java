package main.java.use_case.selectcrop;

import main.java.entity.FarmSingleton;

/**
 * Select crop interactor.
 */
public class SelectCropInteractor implements SelectCropInputBoundary {

    private final SelectCropOutputBoundary outputBoundary;

    public SelectCropInteractor(SelectCropOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * Select crop.
     * @param crop tool to be selected
     */
    public void selectCrop(String crop) {
        // cold weather crop
        if ("snowberry".equalsIgnoreCase(crop)) {
            outputBoundary.selectCrop("Snowberry");
            FarmSingleton.getInstance().getFarm().setActiveCrop("Snowberry");
        }
        // rainy crop
        else if ("rice".equalsIgnoreCase(crop)) {
            outputBoundary.selectCrop("Rice");
            FarmSingleton.getInstance().getFarm().setActiveCrop("Rice");
        }
        // dry crop
        else if ("wheat".equalsIgnoreCase(crop)) {
            outputBoundary.selectCrop("Wheat");
            FarmSingleton.getInstance().getFarm().setActiveCrop("Wheat");
        }
        // regular crop
        else if ("corn".equalsIgnoreCase(crop)) {
            outputBoundary.selectCrop("Corn");
            FarmSingleton.getInstance().getFarm().setActiveCrop("Corn");
        }
    }
}
