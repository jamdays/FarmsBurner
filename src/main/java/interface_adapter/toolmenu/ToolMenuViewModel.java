package main.java.interface_adapter.toolmenu;

import main.java.interface_adapter.ViewModel;
import main.java.interface_adapter.welcome.WelcomeState;

public class ToolMenuViewModel extends ViewModel {
    public ToolMenuViewModel() {
        super("tool menu");
        setState(new ToolMenuState());
    }
}
