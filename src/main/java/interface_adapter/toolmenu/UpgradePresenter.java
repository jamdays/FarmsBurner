package main.java.interface_adapter.toolmenu;

import main.java.use_case.upgradetool.UpgradeToolInputBoundary;
import main.java.use_case.upgradetool.UpgradeToolOutputBoundary;

public class UpgradePresenter implements UpgradeToolOutputBoundary {
    private final ToolMenuViewModel viewModel;

    public UpgradePresenter(ToolMenuViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void upgrade(String tool) {
        ((ToolMenuState)(viewModel.getState())).upgrade(tool);
        viewModel.firePropertyChanged("upgrade");

    }
}
