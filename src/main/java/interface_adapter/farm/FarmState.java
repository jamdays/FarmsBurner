package main.java.interface_adapter.farm;

/**
 * Farm State.
 */
public class FarmState {
    private int[][] farmLand;
    private long[][] cropTimes;
    private int[][] cropAges;
    private int[][] prices;
    private final int wet = 0B1;
    private final int claimed = 0B10;
    private final int snowy = 0B100;
    private final int planted = 0B1000;
    private final int alive = 0B100000;
    private final int fertilized = 0B1000000;
    private final int ready = 0B10000000;
    private final int cropMask = 0B1100000000;
    private final int rice = 0B0100000000;
    private final int snowBerry = 0B0000000000;
    private final int corn = 0B1100000000;
    private final int wheat = 0B1000000000;
    // 0 is night, 1 is day, 2 is sunrise/sunset
    private int day;
    private String weather;
    private int temp;
    private String currTool;
    private int crop;
    private int barnBucks = 30000000;
    private int power = 10000;
    private long powerRefresh;

    public FarmState() {
        farmLand = new int[16][20];
        cropTimes = new long[16][20];
    }

    /**
     * Sets the farmLand.
     * @param farmland to be set to
     */
    public void setLand(int[][] farmland) {
        this.farmLand = farmland;
    }

    /**
     * Sets the crop times.
     * @param cropTimes to be set to
     */
    public void setCropTimes(long[][] cropTimes) {
        this.cropTimes = cropTimes;
    }

    /**
     * Get power refresh.
     * @return power refresh.
     */
    public long getPowerRefresh() {
        return powerRefresh;
    }

    /**
     * Sets the crop ages.
     * @param cropAges to be set to
     */
    public void setCropAges(int[][] cropAges) {
        this.cropAges = cropAges;
    }

