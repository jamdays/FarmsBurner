package main.java.entity;

public class Corn extends Crop{

    public Corn(int age, boolean isAlive, int price, Long time, Land land) {
        super(age, isAlive, price, time, land);
        this.setName("Corn");
    }

    public Corn(long time, Land land){
        super(time, land);
        this.setName("Corn");
    }

    /**
     * Updates the state of the plant based on the time
     * @param time the current time
     */
    @Override
    public void update(long time){
        //this.time is very different from time
        long diff = time - this.getTime();
        long days = diff/86400;
        if (days >= 1 && this.getWaterlevel() != 0){
            this.setWaterlevel(0);
            this.getLand().setIsWet(false);
            this.setAge(this.getAge() + 1);
            if (this.getWeather().equalsIgnoreCase("Thunderstorm")){
                this.setAge(this.getAge() - 1);
            }
            else if (this.getTemp() > 15){
                this.setAge(this.getAge() + 1);
            }
            else if (this.getTemp() < 5){
                this.setAge(this.getAge() - 1);
            }
        }
    }
}