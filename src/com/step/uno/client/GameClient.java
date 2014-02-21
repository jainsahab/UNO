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

    public void play(Card card, Colour newColour) {
        //don't allow WildDraw4 when running colour is present
        //don't allow colour change to last card when heading to last card
        channel.send(new PlayCardAction(card, newColour));
    }

    public void informNoActionOnDrawnCard() {
        channel.send(new NoActionOnDrawnCard());
    }

    public void draw() {
        channel.send(new DrawCardAction());
    }

    @Override
    public void onError(MessageChannel client, Exception e) {

    }

    @Override
    public void onMessage(MessageChannel client, Object message) {
        if (message.getClass().equals(Snapshot.class)) {
            observer.update((Snapshot) message);
        }
    }

    @Override
    public void onConnectionClosed(MessageChannel client) {

    }
}
