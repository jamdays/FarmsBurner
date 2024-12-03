package main.java.entity;

import java.io.Serializable;

/**
 * Rice class.
 */
public class Rice extends AbstractCrop implements Serializable {

    public Rice(int age, boolean isAlive, int price, Long time, Land land) {
        super(age, isAlive, price, time, land);
        this.setName("Rice");
    }

    public Rice(long tme, Land land) {
        super(tme, land);
        this.setName("Rice");
    }

    /**
     * Updates the state of the plant based on the time.
     * @param time the current time
     */
    @Override
    public void update(long time) {
        // this.time is very different from time
        long diff = time - this.getTime();
        long days = diff / 86400;
        if (days >= 1 && this.getWaterlevel() != 0) {
            this.setWaterLevel(0);
            this.getLand().setIsWet(false);
            this.setAge(this.getAge() + 1);
            if (this.getWeather().equalsIgnoreCase("Thunderstorm")) {
                // HAS TO be like this because the age can only increment by 1 for the price to update properly
                this.setAge(this.getAge() + 1);
                this.setAge(this.getAge() + 1);
            }
            else if (this.getWeather().equalsIgnoreCase("Rain")) {
                this.setAge(this.getAge() + 1);
            }
            else if (this.getTemp() < 0) {
                this.setAge(this.getAge() - 1);
            }
        }
    }
}
