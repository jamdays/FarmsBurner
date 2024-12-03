package main.java.interface_adapter.farm;

import main.java.use_case.powerrefund.PowerRefundOutputboundary;

/**
 * Power refund presenter.
 */
public class PowerRefundPresenter implements PowerRefundOutputboundary {
    private final FarmViewModel viewModel;

    public PowerRefundPresenter(FarmViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void refund(int amt) {
        FarmState state = (FarmState) (viewModel.getState());
        state.setPower(state.getPower() + amt);
        viewModel.firePropertyChanged("refund");
    }
}
