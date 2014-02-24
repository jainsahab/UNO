package com.step.programs;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.GameClient;
import com.step.uno.client.controller.GameClientController;
import com.step.uno.client.view.UnoView;

public class ClientApp {
    public static void main(String[] args) {
        GameClient gameClient = new GameClient(new CommunicationFactory());
        GameClientController gameClientController = new GameClientController(gameClient);
        gameClientController.start(new UnoView(gameClientController));
    }
}