package main.java.interface_adapter.toolmenu;

import main.java.use_case.buytool.BuyToolInputBoundary;

public class BuyPresenter implements BuyToolInputBoundary {
    private final ToolMenuViewModel viewModel;

    public BuyPresenter(ToolMenuViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void buy(String tool) {
        ((ToolMenuState)(viewModel.getState())).buy(tool);
        viewModel.firePropertyChanged("buy");

    }
}
