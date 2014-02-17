package com.tw.uno.master;

import java.io.Serializable;

public class Message implements Serializable{
    String status;

    public Message(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
