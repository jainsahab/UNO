package com.tw.uno.master;

import java.io.IOException;
import java.net.Socket;

public class UnoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}