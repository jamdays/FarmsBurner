package main.java.use_case.powerrefund;

/**
 * Power refund output boundary.
 */
public interface PowerRefundOutputboundary {
    /**
     * Refunds the power in FarmState.
     * @param amt amount.
     */
    void refund(int amt);
}
