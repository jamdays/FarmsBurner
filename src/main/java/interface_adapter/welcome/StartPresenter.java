package main.java.interface_adapter.welcome;

import main.java.use_case.start.StartOutputBoundary;

public class StartPresenter implements StartOutputBoundary{
    private final  WelcomeViewModel welcomeViewModel;

    public StartPresenter(WelcomeViewModel welcomeViewModel) {
        this.welcomeViewModel = welcomeViewModel;
    }
    @Override
    public void execute() {
        ((WelcomeState)(welcomeViewModel.getState())).start();
        welcomeViewModel.firePropertyChanged("view");
    }

}
