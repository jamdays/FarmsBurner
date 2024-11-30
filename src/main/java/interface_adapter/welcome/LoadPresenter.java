package main.java.interface_adapter.welcome;

import main.java.use_case.load.LoadOutputBoundary;

public class LoadPresenter implements LoadOutputBoundary {
    private final  WelcomeViewModel welcomeViewModel;

    public LoadPresenter(WelcomeViewModel welcomeViewModel) {
        this.welcomeViewModel = welcomeViewModel;
    }
    @Override
    public void loaded() {
        ((WelcomeState)(welcomeViewModel.getState())).loaded();
        welcomeViewModel.firePropertyChanged("loaded");
    }
}
