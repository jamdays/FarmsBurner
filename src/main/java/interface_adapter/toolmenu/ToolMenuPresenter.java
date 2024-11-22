package main.java.interface_adapter.toolmenu;

import main.java.use_case.buytool.BuyToolInputBoundary;
import main.java.use_case.upgradetool.UpgradeToolInputBoundary;

public class ToolMenuPresenter implements UpgradeToolInputBoundary, BuyToolInputBoundary {
    private final ToolMenuViewModel viewModel;

    public ToolMenuPresenter(ToolMenuViewModel viewModel) {
        this.viewModel = viewModel;
    }


    @Override
    public void upgrade(String tool) {
        ((ToolMenuState)(viewModel.getState())).upgrade(tool);
        viewModel.firePropertyChanged("upgrade");

    }

    @Override
    public void buy(String tool) {
        ((ToolMenuState)(viewModel.getState())).buy(tool);
        viewModel.firePropertyChanged("buy");

    }
}
