package main.java.interface_adapter.farm;

import main.java.use_case.setcrop.SetCropOutputBoundary;

/**
 * Set crop presenter.
 */
public class SetCropPresenter implements SetCropOutputBoundary {

    private final FarmViewModel viewModel;

    public SetCropPresenter(FarmViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void setCrop(String crop) {
        ((FarmState) (viewModel.getState())).setCrop(crop);
        viewModel.firePropertyChanged("setCrop");
    }
}
