package com.step.uno.view;

import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;

public class UnoView {
    private UnoViewListener listener;
    private LoginForm loginForm;
    private PlayerScreen playerScreen;

    public UnoView(UnoViewListener listener) {
        this.listener = listener;
        playerScreen = new PlayerScreen(listener);
    }

    public void showLoginForm() {
        loginForm = new LoginForm(listener);
        loginForm.setVisible(true);
    }

    public void hideLoginForm() {
        loginForm.setVisible(false);
    }

    public void updatePlayerScreen(Snapshot snapshot) {
        playerScreen.setVisible(true);
        playerScreen.clean();
        displayAllCards(snapshot);
        displayPlayers(snapshot);
        updateOpenDeck(snapshot);
    }

    private void updateOpenDeck(Snapshot snapshot) {
        playerScreen.updateOpenCard(snapshot.openCard);
    }

    private void displayPlayers(Snapshot snapshot) {
        for (int i = 0; i < snapshot.playerSummaries.length; i++) {
            playerScreen.addPlayer(snapshot.playerSummaries[i], snapshot.currentPlayerIndex == i);
        }
    }

    private void displayAllCards(Snapshot snapshot) {
        for (Card myCard : snapshot.myCards) {
            playerScreen.addCard(myCard, snapshot.currentPlayerIndex == snapshot.myPlayerIndex);
        }
    }
}