package main.java.use_case.powerrefund;

public interface PowerRefundOutputboundary {
    /**
     * refunds the power in FarmState.
     * @param amt amount.
     */
    void refund(int amt);
}
