package main.java.view;

import main.java.interface_adapter.welcome.WelcomeState;
import main.java.interface_adapter.welcome.WelcomeViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewManager implements PropertyChangeListener {
    public static final String WELCOME = "welcome";
    public static final String FARM = "farm";
    private final CardLayout cardLayout;
    private final JPanel views;
    WelcomeViewModel viewModel;

    public ViewManager(JPanel views, CardLayout cardLayout, WelcomeViewModel welcomeViewModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        welcomeViewModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("welcome")) {
            WelcomeState newValue = (WelcomeState) evt.getNewValue();
            if (newValue.getView().equals(WELCOME)) {
                cardLayout.show(views, WELCOME);
            }
            else if (newValue.getView().equals(FARM)) {
                cardLayout.show(views, FARM);
            }
        }
    }
}