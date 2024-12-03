package main.java.interface_adapter.farm;

import main.java.use_case.getbarnbucks.GetBarnBucksOutputBoundary;

public class GetBarnBucksPresenter implements GetBarnBucksOutputBoundary {

    private final FarmViewModel viewModel;

    public GetBarnBucksPresenter(FarmViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void getBarnBucks(int barnBucks) {
        ((FarmState) (viewModel.getState())).setBarnBucks(barnBucks);
        viewModel.firePropertyChanged("getbarnbucks");
    }
}
