package main.java.entity;

/**
 * Farm Singleton.
 */
public final class FarmSingleton {
    private static final FarmSingleton INSTANCE = new FarmSingleton();
    private Farm farm;

    private FarmSingleton() {
        this.farm = new Farm();
    }

    public static FarmSingleton getInstance() {
        return INSTANCE;
    }

    public static void setInstance(Farm farm) {
        getInstance().farm = farm;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
