package main.java.entity;

public class Corn extends Crop{
    public Corn(int age, boolean isAlive, int price, Long time, Land land) {
        super(age, isAlive, price, time, land);
    }

    public Corn(long time, Land land){
        super(time, land);
    }
}
