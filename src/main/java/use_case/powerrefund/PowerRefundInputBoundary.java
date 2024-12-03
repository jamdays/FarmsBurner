package main.java.use_case.powerrefund;

public interface PowerRefundInputBoundary {
    /**
     * Executes power refund.
     * @param amt amount.
     */
    void refund(int amt);
}
