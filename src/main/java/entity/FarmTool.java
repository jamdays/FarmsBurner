package main.java.entity;

/**
 * Abstract class for farm tools
 */
abstract class FarmTool {
    //power per use
    private int power;
    //level of tool
    private int level;
    //constructor with power and level
    FarmTool(int power, int level) {
        this.power = power;
        this.level = level;
    }

    //constructor with default power and level (both 0)
    FarmTool() {
        power = 0;
        level = 0;
    }

    public int getLevel() {
        return level;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    abstract void upgrade();

}
