package main.java.interface_adapter.selecttool;

import main.java.interface_adapter.ViewModel;

/**
 * Select tool view model.
 */
public class SelectToolViewModel extends ViewModel {

    public SelectToolViewModel() {
        super("selectToolView");
        setState(new SelectToolState());
    }

}
