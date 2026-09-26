package ru.nsu.vserova.task112;

import java.util.ArrayList;
import java.util.List;

/**
 * Дилер - компьютерный игрок.
 */
public class Dealer extends Gamer {

    /**
     * Проверяет, должен ли дилер взять ещё карту.
     */
    public boolean dealerPulls() {
        return getHand().getScore() < 17;
    }

    /**
     * Дилер открывает скрытую карту.
     */
    public Card openHiddenCard() {
        return hand.getSecondCard();
    }

    /**
     * Дилер делает ход.
     */
    public List<Card> makeTurn(Deck deck) {
        List<Card> taken = new ArrayList<>();
        while (dealerPulls()) {
            Card card = deck.pull();
            takeCard(card);
            taken.add(card);
        }
        return taken;
    }
}
