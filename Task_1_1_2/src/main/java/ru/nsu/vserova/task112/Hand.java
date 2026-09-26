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
    private int score = 0;

    /**
     * Возвращает первую карту.
     */
    public Card getFirstCard() {
        return cards.get(0);
    }

    /**
     * Возвращает вторую карту.
     */
    public Card getSecondCard() {
        return cards.get(1);
    }

    /**
     * Пересчитывает количество очков.
     */
    private void calculateScore() {
        int sum = 0;
        int acesCnt = 0;
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
        score = sum;
    }
    /**
     * Считает сумму очков с учётом тузов.
     *
     * @return сумма очков
     */

    public int getScore() {
        return score;
    }

    /**
     * Добавляет карту в руку.
     *
     * @param card карта
     */
    public void addCard(Card card) {
        cards.add(card);
        calculateScore();
    }

    /**
     * Проверяет, не превышает ли сумма 21.
     */
    public boolean tooMuch() {
        return (score > 21);
    }

    /**
     * Проверяет блэкджек.
     *
     */
    public boolean blackJack() {
        return (cards.size() == 2 && score == 21);
    }

    /**
     * Возвращает строковое представление руки.
     *
     * @return строка с картами и суммой
     */
    @Override
    public String toString() {
        return cards + " => " + score;
    }
}