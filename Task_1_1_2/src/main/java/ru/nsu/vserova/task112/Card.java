package ru.nsu.vserova.task112;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit s, Rank r) {
        suit = s;
        rank = r;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return rank.getValue();
    }
    @Override
    public String toString() {
        return rank.getRussianName() + " " + suit.getRussianName() + " (" + getValue() + ")";
    }
}
