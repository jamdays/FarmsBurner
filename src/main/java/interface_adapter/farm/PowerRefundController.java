package main.java.interface_adapter.farm;

import main.java.use_case.powerrefund.PowerRefundInteractor;

/**
 * Power refund controller.
 */
public class PowerRefundController {
    private final PowerRefundInteractor refundInteractor;

    public PowerRefundController(PowerRefundInteractor refundInteractor) {
        this.refundInteractor = refundInteractor;
    }

    /**
     * Power refund.
     * @param amt .
     */
    public void powerRefund(int amt) {
        powerRefund(amt);
    }
}
