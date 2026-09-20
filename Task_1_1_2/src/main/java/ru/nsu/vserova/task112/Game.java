package ru.nsu.vserova.task112;

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
    private Deck deck = new Deck();

    /** Игрок. */
    private Gamer gamer = new Gamer();

    /** Комп. игрок. */
    private Dealer dealer = new Dealer();

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
        deck = new Deck();

        gamer.getHand().addCard(deck.pull());
        gamer.getHand().addCard(deck.pull());
        dealer.getHand().addCard(deck.pull());
        dealer.getHand().addCard(deck.pull());

        printHands(true);

        if (gamer.getHand().blackJack()) {
            gamerBlackjack();
            return;
        } else if (dealer.getHand().blackJack()) {
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
     * Ход дилера.
     */
    public void dealerTurn() {
        System.out.println("Ход дилера");
        System.out.println("-------");

        Card hidden = dealer.getHand().getCards().get(1);
        System.out.println("Дилер открывает закрытую карту " + hidden);
        printHands(false);

        while (dealer.dealerPulls()) {
            Card card = deck.pull();
            dealer.getHand().addCard(card);
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
        int gamerScore = gamer.getHand().score();
        int dealerScore = dealer.getHand().score();

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
            gamerWins++;
            dealerWins++;
            printScore();
        }
    }

    /**
     * Игрок берёт одну карту из колоды.
     */
    private void gamerPulls(){
        Card card = deck.pull();
        gamer.getHand().addCard(card);
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
            System.out.print(dealer.getHand().getCards().get(0));
            System.out.println(", <закрытая карта>]");
        } else {
            System.out.println("    Карты дилера: " + dealer.getHand());
        }
    }

    /**
     * Спрашивает у игрока, взять карту или остановиться.
     *
     * @return 1 — взять карту, 0 — остановиться
     */
    private int gamerChoice() {
        System.out.println("Введите “1”, чтобы взять карту, и “0”, чтобы остановиться...");
        return scanner.nextInt();
    }

    /**
     * Спрашивает, хочет ли игрок сыграть ещё раунд.
     *
     * @return {@code true}, если игрок ввёл 1
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
     * Сообщает о победе игрока и увеличивает его счёт.
     */
    private void printGamerWins() {
        gamerWins++;
        System.out.println("Счет " + gamerWins + ":" + dealerWins + " в вашу пользу.");
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