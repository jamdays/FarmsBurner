package main.java.interface_adapter.welcome;

public class WelcomeState {
    private String city;
    private boolean loaded;
    private String view;

    public WelcomeState() {
        city = "Toronto";
        loaded = false;
        view = "welcome";
    }

    public void setCity(String city){
        this.city = city;
    }

    public void loaded(){
        this.view = "farm";
        this.loaded = true;
    }

    public void start(){
        this.view = "farm";
    }

    public String getView(){
        return view;
    }
    public String getCity(){
        return city;
    }
}
