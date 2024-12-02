package main.java.entity;

import java.io.Serializable;

public abstract class Crop implements Serializable {

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
    public Crop(int age, boolean isAlive, int price, Long time, Land land) {
        this.age = age;
        this.isAlive = isAlive;
        this.price = price;
        this.waterlevel = 0;
        this.time = time;
    }

    public Crop(Long time, Land land){
        this.age = 0;
        this.isAlive = true;
        this.price = 0;
        this.waterlevel = 0;
        this.time = time;
        System.out.println(time);
    }

    // getter and setter for age
    public int getAge() {
        return this.age;
    }


    /**
     * Sets the age and set prices accordingly.
     * LOW KEY THE CROP CAN HAVE A NEGATIVE AGE I HAVEN'T FIXED IT YET
     * @param age the age to be set to
     */
    public void setAge(int age) {
        this.age = age;
        if (this.getAge() == 3){
            this.setPrice(5);
            if (this.getLand().isFertilized()){
                this.setPrice(this.getPrice()*2);
            }

        }
        if (this.getAge() < 3){
            this.setPrice(0);
        }
        if (this.getAge() > 3 && this.getAge() < 6){
            this.setPrice(this.getPrice() + 1);
        }
        if (this.getAge() > 7){
            this.setPrice(this.getPrice()-1);
        }
        if (this.getPrice() == 0){
            this.setIsAlive(false);
        }
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

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Land getLand() {
        return this.land;
    }

    public void setLand(Land land){
        this.land = land;
    }

    public void setTime(long time){
        this.time = time;
    }


    // getter and setter for waterlevel
    public int getWaterlevel() {return this.waterlevel;}

    // plant is watered if waterlevel > 0. This allows plants to start off not watered.
    public boolean isWatered() {return this.waterlevel > 0;}

    public void setWaterlevel(int level) {
        this.waterlevel = level;
    }

    public boolean getReadyToHarvest() {
        return this.getAge() > 5;
    }

    public long getTime(){
        return this.time;
    }

    public void fertilize(){
        this.fertilized = true;
    }

    public void water(){
        if (this.waterlevel == 0){
            age += 1;
        }
        this.waterlevel += 1;
        if (this.waterlevel == 5){
            isAlive = false;
        }
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return this.weather;
    }

    public int getTemp() {
        return this.temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }



    /**
     * Updates the state of the plant based on the time
     * @param time the current time
     */
    public void update(long time){
        //this.time is very different from time
        long diff = time - this.time;
        long days = diff/86400;
        if (days >= 1 && this.waterlevel != 0){
            this.waterlevel = 0;
            land.setIsWet(false);
            age += 1;
            if (age == 3){
                this.price = 5;
                if (this.fertilized){
                    this.price*=2;
                }
            }
            if (age > 3 && age < 6){
                this.price += 1;
            }
            if (age > 5){
                this.price -=1;
            }
            if (this.price == 0){
                this.isAlive = false;
            }
        }
    }


    //TODO write harvest function
    public void harvest(){
//        // Crops are only ready to harvest if age > 5
//        if (this.isAlive && this.age >= 5){
//            this.isAlive = false;
//        }
//        else{
//            System.out.println("Crop is not ready to harvest");
//        }
    }
}
