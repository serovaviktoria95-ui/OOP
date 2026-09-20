package ru.nsu.vserova.task112;

/**
 * Масть карты.
 *
 * <p>Содержит четыре масти: черви, бубны, крести, пики.
 * Каждая масть хранит русское название для вывода.</p>
 */
public enum Suit {

    /** Черви. */
    Hearts("Черви"),

    /** Бубны. */
    Diamonds("Бубны"),

    /** Крести. */
    Clubs("Крести"),

    /** Пики. */
    Spades("Пики");

    /** Русское название масти. */
    private final String russianName;

    /**
     * Создаёт масть с русским названием.
     *
     * @param russianName русское название
     */
    Suit(String russianName) {
        this.russianName = russianName;
    }

    /**
     * Возвращает русское название масти.
     *
     * @return русское название
     */
    public String getRussianName() {
        return russianName;
    }
}