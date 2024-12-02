package main.java.entity;

public class Snowberry extends Crop {
    public Snowberry(int age, boolean isAlive, int price, Long time, Land land) {
        super(age, isAlive, price, time, land);
        this.setName("Snowberry");
    }

    public Snowberry(long tme, Land land){
        super (tme, land);
        this.setName("Snowberry");
    }


    /**
     * Updates the state of the plant based on the time
     * @param time the current time
     */
    @Override
    public void update(long time){
        long diff = time - this.getTime();
        long days = diff/86400;
        if (days >= 1 && this.getWaterlevel() != 0){
            this.setWaterlevel(0);
            this.getLand().setIsWet(false);
            this.setAge(this.getAge() + 1);
            if (this.getTemp() < 3) {
                if (this.getWeather().equalsIgnoreCase("Snow")) {
                    this.setAge(this.getAge() + 1);
                }
                if (this.getTemp() < -10){
                    this.setAge(this.getAge() + 1);
                }
            }
            else if (this.getTemp() > 8 && this.getTemp() < 18){
                this.setAge(this.getAge() - 1);
            }
            else if (this.getTemp() > 18){
                this.setIsAlive(false);
            }
        }
    }
}
