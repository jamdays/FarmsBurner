package interface_adapter.selecttool;

import use_case.selecttool.SelectToolOutputBoundary;

public class SelectToolPresenter implements SelectToolOutputBoundary {
    private final SelectToolViewModel viewModel;

    public SelectToolPresenter(SelectToolViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void selectTool(String tool) {
        ((SelectToolState) (viewModel.getState())).selectTool(tool);
        viewModel.firePropertyChanged("selectTool");
    }
}