package main.java.entity;

public class Rice extends Crop{
    private String weather;
    private int temp;

    public Rice(int age, boolean isAlive, int price, Long time, Land land) {
        super(age, isAlive, price, time, land);
        this.setName("Rice");
    }

    public Rice(long tme, Land land){
        super(tme, land);
        this.setName("Rice");
    }
}
