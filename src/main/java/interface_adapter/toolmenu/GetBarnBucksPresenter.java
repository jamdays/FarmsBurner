package main.java.interface_adapter.toolmenu;

import main.java.interface_adapter.farm.FarmState;
import main.java.use_case.getbarnbucks.GetBarnBucksOutputBoundary;

public class GetBarnBucksPresenter implements GetBarnBucksOutputBoundary {

    private final ToolMenuViewModel viewModel;

    public GetBarnBucksPresenter(ToolMenuViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void bucks(int bb) {
        ((ToolMenuState)(viewModel.getState())).setBb(bb);
        viewModel.firePropertyChanged("barnBucks");
    }
}
