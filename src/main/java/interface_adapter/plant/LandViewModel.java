package main.java.interface_adapter.plant;

import main.java.interface_adapter.ViewModel;

public class LandViewModel extends ViewModel {
    public LandViewModel() {
        super("land");
        setState(new LandState());
    }
}
