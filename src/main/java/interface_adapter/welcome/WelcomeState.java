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
        view = "farm";
        this.loaded = true;
    }

    public String getView(){
        return view;
    }
}
