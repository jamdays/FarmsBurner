package main.java.interface_adapter.welcome;

/**
 * Welcome-state.
 */
public class WelcomeState {
    private String city;
    private boolean loaded;
    private String view;

    public WelcomeState() {
        city = "Toronto";
        loaded = false;
        view = "welcome";
    }

    /**
     * Set city.
     * @param city .
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Loaded.
     */
    public void loaded() {
        this.view = "farm";
        this.loaded = true;
    }

    /**
     * Start.
     */
    public void start() {
        this.view = "farm";
    }

    /**
     * Get view.
     * @return view.
     */
    public String getView() {
        return view;
    }

    /**
     * Get city.
     * @return city.
     */
    public String getCity() {
        return city;
    }
}
