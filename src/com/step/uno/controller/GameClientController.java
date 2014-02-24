package com.step.uno.controller;

import com.step.uno.client.GameClient;
import com.step.uno.client.GameClientObserver;
import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.view.UnoView;
import com.step.uno.view.UnoViewListener;

import java.awt.*;
import java.util.HashMap;

public class GameClientController implements GameClientObserver, UnoViewListener {
    private GameClient gameClient;
    private UnoView view;
    private Snapshot snapshot;
    private Card lastPlayedCard;
    HashMap<Color,Colour> colourMap = new HashMap<>();

    public GameClientController(GameClient gameClient) {
        this.gameClient = gameClient;
        colourMap.put(Color.BLUE,Colour.Blue);
        colourMap.put(Color.RED,Colour.Red);
        colourMap.put(Color.GREEN,Colour.Green);
        colourMap.put(Color.YELLOW,Colour.Yellow);
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
        lastPlayedCard = card;
        if(card.colour.equals(Colour.Black)) {
            this.view.showChangeColorDialog();
        }
        else
            gameClient.play(card);
    }

    @Override
    public void drawCard() {
        if(snapshot.draw2Run > 0)
            gameClient.drawTwo();
        else
            gameClient.draw();
    }

    @Override
    public void setNewColor(Color newColor) {
        this.view.hideChangeColorDialog();
        gameClient.play(lastPlayedCard,colourMap.get(newColor));
    }
}