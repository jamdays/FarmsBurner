package main.java.interface_adapter.farm;

import main.java.use_case.forecast.ForecastInputBoundary;
import main.java.use_case.forecast.ForecastOutputBoundary;
import main.java.view.FarmView;

import java.util.List;

public class ForecastPresenter implements ForecastOutputBoundary {
    private FarmViewModel viewModel;

    public ForecastPresenter(FarmViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {

    }
}
