package com.step.uno.view;

import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.rules.RuleEngine;

public class UnoView {
    private UnoViewListener listener;
    private LoginForm loginForm;
    private PlayerScreen playerScreen;
    private GameOverScreen gameOverScreen;
    private LoadingForm loadingForm;
    private boolean isStartedNow = true;

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

    public void updatePlayerScreen(Snapshot snapshot) {
        onStart(snapshot);
        playerScreen.updateLog(snapshot.lastActivity);
        playerScreen.setClosedPile(snapshot.myPlayerIndex == snapshot.currentPlayerIndex);
        playerScreen.clean();
        displayAllCards(snapshot);
        displayPlayers(snapshot);
        updateOpenDeck(snapshot);
        updateCloseDeck(snapshot);
    }

    private void updateCloseDeck(Snapshot snapshot) {
        String message = "Draw 1";
        if(snapshot.draw2Run > 0) message = "Draw " + snapshot.draw2Run;
        playerScreen.updateCloseDeck(message);
    }

    private void onStart(Snapshot snapshot) {
        if (isStartedNow) {
            isStartedNow = false;
            loadingForm.setVisible(false);
            playerScreen.setVisible(true);
            playerScreen.setTitle("UNO : " + snapshot.currentPlayerName);
        }
    }

    private void updateOpenDeck(Snapshot snapshot) {
        playerScreen.updateOpenCard(snapshot.openCard);
    }

    private void displayPlayers(Snapshot snapshot) {
        for (int i = 0; i < snapshot.playerSummaries.length; i++) {
            String appendString = snapshot.isInAscendingOrder ?"==>":"<==";
            playerScreen.updatePlayer(snapshot.playerSummaries[i], snapshot.currentPlayerIndex == i,appendString);
        }
    }

    private void displayAllCards(Snapshot snapshot) {
        RuleEngine ruleEngine = new RuleEngine();
        for (Card myCard : snapshot.myCards) {
            playerScreen.addCard(myCard, snapshot.currentPlayerIndex == snapshot.myPlayerIndex && ruleEngine.isPlayableCard(snapshot, myCard));
        }
    }

    public void showResult(GameResult result) {
        gameOverScreen.showResult(result);
    }

    public void hidePlayerScreen() {
        playerScreen.setVisible(false);
    }
}