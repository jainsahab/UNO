package com.tw.uno.master;

import com.tw.uno.view.LoadingForm;
import com.tw.uno.view.LoginForm;
import com.tw.uno.view.Screen;

public class Client {
    public static void main(String[] args) {
        UnoClient client = null;
        LoginForm loginForm = new LoginForm();
        client = new UnoClient(loginForm,new LoadingForm(),new Screen());
        client.start();
    }
}
