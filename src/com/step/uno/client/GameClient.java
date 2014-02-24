package com.step.uno.client;

import com.step.communication.channel.MessageChannel;
import com.step.communication.channel.MessageChannelListener;
import com.step.communication.factory.CommunicationFactory;
import com.step.uno.messages.*;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;

public class GameClient implements MessageChannelListener {
    private CommunicationFactory factory;
    private MessageChannel channel;
    private String playerName;
    private GameClientObserver observer;

    public GameClient(CommunicationFactory factory) {
        this.factory = factory;
    }

    public void start(String playerName, String serverAddress, GameClientObserver observer) {
        this.playerName = playerName;
        this.observer = observer;
        this.channel = factory.connectTo(serverAddress, this);
        channel.startListeningForMessages(this);
        sendIntroduction();
    }

    private void sendIntroduction() {
        channel.send(Introduction.create(playerName));
    }

    public void play(Card card) {
        channel.send(new PlayCardAction(card));
    }

    public void draw() {
        channel.send(new DrawCardAction());
    }

    public void drawTwo() {
        channel.send(new DrawTwoCardAction());
    }

    public void declareUno() {
        channel.send(new DeclareUnoAction());
    }

    @Override
    public void onError(MessageChannel client, Exception e) {

    }

    @Override
    public void onMessage(MessageChannel client, Object message) {
        if (message.getClass().equals(Snapshot.class)) {
            observer.update((Snapshot) message);
        }
        if (message.getClass().equals(GameResult.class)) {
            observer.onGameOver((GameResult) message);
        }
    }

    @Override
    public void onConnectionClosed(MessageChannel client) {

    }

    public void play(Card card, Colour colour) {
        channel.send(new PlayCardAction(card,colour));
    }
}
