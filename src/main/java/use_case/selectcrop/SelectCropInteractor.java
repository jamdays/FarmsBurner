package main.java.use_case.selectcrop;


public class SelectCropInteractor implements SelectCropInputBoundary {

    private final SelectCropOutputBoundary outputBoundary;

    public SelectCropInteractor(SelectCropOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public void selectCrop(String crop) {
        // cold weather crop
        if (crop.equalsIgnoreCase("snowberry")) {
            outputBoundary.selectCrop("Snowberry");
        }
        // rainy crop
        else if (crop.equalsIgnoreCase("rice")) {
            outputBoundary.selectCrop("Rice");
        }
        // dry crop
        else if (crop.equalsIgnoreCase("wheat")) {
            outputBoundary.selectCrop("Wheat");
        }
        // regular crop
        else if (crop.equalsIgnoreCase("corn")) {
            outputBoundary.selectCrop("Corn");
        }
    }
}
