package ru.nsu.vserova.task112;

public enum Suit {
    Hearts("Черви"),
    Diamonds("Бубны"),
    Clubs("Крести"),
    Spades("Пики");

    private final String russianName;

    Suit(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}