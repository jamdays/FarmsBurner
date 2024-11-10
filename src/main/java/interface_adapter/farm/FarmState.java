package main.java.interface_adapter.farm;

import main.java.entity.Crop;
import main.java.entity.Farm;
import main.java.entity.Land;

public class FarmState {
    private Farm farm;

    public FarmState() {
        this.farm = new Farm();
    }


    public void plantCrop(int r, int c){
        this.farm.plant(r, c);
    }

    public void water(int r, int c){
        this.farm.water(r, c)   ;
    }
}
