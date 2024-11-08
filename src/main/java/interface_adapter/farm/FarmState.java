package main.java.interface_adapter.farm;

import main.java.entity.Crop;
import main.java.entity.Farm;
import main.java.entity.Land;

public class FarmState {
    private Farm farm;

    public FarmState() {
        this.farm = new Farm(new Land(4));
    }

    public Land getland() {
        return this.farm.getFarmLand();
    }

    public void plantCrop(){
        this.farm.getFarmLand().addCrop(new Crop());
    }

    public void water(){
        this.farm.water();
    }
}
