package com.step.uno.client.view;

import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;

import java.awt.*;

public class UnoView {
    private UnoViewListener listener;
    private LoginForm loginForm;
    private PlayerScreen playerScreen;
    private GameOverScreen gameOverScreen;
    private LoadingForm loadingForm;
    private ChangeColour changeColour;

    public UnoView(UnoViewListener listener) {
        this.listener = listener;
        playerScreen = new PlayerScreen(listener);
        gameOverScreen = new GameOverScreen();
        loadingForm = new LoadingForm();
    }

    public void showLoginForm() {
        loginForm = new LoginForm(listener);
        loginForm.setVisible(true);
    }

    public void hideLoginForm() {
        loginForm.setVisible(false);
        loadingForm.setVisible(true);
    }


    public void updateCloseDeck(String message) {
        playerScreen.updateCloseDeck(message);
    }

    public void hideLoadingForm() {
        loadingForm.setVisible(false);
    }

    public void displayPlayerScreen(String title) {
        playerScreen.setVisible(true);
        playerScreen.setTitle(title);
    }

<<<<<<< HEAD
    private void displayPlayers(Snapshot snapshot) {
        String appendString;
        PlayerSummary playerSummary;
        String cardsField;
        String playerButtonText;
        for (int i = 0; i < snapshot.playerSummaries.length; i++) {
            playerSummary = snapshot.playerSummaries[i];
            appendString = snapshot.isInAscendingOrder ? "<br/><br/> <b> ==>> <b/>" : "<br/><br/><b> <<== <b/>";
            cardsField = playerSummary.declaredUno ? "UNO" : Integer.toString(playerSummary.cardsInHand);
            playerButtonText = "<html>" + playerSummary.name + " " + cardsField + appendString + "</html>";
            playerScreen.updatePlayer(playerButtonText, snapshot.currentPlayerIndex == i);
        }
    }
=======
>>>>>>> be5b737688d0177a7b16174bf109bd09a8ecbe3f


    public void addCard(Card card, boolean enable) {
        playerScreen.addCard(card,enable);
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

    public void clearPlayerScreen(){
        playerScreen.clean();
    }

    public void addPlayer(String playerButtonText, boolean enable) {
        playerScreen.addPlayer(playerButtonText, enable);
    }

    public void updateOpenDeck(Card openCard) {
        playerScreen.updateOpenCard(openCard);
    }
}