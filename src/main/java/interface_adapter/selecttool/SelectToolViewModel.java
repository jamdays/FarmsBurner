package interface_adapter.selecttool;

import main.java.interface_adapter.ViewModel;

public class SelectToolViewModel extends ViewModel {

    private String tool;

    public SelectToolViewModel() {
        super("selectToolView");
        setState(new SelectToolState());
    }


}
