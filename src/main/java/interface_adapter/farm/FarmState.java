package main.java.interface_adapter.farm;

import main.java.entity.Crop;
import main.java.entity.Farm;
import main.java.entity.Land;

public class FarmState {
    private final int[][] farmLand;
    private final int WET = 0B1;
    private final int CLAIMED = 0B10;
    private final int SNOWY = 0B100;
    private final int PLANTED = 0B1000;
    private final int ALIVE = 0B100000;
    private final int FERTILIZED = 0B1000000;
    // 0 is night, 1 is day, 2 is sunrise/sunset
    private int day;
    private String weather;


    public FarmState() {
         farmLand = new int[8][10];
    }


    public void plantCrop(int r, int c){
        if ((farmLand[r][c] & CLAIMED) == CLAIMED)
            this.farmLand[r][c] = farmLand[r][c] | PLANTED | ALIVE;
        
    }

    public void water(int r, int c){
        if ((farmLand[r][c] & CLAIMED) == CLAIMED)
            this.farmLand[r][c] = farmLand[r][c] | WET;
    }

    public void claim(int r, int c){
        this.farmLand[r][c] = farmLand[r][c] | CLAIMED;

    }

    public int[][] getFarmLand() {
        return farmLand;
    }

    public void harvest(int r, int c) {
        if ((farmLand[r][c] & CLAIMED) == CLAIMED)
            this.farmLand[r][c] = farmLand[r][c] & ~ALIVE;
    }
      
    public void fertilize(int r, int c) {
        if ((farmLand[r][c] & CLAIMED) == CLAIMED) {
            this.farmLand[r][c] = farmLand[r][c] | FERTILIZED;
        }
    }

    public void setWeather(String weather, int day) {
        this.weather = weather;
        this.day = day;
    }

    public String getWeather(){
        return weather;
    }

    public int getDay(){
        return day;
    }
}

