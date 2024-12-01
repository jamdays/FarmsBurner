package main.java.interface_adapter.selectcrop;
import main.java.use_case.selectcrop.SelectCropOutputBoundary;

public class SelectCropPresenter implements SelectCropOutputBoundary {
    private final SelectCropViewModel viewModel;

    public SelectCropPresenter(SelectCropViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void selectCrop(String crop) {
        ((SelectCropState) (viewModel.getState())).setCurrCrop(crop);
        viewModel.firePropertyChanged("selectCrop");
    }
}
