package main.java.use_case.powerrefund;

/**
 * Power refund input boundary.
 */
public interface PowerRefundInputBoundary {
    /**
     * Executes power refund.
     * @param amt amount.
     */
    void refund(int amt);
}
