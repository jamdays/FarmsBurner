package main.java.interface_adapter.sell;

import main.java.interface_adapter.ViewModel;

/**
 * Sell view model.
 */
public class SellViewModel extends ViewModel {
    public SellViewModel() {
        super("sell menu");
        setState(new SellState());
    }
}
