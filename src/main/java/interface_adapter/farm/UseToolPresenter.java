package main.java.interface_adapter.farm;

import main.java.use_case.usetool.UseToolOutputBoundary;

/**
 * Use tool presenter.
 */
public class UseToolPresenter implements UseToolOutputBoundary {

    private final FarmViewModel viewModel;

    public UseToolPresenter(FarmViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void useTool(String tool, int rStart, int cStart, int amount, long time) {
        if ("sprinkler".equalsIgnoreCase(tool)) {
            for (int i = 0; i < amount; i++) {
                for (int j = 0; j < amount; j++) {
                    ((FarmState) (viewModel.getState())).water(rStart + i, cStart + j);
                }
            }
            viewModel.firePropertyChanged("sprinklerUsed");
        }
        if ("harvester".equalsIgnoreCase(tool)) {
            for (int i = 0; i < amount; i++) {
                for (int j = 0; j < amount; j++) {
                    ((FarmState) (viewModel.getState())).harvest(rStart + i, cStart + j);
                }
            }
            viewModel.firePropertyChanged("harvesterUsed");
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            for (int i = 0; i < amount; i++) {
                for (int j = 0; j < amount; j++) {
                    ((FarmState) (viewModel.getState())).claim(rStart + i, cStart + j);
                }
            }
            viewModel.firePropertyChanged("tillerUsed");
        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            for (int i = 0; i < amount; i++) {
                for (int j = 0; j < amount; j++) {
                    ((FarmState) (viewModel.getState())).fertilize(rStart + i, cStart + j);
                }
            }
            viewModel.firePropertyChanged("fertilizerUsed");
        }
        if ("planter".equalsIgnoreCase(tool)) {
            for (int i = 0; i < amount; i++) {
                for (int j = 0; j < amount; j++) {
                    ((FarmState) (viewModel.getState())).plantCrop(rStart + i, cStart + j, time);
                }
            }
            viewModel.firePropertyChanged("planterUsed");
        }
    }
}
