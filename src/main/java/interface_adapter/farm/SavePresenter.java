package main.java.interface_adapter.farm;

import main.java.use_case.save.SaveOutputBoundary;

public class SavePresenter implements SaveOutputBoundary {
    private final FarmViewModel farmViewModel;

    public SavePresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void saved() {
        farmViewModel.firePropertyChanged("save");
    }
}
