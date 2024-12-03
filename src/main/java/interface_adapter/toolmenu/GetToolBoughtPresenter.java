package main.java.interface_adapter.toolmenu;

import main.java.use_case.gettoolbought.GetToolBoughtOutputBoundary;

/**
 * Get tool bought presenter.
 */
public class GetToolBoughtPresenter implements GetToolBoughtOutputBoundary {

    private final ToolMenuViewModel viewModel;

    public GetToolBoughtPresenter(ToolMenuViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void toolBought(String tool, boolean bought, int level) {
        ((ToolMenuState) (viewModel.getState())).setToolPurchased(tool, bought, level);
        viewModel.firePropertyChanged("gettoolbought");
    }
}
