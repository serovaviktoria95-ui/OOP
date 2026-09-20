package ru.nsu.vserova.task112;

import java.util.ArrayList;
import java.util.List;

/**
 * Набор карт.
 *
 * <p>Считает сумму очков с учётом тузов: туз = 11, но
 * при переборе понижается до 1. Определяет блэкджек
 * и перебор.</p>
 */
public class Hand {

    /** Карты в руке. */
    private List<Card> cards = new ArrayList<>();

    /**
     * Возвращает список карт в руке.
     *
     * @return список карт
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Считает сумму очков с учётом тузов.
     *
     * @return сумма очков
     */
    public int score() {
        int sum = 0, acesCnt = 0;
        for (Card c : cards) {
            if (c.getRank() == Rank.Ace) {
                acesCnt++;
            }
            sum += c.getValue();
        }
        while (sum > 21 && acesCnt > 0) {
            sum -= 10;
            acesCnt--;
        }
        return sum;
    }

    /**
     * Добавляет карту в руку.
     *
     * @param card карта
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Проверяет, не превышает ли сумма 21.
     *
     * @return {@code true}, если перебор
     */
    public boolean tooMuch() {
        return (score() > 21);
    }

    /**
     * Проверяет блэкджек.
     *
     * @return {@code true}, если блэкджек
     */
    public boolean blackJack() {
        return (cards.size() == 2 && score() == 21);
    }

    /**
     * Возвращает строковое представление руки.
     *
     * @return строка с картами и суммой
     */
    @Override
    public String toString() {
        return cards + " => " + score();
    }
}