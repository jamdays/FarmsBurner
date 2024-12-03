package main.java.interface_adapter.farm;

/**
 * Farm State.
 */
public class FarmState {
    private int[][] farmLand;
    private long[][] cropTimes;
    private int[][] cropAges;
    private int[][] prices;
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
    private int temp;
    private String currTool;
    private int crop;
    private int barnBucks;
    private int power;
    private long powerRefresh;


    public FarmState() {
        farmLand = new int[16][20];
        cropTimes = new long[16][20];
    }

    /**
     * Sets the farmLand
     * @param farmLand to be set to
     */
    public void setLand(int[][] farmLand) {
        this.farmLand = farmLand;
    }

    /**
     * Sets the crop times
     * @param cropTimes to be set to
     */
    public void setCropTimes(long[][] cropTimes) {
        this.cropTimes = cropTimes;
    }

    public long getPowerRefresh(){
        return powerRefresh;
    }

    /**
     * Sets the crop ages
     * @param cropAges to be set to
     */
    public void setCropAges(int[][] cropAges) {
        this.cropAges = cropAges;
    }

    public void setCrops(long[][] farmCrops) {
        this.cropTimes = farmCrops;
    }

    /**
     * Plant crops.
     * @param row .
     * @param col .
     * @param time .
     */
    public void plantCrop(int row, int col, long time) {
        // if claimed and not planted set time and update little guy
        if ((farmLand[row][col] & CLAIMED) == CLAIMED && (farmLand[row][col] & PLANTED) != PLANTED) {
            this.cropTimes[row][col] = time;
            this.farmLand[row][col] = farmLand[row][col] | PLANTED | ALIVE | crop;
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
            }
        }
        for (int r = 0; r < cropTimes.length; r++) {
            for (int c = 0; c < cropTimes[r].length; c++) {
                if (cropTimes[r][c] != 0) {
                    long diff = time - cropTimes[r][c];
                    long days = diff / 86400;
                    updateTime(r, c, time);
                }
            }
        }

    }

    /**
     * Water.
     * @param row .
     * @param col .
     */
    public void water(int row, int col) {
        if ((farmLand[row][col] & CLAIMED) == CLAIMED) {
            this.farmLand[row][col] = farmLand[row][col] | WET;
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
            }
        }
    }

    /**
     * Claim.
     * @param row .
     * @param col .
     */
    public void claim(int row, int col) {
        if ((this.farmLand[row][col] & CLAIMED) != CLAIMED) {
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
            }
        }
        this.farmLand[row][col] = farmLand[row][col] | CLAIMED;
    }

    /**
     * Get farm land.
     * @return farmland.
     */
    public int[][] getFarmLand() {
        return farmLand;
    }

    /**
     * Harvest.
     * @param row .
     * @param col .
     */
    public void harvest(int row, int col) {
        if ((farmLand[row][col] & CLAIMED) == CLAIMED) {
            if ((this.farmLand[row][col] & PLANTED) == PLANTED && (this.farmLand[row][col] & ALIVE) == ALIVE) {
                if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                    power -= 5;
                }
            }
            this.farmLand[row][col] = CLAIMED;
        }
    }

    /**
     * Fertilize.
     * @param row .
     * @param col .
     */
    public void fertilize(int row, int col) {
        if ((farmLand[row][col] & CLAIMED) == CLAIMED) {
            if ((this.farmLand[row][col] & FERTILIZED) == FERTILIZED) {
                if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                    power -= 5;
                }
            }
            this.farmLand[row][col] = farmLand[row][col] | FERTILIZED;
        }
    }

    /**
     * Set weather.
     * @param weather .
     * @param day .
     * @param time .
     */
    public void setWeather(String weather, int day, long time, int temp) {
        this.weather = weather;
        this.day = day;
        this.temp = temp;
        refreshPower(time);
        //Update crops so that any that should be ready become ready

        for (int r = 0; r < cropTimes.length; r++) {
            for (int c = 0; c < cropTimes[r].length; c++) {
                if (cropTimes[r][c] != 0) {
                    long diff = time - cropTimes[r][c];
                    long days = diff / 86400;
                    updateTime(r, c, time);
                }
            }
        }
    }

    /**
     * Set crop.
     * @param crop .
     */
    public void setCrop(String crop) {
        if ("snowberry".equalsIgnoreCase(crop)) {
            this.crop = SNOWBERRY;
        }
        // rainy crop
        else if ("rice".equalsIgnoreCase(crop)) {
            this.crop = RICE;
        }
        // dry crop
        else if ("wheat".equalsIgnoreCase(crop)) {
            this.crop = WHEAT;
        }
        // regular crop
        else if ("corn".equalsIgnoreCase(crop)) {
            this.crop = CORN;
        }
    }

    /**
     * Updates time for one crop.
     * private method (only called in updateAll)
     * @param row row of plant to be updated
     * @param col column of plant to be updated
     * @param time new time
     */
    private void updateTime(int row, int col, long time) {
        if ((farmLand[row][col] & ALIVE) == ALIVE) {
            return;
        }
        if ((farmLand[row][col] & PLANTED) != PLANTED) {
            return;
        }
        long diff = time - cropTimes[row][col];
        long days = diff / 86400;
        if ((farmLand[row][col] & CROP_MASK) == SNOWBERRY) {
            updateSnowberry(row, col, days);
        }
        if ((farmLand[row][col] & CROP_MASK) == CORN) {
            updateCorn(row, col, days);
        }
        if ((farmLand[row][col] & CROP_MASK) == RICE) {
            updateRice(row, col, days);
        }
        if ((farmLand[row][col] & CROP_MASK) == WHEAT) {
            updateWheat(row, col, days);
        }
    }


    /**
     * Changes the age and updates the price with it.
     * <p>Assumes crop is alive</p>
     * <p>Assumes crop exits at r c</p>
     * The age could be set to negative
     * Works best if age is only changed by 1 at a time
     * @param row row where the crop is
     * @param col column where the crop is
     * @param age new age of the plant
     */
    private void changeAge(int row, int col, int age) {
        cropAges[row][col] = age;
        if (age == 3) {
            prices[row][col] = 5;
            farmLand[row][col] = farmLand[row][col] | READY;
            if ((farmLand[row][col] & FERTILIZED) == FERTILIZED) {
                prices[row][col] = prices[row][col] * 2;
            }

        }
        if (age < 3) {
            prices[row][col] = 0;
        }
        if (age > 3 && age < 6) {
            prices[row][col] = prices[row][col] + 1;
        }
        if (age > 7) {
            prices[row][col] = prices[row][col] - 1;
        }
        if (prices[row][col] == 0) {
            farmLand[row][col] = farmLand[row][col] ^ ALIVE;
        }
    }

    /**
     * Updates the snowberry.
     * Private because it is only called in updateTime
     * @param row row of plant
     * @param col column of plant
     * @param days days since planted
     */
    private void updateSnowberry(int row, int col, long days) {
        if (days >= 1 && (farmLand[row][col] & WET) == WET) {
            farmLand[row][col] = farmLand[row][col] ^ WET;
            changeAge(row, col, cropAges[row][col] + 1);
            if (temp < 3) {
                if ("Snow".equalsIgnoreCase(this.getWeather())) {
                    changeAge(row, col, cropAges[row][col] + 1);
                }
                if (temp < -9) {
                    changeAge(row, col, cropAges[row][col] + 1);
                }
            }
            else if (temp > 8 && temp < 19) {
                changeAge(row, col, cropAges[row][col] - 1);
            }
            else if (temp > 18) {
                farmLand[row][col] = farmLand[row][col] ^ ALIVE;
            }
        }
    }


    /**
     * Updates the rice.
     * Private because it is only called in updateTime
     * @param row row of plant
     * @param col column of plant
     * @param days days since planted
     */
    private void updateRice(int row, int col, long days) {
        if (days >= 1 && (farmLand[row][col] & WET) == WET) {
            farmLand[row][col] = farmLand[row][col] ^ WET;
            changeAge(row, col, cropAges[row][col] + 1);
            if ("Thunderstorm".equalsIgnoreCase(this.getWeather())) {
                changeAge(row, col, cropAges[row][col] + 1);
                changeAge(row, col, cropAges[row][col] + 1);
            }
            else if ("Rain".equalsIgnoreCase(this.getWeather())) {
                changeAge(row, col, cropAges[row][col] + 1);
            }
            else if (temp < 0) {
                changeAge(row, col, cropAges[row][col] - 1);
            }
        }
    }


    /**
     * Updates the corn.
     * Private because it is only called in updateTime
     * @param row row of plant
     * @param col column of plant
     * @param days days since planted
     */
    private void updateCorn(int row, int col, long days) {
        if (days >= 1 && (farmLand[row][col] & WET) == WET) {
            farmLand[row][col] = farmLand[row][col] ^ WET;
            changeAge(row, col, cropAges[row][col] + 1);
            if ("Thunderstorm".equalsIgnoreCase(this.getWeather())) {
                changeAge(row, col, cropAges[row][col] - 1);
            }
            else if (temp > 15) {
                changeAge(row, col, cropAges[row][col] + 1);
            }
            else if (temp < 5) {
                changeAge(row, col, cropAges[row][col] - 1);
            }
        }
    }

    /**
     * Updates the wheat.
     * Private because it is only called in updateTime
     * @param row row of plant
     * @param col column of plant
     * @param days days since planted
     */
    private void updateWheat(int row, int col, long days) {
        if (days >= 1 && (farmLand[row][col] & WET) == WET) {
            farmLand[row][col] = farmLand[row][col] ^ WET;
            changeAge(row, col, cropAges[row][col] + 1);
            if (temp < 3) {
                changeAge(row, col, cropAges[row][col] - 1);
            }
            else if (temp > 15) {
                changeAge(row, col, cropAges[row][col] + 1);
                if (!"Rain".equalsIgnoreCase(weather)
                        && !"Drizzle".equalsIgnoreCase(weather)
                        && !"Thunderstorm".equalsIgnoreCase(weather)) {
                    changeAge(row, col, cropAges[row][col] + 1);
                }
            }
        }
    }

    /**
     * Get crop.
     * @return crop.
     */
    public int getCrop() {
        return crop;
    }
    /**
     * Returns the number of barn bucks
     * @return returns barn bucks
     */
    public int getBarnBucks(){
        return this.barnBucks;
    }

    /**
     * Setter for barn bucks
     * @param barnBucks how many barnBucks
     */
    public void setBarnBucks(int barnBucks){
        this.barnBucks = barnBucks;
    }

    /**
     * Getter for power
     * @return this.power
     */
    public int getPower(){
        return this.power;
    }

    /**
     * Setter for power
     * @param power how much power
     */
    public void setPower(int power){
        this.power = power;
    }

    /**
     * Set active tool.
     * @param currTool .
     */
    public void setActiveTool(String currTool) {
        this.currTool = currTool;
    }

    /**
     * Sets the prices
     * @param prices prices to be set to
     */
    public void setPrices(int[][] prices){
        this.prices = prices;
    }
    // public int getCrop(){
    //   return crop;
    // }

    // public void setActiveTool(String currTool) {
    //   this.currTool = currTool;
    // }

    /**
     * Get weather.
     * @return weather.
     */
    public String getWeather() {
        return weather;
    }

    /**
     * Get day.
     * @return day.
     */
    public int getDay() {
        return day;
    }

    public void refreshPower(long time){
        if (time - powerRefresh > 10800){
            powerRefresh = time;
            if ("Clear".equalsIgnoreCase(weather)){
                power += 100;
            }
            else if ("Clouds".equalsIgnoreCase(weather)){
                power += 50;
            }
            else if ("Rain".equalsIgnoreCase(weather)){
                power += 50;
            }
            else if ("Drizzle".equalsIgnoreCase(weather)){
                power += 50;
            }
            else if ("Thunderstorm".equalsIgnoreCase(weather)){
                power += 250;
            }
            else if ("Snow".equalsIgnoreCase(weather)){
                power += 50;
            }
            else {
                power += 25;
            }
        }
    }

}

