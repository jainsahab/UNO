package com.step.uno.model;

import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private int currentPlayerIndex = 0;
    public final List<Player> players;
    private final Deck closedDeck;
    private final Deck openDeck;
    private boolean isInAscendingOrder = true;
    private Colour runningColour;
    private int draw2Run = 0;

    public int getDraw2Run() {
        return draw2Run;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public Game(int packs, List<Player> givenPlayers) {
        players = new ArrayList<>(givenPlayers);
        closedDeck = new Deck(Card.createNewPacks(packs));
        openDeck = new Deck();
    }

    public void initialize() {
        Collections.shuffle(players);
        closedDeck.shuffle();
        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                player.take(draw());
            }
        }
        Card startingCard = draw();
        openDeck.add(startingCard);
        this.runningColour = startingCard.colour;
    }

    private Card draw() {
        if (closedDeck.isEmpty()) {
            closedDeck.addAll(openDeck.drawAllButLast());
            closedDeck.shuffle();
        }
        return closedDeck.draw();
    }

    public void populate(Snapshot snapshot, Player player) {
        player.populateSelf(snapshot);
        snapshot.myPlayerIndex = players.indexOf(player);
        List<PlayerSummary> summaries = new ArrayList<>();
        for (Player p : players) {
            summaries.add(p.generateSummary());
        }
        snapshot.runningColour = this.runningColour;
        snapshot.playerSummaries = summaries.toArray(new PlayerSummary[]{});
        snapshot.currentPlayerIndex = currentPlayerIndex;
        snapshot.openCard = openDeck.lookAtLast();
        snapshot.draw2Run = this.draw2Run * 2;
    }

    public void playCard(Player player, Card card) {
        player.play(card);
        openDeck.add(card);
        this.runningColour = card.colour;
        handleDrawTwo(card);
        handleSkip(card);
        handleReverse(card);
        nextTurn();
    }

    private void handleReverse(Card card) {
        if(card.sign.equals(Sign.Reverse))
            isInAscendingOrder = !isInAscendingOrder;
    }

    private void handleSkip(Card card) {
        if(card.sign.equals(Sign.Skip))
            nextTurn();
    }

    private void handleDrawTwo(Card card) {
        if(card.sign.equals(Sign.Draw2))
            this.draw2Run++;
    }

    private void nextTurn() {
        int increment = isInAscendingOrder ? 1 : -1;
        currentPlayerIndex = currentPlayerIndex + increment + players.size();
        currentPlayerIndex %= players.size();
    }

    public Card drawCard(Player player) {
        Card newCard = draw();
        player.take(newCard);
        nextTurn();
        return newCard;
    }

    public GameResult populateResult() {
        List<PlayerResult> result = new ArrayList<>();
        for (Player player : players) {
            result.add(player.generateResult());
        }
        return new GameResult(result.toArray(new PlayerResult[]{}));
    }

    public Colour getRunningColor() {
        return runningColour;
    }

    public void drawTwoCard(Player player) {
        Card newCard;
        for (int i = 0; i < draw2Run*2; i++) {
            newCard = draw();
            player.take(newCard);
        }
        nextTurn();
    }
}
