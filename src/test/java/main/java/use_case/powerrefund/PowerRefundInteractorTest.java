package main.java.use_case.powerrefund;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;

public class PowerRefundInteractorTest extends TestCase {

    public void testRefund(){
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);

        PowerRefundOutputboundary outputBoundary = new PowerRefundOutputboundary() {
            @Override
            public void refund(int amt) {
                assertEquals(0, FarmSingleton.getInstance().getFarm().getPower());
            }
        };

        PowerRefundInteractor interactor = new PowerRefundInteractor(outputBoundary);
        interactor.refund(0);
    }
}