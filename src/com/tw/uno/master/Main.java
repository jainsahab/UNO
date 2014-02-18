package com.tw.uno.master;

public class Main {
    public static void main(String[] args) {
        int packs = Integer.parseInt(args[1]);
        int totalPlayers = Integer.parseInt(args[0]);
        MasterServer server = new MasterServer(totalPlayers,packs,new UnoFactory());
        server.start();
    }
}