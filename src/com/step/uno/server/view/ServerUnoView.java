package com.step.uno.server.view;

import com.step.uno.server.controller.GameMasterController;

public class ServerUnoView{
    private GameMasterController gameMasterController;
    private MasterLogin masterLogin;

    public ServerUnoView(GameMasterController gameMasterController) {
        this.gameMasterController = gameMasterController;
    }

    public void showMasterLogin() {
        masterLogin = new MasterLogin(gameMasterController);
        masterLogin.setVisible(true);
    }
}
