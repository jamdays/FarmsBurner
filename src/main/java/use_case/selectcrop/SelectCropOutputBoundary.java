package main.java.use_case.selectcrop;

/**
 * Select crop output boundary.
 */
public interface SelectCropOutputBoundary {

    /**
     * Selects the crop.
     * @param crop the crop to be selected
     */
    void selectCrop(String crop);
}
