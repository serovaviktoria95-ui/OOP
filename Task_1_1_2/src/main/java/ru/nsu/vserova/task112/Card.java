package ru.nsu.vserova.task112;

/**
 * Одна игральная карта.
 *
 * <p>Объединяет масть и достоинство.</p>
 */
public class Card {

    /** Масть карты. */
    private Suit suit;

    /** Достоинство карты. */
    private Rank rank;

    /**
     * Создаёт карту.
     *
     * @param s масть
     * @param r достоинство
     */
    public Card(Suit s, Rank r) {
        suit = s;
        rank = r;
    }

    /**
     * Возвращает масть карты.
     *
     * @return масть
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Возвращает достоинство карты.
     *
     * @return достоинство
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Возвращает значение очков карты.
     *
     * @return значение очков
     */
    public int getValue() {
        return rank.getValue();
    }

    /**
     * Возвращает строковое представление карты.
     *
     * @return строка вида Достоинство масть очки
     */
    @Override
    public String toString() {
        return rank.getRussianName() + " " + suit.getRussianName() + " (" + getValue() + ")";
    }
}
