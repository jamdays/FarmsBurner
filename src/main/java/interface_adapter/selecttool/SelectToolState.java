package main.java.interface_adapter.selecttool;

public class SelectToolState {

    // instance variables
    private String currTool;

    // constructor
    public SelectToolState() {
        this.currTool = "none";
    }

    // TODO: make it so that you can only select the tool if you have bought it
    public void selectTool(String tool) {
        this.currTool = tool;
    }

    public String getCurrTool() {
        return currTool;
    }

}
