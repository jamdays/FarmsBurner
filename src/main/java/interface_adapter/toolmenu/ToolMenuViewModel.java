package main.java.interface_adapter.toolmenu;

import main.java.interface_adapter.ViewModel;

/**
 * Tool menu view model.
 */
public class ToolMenuViewModel extends ViewModel {
    public ToolMenuViewModel() {
        super("tool menu");
        setState(new ToolMenuState());
    }
}
