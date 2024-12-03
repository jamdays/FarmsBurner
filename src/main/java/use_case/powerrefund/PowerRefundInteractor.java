package main.java.use_case.powerrefund;

import main.java.entity.FarmSingleton;

/**
 * Power refund interactor.
 */
public class PowerRefundInteractor implements PowerRefundInputBoundary {
    private final PowerRefundOutputboundary powerRefundOutputboundary;

    public PowerRefundInteractor(PowerRefundOutputboundary powerRefundOutputboundary) {
        this.powerRefundOutputboundary = powerRefundOutputboundary;
    }

    /**
     * Refund.
     * @param amt amount.
     */
    @Override
    public void refund(int amt) {
        FarmSingleton.getInstance().getFarm().setPower(FarmSingleton.getInstance().getFarm().getPower() + amt*amt);
        powerRefundOutputboundary.refund(amt*amt);
    }
}
