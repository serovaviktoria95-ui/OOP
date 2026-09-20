package ru.nsu.vserova.task112;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private  List<Card> cards = new ArrayList<>();

    public Deck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(s, r));
            }
        }
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card pull() {
        if (cards.size() <= 0) {
            throw new IllegalArgumentException();
        }
        return cards.remove(cards.size() - 1);
    }

    public int size() {
        return cards.size();
    }
}
