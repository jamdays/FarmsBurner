package main.java.interface_adapter.selecttool;

/**
 * Select tool state.
 */
public class SelectToolState {

    // instance variables
    private String currTool;

    // constructor
    public SelectToolState() {
        this.currTool = "none";
    }

    /**
     * Set current tool.
     * @param tool .
     */
    public void setCurrTool(String tool) {
        this.currTool = tool;
    }

    /**
     * Get current tool.
     * @return current tool.
     */
    public String getCurrTool() {
        return currTool;
    }

}
