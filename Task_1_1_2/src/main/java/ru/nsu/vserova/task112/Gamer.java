package ru.nsu.vserova.task112;

/**
 * Пользователь.
*/
public class Gamer {

    /** Рука игрока. */
    protected Hand hand = new Hand();

    /** Имя игрока. */
    private String gamerName;

    /**
     * Возвращает руку игрока.
     *
     * @return рука
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Возвращает имя игрока.
     *
     * @return имя
     */
    public String getName() {
        return gamerName;
    }

    /**
     * Берет карту.
     */
    public void takeCard(Card card) {
        hand.addCard(card);
    }

    /**
     * Проверяет, есть ли блэкджек.
     *
     *  @return true или false
     */
    public boolean hasBlackJack() {
        return hand.blackJack();
    }
}