package main.java.entity;

import java.io.Serializable;

/**
 * The sprinkler uses 150 power more each time it is upgraded
 * and waters (level + 1)^2 crops.
 */
public class Sprinkler extends FarmTool implements Serializable {
    //area that can be watered by the sprinkler
    private int area;

    public Sprinkler(){
        super(150, 0);
        this.area = (this.getLevel()+1)*(this.getLevel()+1);
    }

    public Sprinkler(int level){
        super((level+1)*150, level);
        this.area = (this.getLevel()+1)*(this.getLevel()+1);
    }

    @Override
    public void upgrade() {
        if (getLevel() < 4) {
            this.setLevel(this.getLevel() + 1);
            this.setPower(this.getPower() + 150);
        }
    }

    public int getArea() {
        return this.area;
    }

}
