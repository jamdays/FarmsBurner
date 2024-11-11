package main.java.entity;

public class FarmSingleton {
    private static final FarmSingleton instance = new FarmSingleton();
    private Farm farm;
    private FarmSingleton() {
        this.farm = new Farm();
    }
    public static FarmSingleton getInstance() {
        return instance;
    }

    public static void setInstance(Farm farm) {
        getInstance().farm = farm;
    }

    public Farm getFarm() {
        return farm;
    }
}
