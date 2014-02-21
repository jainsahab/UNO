package com.step.programs;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.factory.UnoFactory;
import com.step.uno.server.GameMaster;

public class ServerApp {
    public static void main(String[] args) {
        int noOfPlayers = Integer.parseInt(args[0]);
        int noOfPacks = Integer.parseInt(args[1]);
        new GameMaster(noOfPlayers, noOfPacks, new CommunicationFactory(), new UnoFactory()).start();
    }
}