package main.java.entity;

import java.io.Serializable;

/**
 * Abstract class for farm tools.
 */
public abstract class AbstractFarmTool implements Serializable {
    // power per use
    private int power;
    // level of tool
    private int level;
    // constructor with power and level

    public AbstractFarmTool(int power, int level) {
        this.power = power;
        this.level = level;
    }

    /**
     * Get level.
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Get power.
     * @return power.
     */
    public int getPower() {
        return power;
    }

    /**
     * Set power.
     * @param power .
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Set level.
     * @param level .
     */
    public void setLevel(int level) {
        this.level = level;
    }

    abstract void upgrade();

}
