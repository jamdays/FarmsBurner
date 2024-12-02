package main.java.use_case.setcrop;

import main.java.use_case.selectcrop.SelectCropOutputBoundary;

public class SetCropInteractor implements SetCropInputBoundary{
    private final SetCropOutputBoundary outputBoundary;

    public SetCropInteractor(SetCropOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public void setCrop(String crop) {
        // cold weather crop
        if (crop.equalsIgnoreCase("snowberry")) {
            outputBoundary.setCrop("snowberry");
        }
        // rainy crop
        else if (crop.equalsIgnoreCase("rice")) {
            outputBoundary.setCrop("rice");
        }
        // dry crop
        else if (crop.equalsIgnoreCase("wheat")) {
            outputBoundary.setCrop("wheat");
        }
        // regular crop
        else if (crop.equalsIgnoreCase("corn")) {
            outputBoundary.setCrop("corn");
        }
    }
}
