package main.java.interface_adapter.selectcrop;

/**
 * Select crop state.
 */
public class SelectCropState {

    private String currCrop;

    /**
     * Select crop state.
     */
    public void selectCropState() {
        this.currCrop = "None";
    }

    /**
     * Set current crop.
     * @param crop .
     */
    public void setCurrCrop(String crop) {
        this.currCrop = crop;
    }

    /**
     * Get current crop.
     * @return current crop.
     */
    public String getCurrCrop() {
        return this.currCrop;
    }
}
