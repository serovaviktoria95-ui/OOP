package ru.nsu.vserova.task112;

public class Dealer extends Gamer {
    public boolean dealerPulls() {
        return getHand().score() < 17;
    }
}
