package com.step.uno.controller;

import com.step.uno.client.GameClient;
import com.step.uno.client.GameClientObserver;
import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.view.*;

import java.awt.event.ActionEvent;

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
        if (snapshot.draw2Run > 0)
            gameClient.drawTwo();
        else
            gameClient.draw();
    }

    private void declaredUno() {
        if (snapshot.myCards.length == 1) {
            gameClient.declareUno();
        }
    }

    @Override
    public void onAction(ActionEvent e) {
        Object source = e.getSource();
        if (source.getClass().equals(CardButton.class)) {
            cardPlayed(((CardButton) source).getCard());
        }
        if (source.getClass().equals(ClosedPile.class)) {
            drawCard();
        }
        if (source.getClass().equals(UnoButton.class)) {
            declaredUno();
        }
    }
}
