package main.java.use_case.selectcrop;


import main.java.entity.FarmSingleton;

public class SelectCropInteractor implements SelectCropInputBoundary {

    private final SelectCropOutputBoundary outputBoundary;

    public SelectCropInteractor(SelectCropOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public void selectCrop(String crop) {
        // cold weather crop
        if (crop.equalsIgnoreCase("snowberry")) {
            outputBoundary.selectCrop("Snowberry");
            FarmSingleton.getInstance().getFarm().setActiveCrop("Snowberry");
        }
        // rainy crop
        else if (crop.equalsIgnoreCase("rice")) {
            outputBoundary.selectCrop("Rice");
            FarmSingleton.getInstance().getFarm().setActiveCrop("Rice");
        }
        // dry crop
        else if (crop.equalsIgnoreCase("wheat")) {
            outputBoundary.selectCrop("Wheat");
            FarmSingleton.getInstance().getFarm().setActiveCrop("Wheat");
        }
        // regular crop
        else if (crop.equalsIgnoreCase("corn")) {
            outputBoundary.selectCrop("Corn");
            FarmSingleton.getInstance().getFarm().setActiveCrop("Corn");
        }
    }
}
