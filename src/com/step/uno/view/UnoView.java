package com.step.uno.view;

import com.step.uno.messages.Snapshot;

public class UnoView {
    private UnoViewListener listener;
    private LoginForm loginForm;
    private PlayerScreen playerScreen = new PlayerScreen();

    public UnoView(UnoViewListener listener) {
        this.listener = listener;
    }

    public void showLoginForm() {
        loginForm = new LoginForm(listener);
        loginForm.setVisible(true);
    }

    public void hideLoginForm() {
        loginForm.setVisible(false);
    }

    public void displayPlayerScreen(Snapshot snapshot) {
        playerScreen.setVisible(true);
    }
}
