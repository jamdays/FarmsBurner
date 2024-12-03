package main.java.entity;

import java.io.Serializable;

/**
 * Crop class.
 */
public abstract class AbstractCrop implements Serializable {

    // instance variables
    private int age;
    private boolean isAlive;
    private int price;
    private int waterlevel;
    private Long time;
    private Land land;
    private boolean fertilized;
    private String name;
    private String weather;
    private int temp;

    // constructor
    public AbstractCrop(int age, boolean isAlive, int price, Long time, Land land) {
        this.age = age;
        this.isAlive = isAlive;
        this.price = price;
        this.waterlevel = 0;
        this.time = time;
    }

    public AbstractCrop(Long time, Land land) {
        this.age = 0;
        this.isAlive = true;
        this.price = 0;
        this.waterlevel = 0;
        this.time = time;
        System.out.println(time);
    }

    /**
     * Get age.
     * @return .
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Sets the age and set prices accordingly.
     * @param age the age to be set to
     */
    public void setAge(int age) {
        this.age = age;
        if (this.getAge() == 3) {
            this.setPrice(5);
            if (this.getLand().isFertilized()) {
                this.setPrice(this.getPrice() * 2);
            }

        }
        if (this.getAge() < 3) {
            this.setPrice(0);
        }
        if (this.getAge() > 3 && this.getAge() < 6) {
            this.setPrice(this.getPrice() + 1);
        }
        if (this.getAge() > 7) {
            this.setPrice(this.getPrice()-1);
        }
        if (this.getPrice() == 0) {
            this.setIsAlive(false);
        }
    }

    /**
     * Get is alive.
     * @return isAlive.
     */
    public boolean getIsAlive() {
        return this.isAlive;
    }

    /**
     * Set is alive.
     * @param isAlive .
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * Get price.
     * @return price.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Set price.
     * @param price .
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Get name.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set name.
     * @param name .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get land.
     * @return .
     */
    public Land getLand() {
        return this.land;
    }

    /**
     * Set land.
     * @param land .
     */
    public void setLand(Land land) {
        this.land = land;
    }

    /**
     * Set time.
     * @param time .
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Get water level.
     * @return water level.
     */
    public int getWaterlevel() {
        return this.waterlevel;
    }

    /**
     * Plant is watered if waterlevel > 0. This allows plants to start off not watered.
     * @return whether plants is watered or not.
     */
    public boolean isWatered() {
        return this.waterlevel > 0;
    }

    /**
     * Set water level.
     * @param level .
     */
    public void setWaterLevel(int level) {
        this.waterlevel = level;
    }

    /**
     * Get ready to harvest.
     * @return whether age > 5.
     */
    public boolean getReadyToHarvest() {
        return this.getAge() > 5;
    }

    /**
     * Get time.
     * @return time.
     */
    public long getTime() {
        return this.time;
    }

    /**
     * Fertilize.
     */
    public void fertilize() {
        this.fertilized = true;
    }

    /**
     * Water.
     */
    public void water() {
        this.waterlevel++;
    }

    /**
     * Set weather.
     * @param weather .
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     * Get weather.
     * @return weather.
     */
    public String getWeather() {
        return this.weather;
    }

    /**
     * Get temp.
     * @return temp.
     */
    public int getTemp() {
        return this.temp;
    }

    /**
     * Set temp.
     * @param temp .
     */
    public void setTemp(int temp) {
        this.temp = temp;
    }



    /**
     * Updates the state of the plant based on the time.
     * @param time the current time
     */
    public void update(long time) {
        // this.time is very different from time
        long diff = time - this.time;
        long days = diff / 86400;
        if (days >= 1 && this.waterlevel != 0) {
            this.waterlevel = 0;
            land.setIsWet(false);
            age += 1;
            if (age == 3) {
                this.price = 5;
                if (this.fertilized) {
                    this.price *= 2;
                }
            }
            if (age > 3 && age < 6) {
                this.price += 1;
            }
            if (age > 5) {
                this.price -= 1;
            }
            if (this.price == 0) {
                this.isAlive = false;
            }
        }
    }

    // TODO write harvest function

    /**
     * Harvest.
     */
    public void harvest() {

    }
}
