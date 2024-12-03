package main.java.interface_adapter.farm;

import main.java.use_case.forecast.ForecastOutputBoundary;

/**
 * Forecast presenter.
 */
public class ForecastPresenter implements ForecastOutputBoundary {
    private FarmViewModel viewModel;

    public ForecastPresenter(FarmViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {

    }
}
