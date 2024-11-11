package main.java.interface_adapter.farm;

import main.java.interface_adapter.ViewModel;

public class FarmViewModel extends ViewModel {
    public FarmViewModel() {
        super("land");
        setState(new FarmState());
    }




}
