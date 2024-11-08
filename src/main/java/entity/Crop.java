package main.java.entity;

import java.io.Serializable;

public class Crop implements Serializable {

    // instance variables
    private int age;
    private boolean isAlive;
    private int price;

    // constructor
    public Crop(int age, boolean isAlive, int price) {
        this.age = age;
        this.isAlive = isAlive;
        this.price = price;
    }

    public Crop(){
        this.age = 0;
        this.isAlive = true;
        this.price = 0;
    }

    // getter and setter for age
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // getter and setter for alive
    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    // getter and setter for price
    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
