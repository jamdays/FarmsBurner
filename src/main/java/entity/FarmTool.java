package main.java.entity;

import javax.tools.Tool;
import java.io.Serializable;

/**
 * Abstract class for farm tools
 */
abstract class FarmTool implements Serializable{
    //power per use
    private int power;
    //level of tool
    private int level;
    //constructor with power and level
    FarmTool(int power, int level) {
        this.power = power;
        this.level = level;
    }

    // TODO: implement a farmtool that uses FarmTool constructor with no parameters. Otherwise, just delete it (because we can't write a test case for it)
    //constructor with default power and level (both 0)
    public FarmTool() {
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
