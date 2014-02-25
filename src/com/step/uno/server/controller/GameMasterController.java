package com.step.uno.server.controller;

import com.step.uno.server.GameMaster;
import com.step.uno.server.view.ServerUnoView;
import com.step.uno.server.view.ServerUnoViewListener;

public class GameMasterController implements ServerUnoViewListener {
    private ServerUnoView view;
    private GameMaster gameMaster;

    public GameMasterController(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
    }

    @Override
    public void onStart(ServerUnoView view) {

        this.view = view;
        view.showMasterLogin();

    }
    public void onJoin(int numberOfPlayers,int numberOfPacks){
        gameMaster.start(numberOfPlayers,numberOfPacks);
    }
}
