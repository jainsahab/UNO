package com.step.programs;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.factory.UnoFactory;
import com.step.uno.server.GameMaster;
import com.step.uno.server.controller.GameMasterController;
import com.step.uno.server.view.ServerUnoView;

public class ServerApp {
    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster(new CommunicationFactory(), new UnoFactory());
        GameMasterController gameMasterController =new GameMasterController(gameMaster);
        gameMasterController.onStart(new ServerUnoView(gameMasterController));
    }
}