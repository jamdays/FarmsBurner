package main.java.entity;

/**
 * Wheat class.
 */
public class Wheat extends AbstractCrop {
    public Wheat(int age, boolean isAlive, int price, Long time, Land land) {
        super(age, isAlive, price, time, land);
        this.setName("Wheat");
    }

    public Wheat(long tme, Land land) {
        super(tme, land);
        this.setName("Wheat");
    }

    /**
     * Updates the state of the plant based on the time.
     * @param time the current time
     */
    @Override
    public void update(long time) {
        long diff = time - this.getTime();
        long days = diff / 86400;
        if (days >= 1 && this.getWaterlevel() != 0) {
            this.setWaterLevel(0);
            this.getLand().setIsWet(false);
            this.setAge(this.getAge() + 1);
            if (this.getTemp() < 3) {
                this.setAge(this.getAge() - 1);
            }
            else if (this.getTemp() > 15) {
                this.setAge(this.getAge() + 1);
                if (!this.getWeather().equalsIgnoreCase("Rain")
                        && !this.getWeather().equalsIgnoreCase("Drizzle")
                        && !this.getWeather().equalsIgnoreCase("Thunderstorm")) {
                    this.setAge(this.getAge() + 1);
                }
            }
        }
    }
}
