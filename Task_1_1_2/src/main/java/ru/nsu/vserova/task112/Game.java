package ru.nsu.vserova.task112;

import java.util.List;
import java.util.Scanner;

/**
 * Игра.
 */
public class Game {

    /** Чтение ввода с клавиатуры. */
    private Scanner scanner = new Scanner(System.in);

    /** Номер текущего раунда. */
    private int roundCnt = 1;

    /** Победы игрока. */
    private int gamerWins = 0;

    /** Победы дилера. */
    private int dealerWins = 0;

    /** Колода. */
    private Deck deck;

    /** Игрок. */
    private Gamer gamer;

    /** Комп. игрок. */
    private Dealer dealer;

    public Game() {
        this(new Deck());
    }

    public Game(Deck deck) {   // ← есть?
        this.deck = deck;
        this.gamer = new Gamer();
        this.dealer = new Dealer();
    }

    /**
     * Главный цикл игры.
     */
    public void play() {
        System.out.println("Добро пожаловать в Блэкджек!");

        while (true) {
            newRound();

            if (!again()) {
                break;
            }
            roundCnt++;
        }
        printFinalScore();
    }

    /**
     * Один раунд игры.
     *
     * <p>Раздаёт карты, проверяет блэкджеки, ход игрока,
     * ход дилера, определяет победителя.</p>
     */
    private void newRound() {
        System.out.println("Раунд " + roundCnt);
        System.out.println("Дилер раздал карты");

        gamer = new Gamer();
        dealer = new Dealer();

        dealCards();

        printHands(true);

        if (gamer.hasBlackJack()) {
            gamerBlackjack();
            return;
        } else if (dealer.hasBlackJack()) {
            dealerBlackjack();
            return;
        }

        gamerTurn();

        if (gamer.getHand().tooMuch()) {
            System.out.println("Перебор! Дилер выиграл раунд.");
            dealerWins++;
            printScore();
            return;
        }

        dealerTurn();
        winner();
    }

    /**
     * Возвращает номер текущего раунда.
     */
    public int getRoundCnt() {
        return roundCnt;
    }

    /**
     * Дилер раздает по 2 карты.
     */
    private void dealCards() {
        gamer.takeCard(deck.pull());
        gamer.takeCard(deck.pull());
        dealer.takeCard(deck.pull());
        dealer.takeCard(deck.pull());
    }

    /**
     * Ход дилера.
     */
    public void dealerTurn() {
        System.out.println("Ход дилера");
        System.out.println("-------");

        Card hidden = dealer.openHiddenCard();
        System.out.println("Дилер открывает закрытую карту " + hidden);
        printHands(false);

        List<Card> taken = dealer.makeTurn(deck);
        for (Card card : taken) {
            System.out.println("Дилер открывает карту " + card);
            printHands(false);
        }
    }

    /**
     * Ход пользователя.
     */
    private void gamerTurn() {
        System.out.println("Ваш ход");
        System.out.println("-------");

        while (true) {
            int choice = gamerChoice();

            if (choice == 0) {
                return;
            }

            gamerPulls();

            if (gamer.getHand().tooMuch()) {
                return;
            }
        }
    }

    /**
     * Победитель.
     */
    public void winner() {
        int gamerScore = gamer.getHand().getScore();
        int dealerScore = dealer.getHand().getScore();

        if (dealer.getHand().tooMuch()) {
            System.out.println("У дилера перебор! Вы выиграли раунд!");
            gamerWins++;
            printScore();
        } else if (gamerScore > dealerScore) {
            printGamerWins();
        } else if (dealerScore > gamerScore) {
            printDealerWins();
        } else {
            System.out.println("Ничья!");
            printScore();
        }
    }

    /**
     * Игрок берёт одну карту из колоды.
     */
    private void gamerPulls() {
        Card card = deck.pull();
        gamer.takeCard(card);
        System.out.println("Вы открыли карту " + card);
        printHands(true);
    }

    /**
     * Выводит карты игрока и дилера.
     */
    public void printHands(boolean hideDealerCard) {
        System.out.println("    Ваши карты: " + gamer.getHand());

        if (hideDealerCard) {
            System.out.print("    Карты дилера: [");
            System.out.print(dealer.getHand().getFirstCard());
            System.out.println(", <закрытая карта>]");
        } else {
            System.out.println("    Карты дилера: " + dealer.getHand());
        }
    }

    /**
     * Спрашивает у игрока, взять карту или остановиться.
     */
    private int gamerChoice() {
        System.out.println("Введите “1”, чтобы взять карту, и “0”, чтобы остановиться...");
        return scanner.nextInt();
    }

    /**
     * Спрашивает, хочет ли игрок сыграть ещё раунд.
     */
    private boolean again() {
        System.out.println("Ещё раунд? (1 - да, 0 - нет)");
        return scanner.nextInt() == 1;
    }

    /**
     * Сообщает о блэкджеке игрока и увеличивает его счёт.
     */
    private void gamerBlackjack() {
        System.out.println("У вас блэкджек! Вы выиграли раунд!");
        gamerWins++;
    }

    /**
     * Возвращает игрока.
     */
    public Gamer getGamer() {
        return gamer;
    }

    /**
     * Возвращает дилера.
     */
    public Dealer getDealer() {
        return dealer;
    }

    /**
     * Сообщает о блэкджеке дилера и увеличивает его счёт.
     */
    private void dealerBlackjack() {
        System.out.println("У дилера блэкджек! Дилер выиграл раунд.");
        dealerWins++;
    }

    /**
     * Сообщает о победе дилера и увеличивает его счёт.
     */
    private void printDealerWins() {
        System.out.println("Дилер выиграл раунд.");
        dealerWins++;
        printScore();
    }

    /**
     * Возвращает количество побед дилера.
     */
    public int getDealerWins() {
        return dealerWins;
    }

    /**
     * Сообщает о победе игрока и увеличивает его счёт.
     */
    private void printGamerWins() {
        gamerWins++;
        System.out.println("Счет " + gamerWins + ":" + dealerWins + " в вашу пользу.");
    }

    /**
     * Возвращает количество побед игрока.
     */
    public int getGamerWins() {
        return gamerWins;
    }

    /**
     * Выводит текущий счёт.
     */
    private void printScore() {
        System.out.println("Счет " + gamerWins + ":" + dealerWins);
    }

    /**
     * Выводит финальный счёт после завершения игры.
     */
    private void printFinalScore() {
        System.out.println("Игра завершена. Финальный счёт: " + gamerWins + ":" + dealerWins);
    }
}