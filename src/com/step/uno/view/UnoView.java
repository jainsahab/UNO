package com.step.uno.view;

import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.PlayerSummary;

public class UnoView {
    private UnoViewListener listener;
    private LoginForm loginForm;
    private PlayerScreen playerScreen = new PlayerScreen();

    public UnoView(UnoViewListener listener) {
        this.listener = listener;
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
        for (Card myCard : snapshot.myCards) {
            playerScreen.addCard(myCard);
        }
        for (PlayerSummary playerSummary : snapshot.playerSummaries) {
            playerScreen.addPlayer(playerSummary);
        }
        playerScreen.updateOpenCard(snapshot.openCard);
    }
}
