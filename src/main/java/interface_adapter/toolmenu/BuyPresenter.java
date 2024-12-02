package main.java.interface_adapter.toolmenu;

import main.java.use_case.buytool.BuyToolInputBoundary;
import main.java.use_case.buytool.BuyToolOutputBoundary;

public class BuyPresenter implements BuyToolOutputBoundary {
    private final ToolMenuViewModel viewModel;

    public BuyPresenter(ToolMenuViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void buy(String tool) {
        ((ToolMenuState)(viewModel.getState())).buy(tool);
        ((ToolMenuState)(viewModel.getState())).upgrade(tool);
        viewModel.firePropertyChanged("buy");

    }
}
