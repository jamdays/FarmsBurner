package main.java.interface_adapter.plant;

import main.java.entity.Crop;
import main.java.entity.Land;

public class LandState {
    private Land land;

    public LandState() {
        this.land = new Land(4);
    }

    public Land getLand() {
        return this.land;
    }

    public void plantCrop(){
        land.addCrop(new Crop());
    }
}
