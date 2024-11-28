package main.java.entity;

import javax.tools.Tool;
import java.io.Serializable;

/**
 * Abstract class for farm tools
 */
public abstract class FarmTool implements Serializable{
    //power per use
    private int power;
    //level of tool
    private int level;
    //constructor with power and level
    public FarmTool(int power, int level) {
        this.power = power;
        this.level = level;
    }

    //constructor with default power and level (both 0)
//    public FarmTool() {
//        power = 0;
//        level = 0;
//    }

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
