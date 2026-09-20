package ru.nsu.vserova.task112;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public int score() {
        int sum = 0, acesCnt = 0;
        for (Card c : cards) {
            if (c.getRank() == Rank.Ace) {
                acesCnt++;
            }
            sum += c.getValue();
        }
        while ( sum > 21 && acesCnt > 0) {
            sum -= 10;
            acesCnt--;
        }
        return sum;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean tooMuch() {
        return (score() > 21);
    }

    public boolean blackJack() {
        return (cards.size() == 2 && score() == 21);
    }

    @Override
    public String toString() {
        return cards + " => " + score();
    }
}
