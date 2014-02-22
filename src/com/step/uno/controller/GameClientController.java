package com.step.uno.controller;

import com.step.uno.client.GameClient;
import com.step.uno.client.GameClientObserver;
import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.view.UnoView;
import com.step.uno.view.UnoViewListener;

public class GameClientController implements GameClientObserver, UnoViewListener {
    private GameClient gameClient;
    private UnoView view;
    private Snapshot snapshot;

    public GameClientController(GameClient gameClient) {
        this.gameClient = gameClient;
    }

    @Override
    public void update(Snapshot snapshot) {
        this.snapshot = snapshot;
        view.updatePlayerScreen(snapshot);
    }

    @Override
    public void onGameOver(GameResult result) {
        System.out.println("i m here");
        view.hidePlayerScreen();
        view.showResult(result);
    }

    public void start(UnoView view) {
        this.view = view;
        this.view.showLoginForm();
    }

    @Override
    public void onJoin(String name, String serverAddress) {
        this.view.hideLoginForm();
        gameClient.start(name, serverAddress, this);
    }

    @Override
    public void cardPlayed(Card card) {
        gameClient.play(card);
    }

    @Override
    public void drawCard() {
        if(snapshot.draw2Run > 0)
            gameClient.drawTwo();
        gameClient.draw();
    }
}
