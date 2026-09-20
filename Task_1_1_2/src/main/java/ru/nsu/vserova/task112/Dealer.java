package ru.nsu.vserova.task112;

/**
 * Дилер - компьютерный игрок.
 */
public class Dealer extends Gamer {
    /**
     * Проверяет, должен ли дилер взять ещё карту.
     *
     * @return {@code true}, если дилер должен взять карту
     */
    public boolean dealerPulls() {
        return getHand().score() < 17;
    }
}
