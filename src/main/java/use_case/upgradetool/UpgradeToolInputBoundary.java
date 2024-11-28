package main.java.use_case.upgradetool;

import main.java.entity.FarmTool;

public interface UpgradeToolInputBoundary {
    /**
     * upgrades tool selected
     * @param tool, tool to be upgraded
     */
    void upgrade(String tool);
}
