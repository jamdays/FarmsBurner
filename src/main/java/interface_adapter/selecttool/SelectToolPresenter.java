package main.java.interface_adapter.selecttool;

import main.java.use_case.selecttool.SelectToolOutputBoundary;

public class SelectToolPresenter implements SelectToolOutputBoundary {
    private final SelectToolViewModel viewModel;

    public SelectToolPresenter(SelectToolViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void selectTool(String tool) {
        ((SelectToolState) (viewModel.getState())).setCurrTool(tool);
        viewModel.firePropertyChanged("selectTool");
    }
}
