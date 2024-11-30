package main.java.interface_adapter.welcome;

import main.java.use_case.setcity.SetCityOutputBoundary;

public class SetCityPresenter implements SetCityOutputBoundary {
    private final WelcomeViewModel welcomeViewModel;

    public SetCityPresenter(WelcomeViewModel welcomeViewModel) {
        this.welcomeViewModel = welcomeViewModel;
    }

    @Override
    public void setCity(String city) {
        ((WelcomeState)(welcomeViewModel.getState())).setCity(city);
        welcomeViewModel.firePropertyChanged("city");
    }

}
