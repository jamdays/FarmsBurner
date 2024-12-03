package main.java.interface_adapter.toolmenu;

import main.java.use_case.buytool.BuyToolOutputBoundary;

/**
 * Buy presenter.
 */
public class BuyPresenter implements BuyToolOutputBoundary {
    private final ToolMenuViewModel viewModel;

    public BuyPresenter(ToolMenuViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void buy(String tool) {
        ((ToolMenuState) (viewModel.getState())).buy(tool);
        viewModel.firePropertyChanged("buy");

    }
}
