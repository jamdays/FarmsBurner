package main.java.entity;

public class Wheat extends Crop{
    public Wheat(int age, boolean isAlive, int price, Long time, Land land) {
        super(age, isAlive, price, time, land);
        this.setName("Wheat");
    }

    public Wheat(long tme, Land land){
        super(tme, land);
        this.setName("Wheat");
    }
}
