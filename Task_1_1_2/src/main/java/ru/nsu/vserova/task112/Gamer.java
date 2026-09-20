package ru.nsu.vserova.task112;

public class Gamer {
    protected Hand hand = new Hand();
    private String playerName;

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return playerName;
    }
}