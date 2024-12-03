package main.java.interface_adapter.sell;

import java.util.List;

import main.java.use_case.getstorage.GetStorageOutputBoundary;

/**
 * Get storage presenter.
 */
public class GetStoragePresenter implements GetStorageOutputBoundary {

    private final SellViewModel viewModel;

    public GetStoragePresenter(SellViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void getStorage(List<Integer> storage) {
        ((SellState) (viewModel.getState())).getStorage(storage);
        viewModel.firePropertyChanged("getstorage");
    }
}
