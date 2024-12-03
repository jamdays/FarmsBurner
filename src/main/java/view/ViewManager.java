package main.java.view;

import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import main.java.interface_adapter.welcome.WelcomeState;
import main.java.interface_adapter.welcome.WelcomeViewModel;

/**
 * View Manager.
 */
public class ViewManager implements PropertyChangeListener {
    public static final String WELCOME = "welcome";
    public static final String FARM = "farm";
    private WelcomeViewModel viewModel;
    private final CardLayout cardLayout;
    private final JPanel views;

    public ViewManager(JPanel views, CardLayout cardLayout, WelcomeViewModel welcomeViewModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        viewModel = welcomeViewModel;
        viewModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
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
