package main.java.interface_adapter.welcome;

import main.java.use_case.load.LoadOutputBoundary;
import main.java.use_case.setcity.SetCityOutputBoundary;

public class WelcomePresenter implements SetCityOutputBoundary, LoadOutputBoundary {
    private WelcomeViewModel welcomeViewModel;

    @Override
    public void setCity(String city) {
        ((WelcomeState)(welcomeViewModel.getState())).setCity(city);
        welcomeViewModel.firePropertyChanged("city");
    }

    @Override
    public void loaded() {
        ((WelcomeState)(welcomeViewModel.getState())).loaded();
        welcomeViewModel.firePropertyChanged("loaded");
    }
}
