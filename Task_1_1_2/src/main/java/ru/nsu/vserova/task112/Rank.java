package ru.nsu.vserova.task112;

public enum Rank {
    Two("Двойка", 2),
    Three("Тройка", 3),
    Four("Четвёрка", 4),
    Five("Пятёрка", 5),
    Six("Шестёрка", 6),
    Seven("Семёрка", 7),
    Eight("Восьмёрка", 8),
    Nine("Девятка", 9),
    Ten("Десятка", 10),
    Jack("Валет", 10),
    Queen("Дама", 10),
    King("Король", 10),
    Ace("Туз", 11);

    private final String russianName;
    private final int value;

    Rank(String russianName, int value) {
        this.russianName = russianName;
        this.value = value;
    }

    public String getRussianName() {
        return russianName;
    }

    public int getValue() {
        return value;
    }
}
