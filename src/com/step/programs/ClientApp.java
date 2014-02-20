package com.step.programs;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.GameClient;
import com.step.uno.controller.Controller;
import com.step.uno.view.UnoView;

public class ClientApp {
    public static void main(String[] args) {
        GameClient gameClient = new GameClient(new CommunicationFactory());
        Controller controller = new Controller(gameClient);
        controller.start(new UnoView(controller));
    }

}
