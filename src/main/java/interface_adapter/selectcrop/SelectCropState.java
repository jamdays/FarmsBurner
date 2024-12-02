package main.java.interface_adapter.selectcrop;

public class SelectCropState {

    private String currCrop;

    public void selectCropState() {
        this.currCrop = "None";
    }

    public void setCurrCrop(String crop) {
        this.currCrop = crop;
    }

    public String getCurrCrop() {
        return this.currCrop;
    }
}
