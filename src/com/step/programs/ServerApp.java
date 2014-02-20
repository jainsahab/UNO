package com.step.programs;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.factory.UnoFactory;
import com.step.uno.server.GameMaster;

public class ServerApp {
    public static void main(String[] args) {
        new GameMaster(1, 1, new CommunicationFactory(),new UnoFactory()).start();
    }
}
