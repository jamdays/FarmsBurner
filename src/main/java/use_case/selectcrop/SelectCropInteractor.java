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
            outputBoundary.selectCrop("snowberry");
            FarmSingleton.getInstance().getFarm().setActiveCrop("snowberry");
        }
        // rainy crop
        else if (crop.equalsIgnoreCase("rice")) {
            outputBoundary.selectCrop("rice");
            FarmSingleton.getInstance().getFarm().setActiveCrop("rice");
        }
        // dry crop
        else if (crop.equalsIgnoreCase("wheat")) {
            outputBoundary.selectCrop("wheat");
            FarmSingleton.getInstance().getFarm().setActiveCrop("wheat");
        }
        // regular crop
        else if (crop.equalsIgnoreCase("corn")) {
            outputBoundary.selectCrop("corn");
            FarmSingleton.getInstance().getFarm().setActiveCrop("corn");
        }
    }
}
