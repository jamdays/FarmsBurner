package main.java.interface_adapter.sell;

import main.java.interface_adapter.toolmenu.ToolMenuState;
import main.java.use_case.getstorage.GetStorageOutputBoundary;

import java.util.List;

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
