package main.java.interface_adapter.toolmenu;

import main.java.use_case.getbarnbucks.GetBarnBucksOutputBoundary;

/**
 * Get BarnBucks presenter.
 */
public class GetBarnBucksPresenter implements GetBarnBucksOutputBoundary {

    private final ToolMenuViewModel viewModel;

    public GetBarnBucksPresenter(ToolMenuViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void bucks(int barnBucks) {
        ((ToolMenuState) (viewModel.getState())).setBarnBucks(barnBucks);
        viewModel.firePropertyChanged("barnBucks");
    }
}
