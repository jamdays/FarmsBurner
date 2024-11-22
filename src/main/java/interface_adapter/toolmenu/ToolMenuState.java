package main.java.interface_adapter.toolmenu;

public class ToolMenuState {
    int sprinkler;

    public ToolMenuState(int sprinkler) {
        this.sprinkler = sprinkler;
    }

    public ToolMenuState() {
        this.sprinkler = -1;
    }

    public void buy(String tool){
        if (tool.equalsIgnoreCase("Sprinkler")) {
            if (sprinkler == -1) {
                sprinkler = 0;
            }
        }
    }

    public void upgrade(String tool){
        if (tool.equalsIgnoreCase("Sprinkler")) {
            if (sprinkler != -1) {
                sprinkler += 1;
            }
        }
    }
}
