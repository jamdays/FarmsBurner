package main.java.entity;

import java.util.ArrayList;

public class Storage {

    // instance variables
    private int capacity;
    private ArrayList<Crate> crates;

    // constructor
    public Storage(int capacity) {
        this.capacity = capacity;
        this.crates = new ArrayList<Crate>();
    }

    // getter and setter for capacity
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // getter and setter for crates
    public ArrayList<Crate> getCrates() {
        return crates;
    }

    public void setCrates(ArrayList<Crate> crates) {
        this.crates = crates;
    }
}
