package main.java.interface_adapter.sell;

import main.java.use_case.sell.SellOutputBoundary;

/**
 * Sell presenter.
 */
public class SellPresenter implements SellOutputBoundary {
    private final SellViewModel viewModel;

    public SellPresenter(SellViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void sell(int quantity) {
        ((SellState) (viewModel.getState())).sell(quantity);
        viewModel.firePropertyChanged("upgrade");
    }
}
