package main.java.use_case.upgradetool;

/**
 * Upgrade tool output boundary.
 */
public interface UpgradeToolOutputBoundary {
    /**
     * Updates state so tool is upgraded.
     * @param tool tool to be upgraded
     */
    void upgrade(String tool);
}
