package com.tw.uno.master;

public class Main {
    public static void main(String[] args) {
        int packs = 1;//Integer.parseInt(args[1]);
        int totalPlayers = 2;//Integer.parseInt(args[0]);
        GameMaster master = new GameMaster(totalPlayers,packs,new UnoFactory());
        master.start();
    }
}