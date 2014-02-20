package com.step.uno.view;

public class UnoView {
    private UnoViewListener listener;
    private LoginForm loginForm;

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
}
