package main.java.interface_adapter.welcome;

public class WelcomeState {
    private String city;
    private boolean loaded;

    public WelcomeState() {
        city = "Toronto";
        loaded = false;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void loaded(){
        this.loaded = true;
    }
}
