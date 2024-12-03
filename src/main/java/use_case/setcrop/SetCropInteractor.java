package main.java.use_case.setcrop;

/**
 * Set crop interactor.
 */
public class SetCropInteractor implements SetCropInputBoundary {
    private final SetCropOutputBoundary outputBoundary;

    public SetCropInteractor(SetCropOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * Set crop.
     * @param crop crop to be selected
     */
    public void setCrop(String crop) {
        // cold weather crop
        if ("snowberry".equalsIgnoreCase(crop)) {
            outputBoundary.setCrop("snowberry");
        }
        // rainy crop
        else if ("rice".equalsIgnoreCase(crop)) {
            outputBoundary.setCrop("rice");
        }
        // dry crop
        else if ("wheat".equalsIgnoreCase(crop)) {
            outputBoundary.setCrop("wheat");
        }
        // regular crop
        else if ("corn".equalsIgnoreCase(crop)) {
            outputBoundary.setCrop("corn");
        }
    }
}
