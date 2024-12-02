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
}
