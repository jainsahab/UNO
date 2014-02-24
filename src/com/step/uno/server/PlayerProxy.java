package com.step.uno.server;

import com.step.communication.channel.MessageChannel;
import com.step.communication.channel.MessageChannelListener;
import com.step.uno.messages.*;
import com.step.uno.model.Card;
import com.step.uno.model.Game;
import com.step.uno.model.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PlayerProxy implements MessageChannelListener {
    private MessageChannel channel;
    private PlayerProxyObserver observer;
    private Player player;

    public PlayerProxy(MessageChannel channel, PlayerProxyObserver observer) {
        this.channel = channel;
        this.observer = observer;
    }

    public void start() {
        channel.startListeningForMessages(this);
    }

    @Override
    public void onError(MessageChannel client, Exception e) {

    }

    private void onClientMessage(Introduction introduction) {
        this.player = new Player(introduction.playerName);
        observer.onPlayerRegistered(this.player);
    }

    private void onClientMessage(PlayCardAction playCard) {
        observer.onPlayerPlayed(player, playCard.card, playCard.newColour);
    }

    private void onClientMessage(DrawCardAction drawCard) {
        observer.onPlayerDrewCard(player);
    }

    private void onClientMessage(DrawTwoCardAction drawCard) {
        observer.onPlayerDrewTwoCard(player);
    }
    private void onClientMessage(DeclareUnoAction declareUnoAction) {
        observer.onPlayerDeclaredUno(player);
    }


    @Override
    public void onMessage(MessageChannel client, Object message) {
        try {
            Method method = this.getClass().getDeclaredMethod("onClientMessage", message.getClass());
            method.invoke(this, message);
        } catch (NoSuchMethodException e) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onConnectionClosed(MessageChannel client) {

    }

    public void sendSnapshot(Game game) {
        Snapshot snapshot = Snapshot.createSnapshot();
        game.populate(snapshot, player);
        channel.send(snapshot);
    }

    public void sendResultSnapshot(GameResult result) {
        channel.send(result);
    }
}