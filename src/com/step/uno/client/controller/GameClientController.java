package com.step.uno.client.controller;

import com.step.uno.client.GameClient;
import com.step.uno.client.GameClientObserver;
import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.client.view.*;
import com.step.uno.model.PlayerSummary;
import com.step.uno.model.Sign;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class GameClientController implements GameClientObserver, UnoViewListener {
    private GameClient gameClient;
    private UnoView view;
    private Snapshot snapshot;
    private Card lastPlayedCard;
    HashMap<Color, Colour> colourMap = new HashMap<>();
    private boolean isStartedNow = true;

    public GameClientController(GameClient gameClient) {
        this.gameClient = gameClient;
        colourMap.put(Color.BLUE, Colour.Blue);
        colourMap.put(Color.RED, Colour.Red);
        colourMap.put(Color.GREEN, Colour.Green);
        colourMap.put(Color.YELLOW, Colour.Yellow);
    }

    @Override
    public void update(Snapshot snapshot) {
        this.snapshot = snapshot;
        if (isStartedNow) {
            isStartedNow = false;
            this.view.hideLoginForm();
            this.view.displayPlayerScreen("UNO : " + snapshot.currentPlayerName);
        }
        this.view.updateLog(snapshot.lastActivity);
        this.view.enableClosedPile(snapshot.myPlayerIndex == snapshot.currentPlayerIndex);
        this.view.clearPlayerScreen();
        displayAllCards();
        displayAllPlayers();
        updateOpenDeck();
        updateCloseDeck();
    }

    private void updateCloseDeck() {
        String message = "Draw (1)";
        if (snapshot.draw2Run > 0) message = "Draw (" + snapshot.draw2Run + ")";
        this.view.updateCloseDeck(message);
    }

    private void updateOpenDeck() {
        this.view.updateOpenDeck(snapshot.openCard);
    }

    private void displayAllPlayers() {
        String appendString;
        PlayerSummary playerSummary;
        String cardsField;
        String playerButtonText;
        for (int i = 0; i < snapshot.playerSummaries.length; i++) {
            playerSummary = snapshot.playerSummaries[i];
            appendString = snapshot.isInAscendingOrder ? "<br/> <br/> <b> ==>> </b> " : "<br/> <br/> <b> <<== </b>";
            cardsField = playerSummary.declaredUno ? "UNO" : Integer.toString(playerSummary.cardsInHand);
            playerButtonText = "<html> <i>" + playerSummary.name + ": " + cardsField + appendString + "</i></html>";
            this.view.addPlayer(playerButtonText, snapshot.currentPlayerIndex == i);
        }
    }

    private void displayAllCards() {
        for (Card myCard : snapshot.myCards) {
            if (myCard.sign.equals(Sign.Draw4)) {
                boolean playable = isDrawFourPlayable(snapshot.runningColour);
                this.view.addCard(myCard, playable && snapshot.currentPlayerIndex == snapshot.myPlayerIndex && snapshot.openCard.isPlayableCard(myCard, snapshot.draw2Run, snapshot.runningColour));
            } else {
                this.view.addCard(myCard, snapshot.currentPlayerIndex == snapshot.myPlayerIndex && snapshot.openCard.isPlayableCard(myCard, snapshot.draw2Run, snapshot.runningColour));
            }
        }
    }


    private boolean isDrawFourPlayable(Colour runningColour) {
        for (Card myCard : snapshot.myCards) {
            if (myCard.colour.equals(runningColour))
                return false;
        }
        return true;
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
        gameClient.start(name, serverAddress, this);
    }

    @Override
    public void cardPlayed(Card card) {
        lastPlayedCard = card;
        if (card.colour.equals(Colour.Black)) {
            this.view.showChangeColorDialog();
        } else
            gameClient.play(card);
    }

    @Override
    public void drawCard() {
        if (snapshot.draw2Run > 0)
            gameClient.drawTwo();
        else
            gameClient.draw();
    }

    @Override
    public void setNewColor(Color newColor) {
        this.view.hideChangeColorDialog();
        gameClient.play(lastPlayedCard, colourMap.get(newColor));
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