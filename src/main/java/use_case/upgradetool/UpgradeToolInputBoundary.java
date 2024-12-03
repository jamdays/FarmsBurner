package main.java.use_case.upgradetool;

/**
 * Upgrade tool input boundary.
 */
public interface UpgradeToolInputBoundary {
    /**
     * Upgrades tool selected.
     * @param tool tool to be upgraded
     */
    void upgrade(String tool);
}
