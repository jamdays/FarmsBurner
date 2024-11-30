package main.java.interface_adapter.toolmenu;

import main.java.use_case.buytool.BuyToolInputBoundary;

public class BuyController {
    private final BuyToolInputBoundary buyToolInputBoundary;

    public BuyController(BuyToolInputBoundary buyToolInputBoundary) {
        this.buyToolInputBoundary = buyToolInputBoundary;
    }

    public void buy(String tool){
        buyToolInputBoundary.buy(tool);
    }


}
