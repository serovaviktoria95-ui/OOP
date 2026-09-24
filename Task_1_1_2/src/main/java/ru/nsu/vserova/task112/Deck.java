package ru.nsu.vserova.task112;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Колода из 52 игральных карт.
 *
 * <p>Создаёт все комбинации масть-достоинство</p>
 */
public class Deck {

    /** Карты в колоде. */
    private  List<Card> cards = new ArrayList<>();

    /**
     * Создаёт колоду из 52 карт и перемешивает её.
     */
    public Deck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(s, r));
            }
        }
        Random random = new Random();
        Collections.shuffle(cards);
    }

    /**
     * Выдаёт верхнюю карту из колоды.
     *
     * @return карта
     * @throws IllegalArgumentException если колода пуста
     */
    public Card pull() {
        if (cards.size() <= 0) {
            throw new IllegalArgumentException();
        }
        return cards.remove(cards.size() - 1);
    }

    /**
     * Возвращает количество карт в колоде.
     *
     * @return количество карт
     */
    public int size() {
        return cards.size();
    }
}
