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

    /**
     * Updates the state of the plant based on the time
     * @param time the current time
     */
    @Override
    public void update(long time){
        //this.time is very different from time
        long diff = time - this.getTime();
        long days = diff/86400;
        if (days == 1 && this.getWaterlevel() != 0){
            this.setWaterlevel(0);
            this.getLand().setIsWet(false);
            this.setAge(this.getAge() + 1);
            if (this.getAge() == 3){
                this.setPrice(5);
                if (this.getLand().isFertilized()){
                    this.setPrice(this.getPrice()*2);
                }
            }
            if (this.getAge() > 3 && this.getAge() < 6){
                this.setPrice(this.getPrice() + 1);
            }
            if (this.getAge() > 5){
                this.setPrice(this.getPrice()-1);
            }
            if (this.getPrice() == 0){
                this.setIsAlive(false);
            }
        }
    }
}
