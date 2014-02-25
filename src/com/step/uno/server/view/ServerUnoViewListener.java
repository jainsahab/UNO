package com.step.uno.server.view;

public interface ServerUnoViewListener {
   public void onStart(ServerUnoView view);
   public void onJoin(int numberOfPlayers,int numberOfPacks);
}
