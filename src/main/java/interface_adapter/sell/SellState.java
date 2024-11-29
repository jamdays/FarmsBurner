package main.java.interface_adapter.sell;

public class SellState {
    private int money;

    public SellState(int money) {
        this.money = money;
    }

    public SellState(){
        this.money = 0;
    }

    public void sell(int quantity){
        this.money += quantity*5;
    }
}
