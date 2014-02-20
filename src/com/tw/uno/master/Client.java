package com.tw.uno.master;

import com.step.uno.client.GameClient;
import com.tw.uno.view.LoadingForm;
import com.tw.uno.view.LoginForm;
import com.tw.uno.view.Screen;

public class Client {
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        UnoClient client = new UnoClient(loginForm, new LoadingForm(), new Screen());
        client.start();
    }
}
