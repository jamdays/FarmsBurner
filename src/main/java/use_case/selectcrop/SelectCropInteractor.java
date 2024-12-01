package main.java.use_case.selectcrop;


public class SelectCropInteractor implements SelectCropInputBoundary {

    private final SelectCropOutputBoundary outputBoundary;

    public SelectCropInteractor(SelectCropOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public void selectCrop(String crop) {
        // cold weather crop
        if (crop.equalsIgnoreCase("snowberry")) {
            outputBoundary.selectCrop("snowberry");
        }
        // rainy crop
        else if (crop.equalsIgnoreCase("rice")) {
            outputBoundary.selectCrop("rice");
        }
        // dry crop
        else if (crop.equalsIgnoreCase("wheat")) {
            outputBoundary.selectCrop("wheat");
        }
        // regular crop
        else if (crop.equalsIgnoreCase("corn")) {
            outputBoundary.selectCrop("corn");
        }
    }
}
