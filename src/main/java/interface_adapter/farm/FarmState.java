package main.java.interface_adapter.farm;

public class FarmState {
    private int[][] farmLand;
    private long[][] cropTimes;
    private int[][] cropAges;
    private final int WET = 0B1;
    private final int CLAIMED = 0B10;
    private final int SNOWY = 0B100;
    private final int PLANTED = 0B1000;
    private final int ALIVE = 0B100000;
    private final int FERTILIZED = 0B1000000;
    private final int READY = 0B10000000;
    private final int CROP_MASK = 0B1100000000;
    private final int RICE = 0B0100000000;
    private final int SNOWBERRY = 0B0000000000;
    private final int CORN = 0B1100000000;
    private final int WHEAT = 0B1000000000;
    // 0 is night, 1 is day, 2 is sunrise/sunset
    private int day;
    private String weather;
    private String currTool;
    private int crop;


    public FarmState() {
         farmLand = new int[16][20];
         cropTimes = new long[16][20];
    }

    public void setLand(int[][] farmLand) {
        this.farmLand = farmLand;
    }

    public void setCrops(long[][] farmCrops) {
        this.cropTimes = farmCrops;
    }

    public void plantCrop(int r, int c, long time){
        //if claimed and not planted set time and update little guy
        if ((farmLand[r][c] & CLAIMED) == CLAIMED && (farmLand[r][c] & PLANTED) != PLANTED) {
            this.cropTimes[r][c] = time;
            this.farmLand[r][c] = farmLand[r][c] | PLANTED | ALIVE | crop;
        }
        
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

    public void setWeather(String weather, int day, long time) {
        this.weather = weather;
        this.day = day;
        //Update crops so that any that should be ready become ready

        for (int r = 0; r < cropTimes.length; r++) {
            for (int c = 0; c < cropTimes[r].length; c++) {
                if (cropTimes[r][c] != 0) {
                    long diff = time - cropTimes[r][c];
                    long days = diff / 86400;
                    if (days == 1 && (farmLand[r][c] & WET) == WET) {
                        farmLand[r][c] = farmLand[r][c] ^ WET;
                        cropAges[r][c] += 1;
                        if (cropAges[r][c] > 3) {
                            farmLand[r][c] = farmLand[r][c] | READY;
                        }
                    }
                }
            }
        }
    }

    public void setCrop(String crop){
        if (crop.equalsIgnoreCase("snowberry")) {
            this.crop = SNOWBERRY;
        }
        // rainy crop
        else if (crop.equalsIgnoreCase("rice")) {
            this.crop = RICE;
        }
        // dry crop
        else if (crop.equalsIgnoreCase("wheat")) {
            this.crop = WHEAT;
        }
        // regular crop
        else if (crop.equalsIgnoreCase("corn")) {
            this.crop = CORN;
        }
    }

    public int getCrop(){
        return crop;
    }

    public void setActiveTool(String currTool) {
        this.currTool = currTool;
    }

    public int getCrop(){
        return crop;
    }

    public String getWeather(){
        return weather;
    }

    public int getDay(){
        return day;
    }

}