    /**
     * Set crops.
     * @param farmCrops .
     */
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
        if ((farmLand[row][col] & claimed) == claimed && (farmLand[row][col] & planted) != planted) {
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
                if (power < 0) {
                    power += 5;
                    return;
                }
            }
            this.cropTimes[row][col] = time;
            this.farmLand[row][col] = farmLand[row][col] | planted | alive | crop;
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
        if ((farmLand[row][col] & claimed) == claimed) {
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
                if (power < 0) {
                    power += 5;
                    return;
                }
            }
            this.farmLand[row][col] = farmLand[row][col] | wet;
        }
    }

    /**
     * Claim.
     * @param row .
     * @param col .
     */
    public void claim(int row, int col) {
        if ((this.farmLand[row][col] & claimed) != claimed) {
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
                if (power < 0) {
                    power += 5;
                    return;
                }
            }
        }
        this.farmLand[row][col] = farmLand[row][col] | claimed;
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
        if ((farmLand[row][col] & claimed) == claimed) {
            if ((this.farmLand[row][col] & planted) == planted && (this.farmLand[row][col] & alive) == alive) {
                if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                    power -= 5;
                    if (power < 0) {
                        power += 5;
                        return;
                    }
                }
            }
            if ((farmLand[row][col] & snowy) == snowy) {
                this.farmLand[row][col] = snowy;
                this.farmLand[row][col] += claimed;
            }
            else {
                this.farmLand[row][col] = claimed;
            }
        }
    }

    /**
     * Fertilize.
     * @param row .
     * @param col .
     */
    public void fertilize(int row, int col) {
        if ((farmLand[row][col] & claimed) == claimed) {
            if ((this.farmLand[row][col] & fertilized) == fertilized) {
                if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                    power -= 5;
                    if (power < 0) {
                        power += 5;
                        return;
                    }
                }
            }
            this.farmLand[row][col] = farmLand[row][col] | fertilized;
        }
    }

    /**
     * Set weather.
     * @param currWeather .
     * @param currDay .
     * @param time .
     */
    public void setWeather(String currWeather, int currDay, long time, int currTemp) {
        this.weather = currWeather;
        this.day = currDay;
        this.temp = currTemp;
        refreshPower(time);
        // Update crops so that any that should be ready become ready

        for (int r = 0; r < cropTimes.length; r++) {
            for (int c = 0; c < cropTimes[r].length; c++) {
                if (cropTimes[r][c] != 0) {
                    long diff = time - cropTimes[r][c];
                    long days = diff / 86400;
                    updateTime(r, c, time);
                }
                if ("Snow".equalsIgnoreCase(weather)) {
                    farmLand[r][c] += snowy;
                }
                else if (currTemp > 0 && (farmLand[r][c] & snowy) == snowy){
                    farmLand[r][c] -= snowy;
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
            this.crop = snowBerry;
        }
        // rainy crop
        else if ("rice".equalsIgnoreCase(crop)) {
            this.crop = rice;
        }
        // dry crop
        else if ("wheat".equalsIgnoreCase(crop)) {
            this.crop = wheat;
        }
        // regular crop
        else if ("corn".equalsIgnoreCase(crop)) {
            this.crop = corn;
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
        if ((farmLand[row][col] & alive) == alive) {
            return;
        }
        if ((farmLand[row][col] & planted) != planted) {
            return;
        }
        long diff = time - cropTimes[row][col];
        long days = diff / 86400;
        if ((farmLand[row][col] & cropMask) == snowBerry) {
            updateSnowberry(row, col, days);
        }
        if ((farmLand[row][col] & cropMask) == corn) {
            updateCorn(row, col, days);
        }
        if ((farmLand[row][col] & cropMask) == rice) {
            updateRice(row, col, days);
        }
        if ((farmLand[row][col] & cropMask) == wheat) {
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
            farmLand[row][col] = farmLand[row][col] | ready;
            if ((farmLand[row][col] & fertilized) == fertilized) {
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
            farmLand[row][col] = farmLand[row][col] ^ alive;
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
        if (days >= 1 && (farmLand[row][col] & wet) == wet) {
            farmLand[row][col] = farmLand[row][col] ^ wet;
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
                farmLand[row][col] = farmLand[row][col] ^ alive;
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
        if (days >= 1 && (farmLand[row][col] & wet) == wet) {
            farmLand[row][col] = farmLand[row][col] ^ wet;
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
        if (days >= 1 && (farmLand[row][col] & wet) == wet) {
            farmLand[row][col] = farmLand[row][col] ^ wet;
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
        if (days >= 1 && (farmLand[row][col] & wet) == wet) {
            farmLand[row][col] = farmLand[row][col] ^ wet;
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
     * Returns the number of barn bucks.
     * @return returns barn bucks
     */

    public int getBarnBucks() {
        return this.barnBucks;
    }

    /**
     * Setter for barn bucks.
     * @param barnBucks how many barnBucks
     */
    public void setBarnBucks(int barnBucks) {
        this.barnBucks = barnBucks;
    }

    /**
     * Getter for power.
     * @return this.power
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Setter for power.
     * @param power how much power
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Set active tool.
     * @param tool .
     */
    public void setActiveTool(String tool) {
        this.currTool = tool;
    }

    /**
     * Sets the prices.
     * @param prices prices to be set to
     */
    public void setPrices(int[][] prices) {
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

    /**
     * Refresh power.
     * @param time .
     */
    public void refreshPower(long time) {
        if (time - powerRefresh > 10800) {
            powerRefresh = time;
            if ("Clear".equalsIgnoreCase(weather)) {
                power += 100;
            }
            else if ("Clouds".equalsIgnoreCase(weather)) {
                power += 50;
            }
            else if ("Rain".equalsIgnoreCase(weather)) {
                power += 50;
            }
            else if ("Drizzle".equalsIgnoreCase(weather)) {
                power += 50;
            }
            else if ("Thunderstorm".equalsIgnoreCase(weather)) {
                power += 250;
            }
            else if ("Snow".equalsIgnoreCase(weather)) {
                power += 50;
            }
            else {
                power += 25;
            }
        }
    }

}

