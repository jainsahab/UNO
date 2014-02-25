package com.step.uno.client.view;

import com.step.uno.client.ClientPlayer;
import com.step.uno.messages.GameResult;
import com.step.uno.model.Card;

import java.awt.*;

public class UnoView {
    private UnoViewListener listener;
    private LoginForm loginForm;
    private PlayerScreen playerScreen;
    private GameOverScreen gameOverScreen;
    private ChangeColour changeColour;

    public UnoView(UnoViewListener listener) {
        this.listener = listener;
        playerScreen = new PlayerScreen(listener);
        gameOverScreen = new GameOverScreen();
    }

    public void showLoginForm() {
        loginForm = new LoginForm(listener);
        loginForm.setVisible(true);
    }
    public void updateCloseDeck(String message) {
        playerScreen.updateCloseDeck(message);
    }

    public void hideLoginForm() {
        loginForm.setVisible(false);

    }

    public void displayPlayerScreen(String title) {
        playerScreen.setVisible(true);
        playerScreen.setTitle(title);
    }

    public void addCard(Card card, boolean enable) {
        playerScreen.addCard(card, enable);
    }

    public void showResult(GameResult result) {
        gameOverScreen.showResult(result);
    }

    public void hidePlayerScreen() {
        playerScreen.setVisible(false);
    }

    public void showChangeColorDialog() {
        changeColour = new ChangeColour(playerScreen, Dialog.ModalityType.DOCUMENT_MODAL, listener);
        changeColour.makeVisible();
    }


    public void hideChangeColorDialog() {
        changeColour.makeInvisible();
    }

    public void updateLog(String currentLog) {
        playerScreen.updateLog(currentLog);
    }

    public void enableClosedPile(boolean enable) {
        playerScreen.enableClosedPile(enable);
    }

    public void clearPlayerScreen() {
        playerScreen.clean();
    }

    public void addPlayer(String playerButtonText, boolean enable, ClientPlayer player) {
        playerScreen.addPlayer(playerButtonText, enable, player);
    }

    public void updateOpenDeck(Card openCard) {
        playerScreen.updateOpenCard(openCard);
    }
}