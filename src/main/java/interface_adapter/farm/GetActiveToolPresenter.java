package main.java.interface_adapter.farm;

import main.java.use_case.getactivetool.GetActiveToolOutputBoundary;

/**
 * Get active tool presenter.
 */
public class GetActiveToolPresenter implements GetActiveToolOutputBoundary {

    private final FarmViewModel viewModel;

    public GetActiveToolPresenter(FarmViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void activeTool(String activeTool) {
        ((FarmState) (viewModel.getState())).setActiveTool(activeTool);
        viewModel.firePropertyChanged("activetool");
    }
}
