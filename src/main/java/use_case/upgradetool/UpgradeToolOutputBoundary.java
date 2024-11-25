package main.java.use_case.upgradetool;

public interface UpgradeToolOutputBoundary {
    /**
     * Updates state so tool is upgraded
     * @param tool, tool to be upgraded
     */
    public void upgrade(String tool);
}
