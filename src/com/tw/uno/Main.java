package com.tw.uno;

import com.tw.uno.view.Loading;
import com.tw.uno.view.LoginForm;
import com.tw.uno.view.Screen;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setVisible(true);
        new Loading();
        new LoginForm();
    }
}
