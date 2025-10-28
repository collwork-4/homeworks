package ru.javastudy.main;

import java.util.Random;
import java.util.Scanner;

public class Homework2 {

    private final int ATTEMPTS_VALUE = 3;
    private int randomNumber;
    private int userNumber;
    private int attempts;

    private final Random random = new Random();
    private final Scanner scanner;

    public Homework2() {
        this.scanner = new Scanner(System.in);
        this.attempts = ATTEMPTS_VALUE;
    }

    private void generateNumber() {
        this.randomNumber = random.nextInt(10);
    }

    private void startAttempt() {
        System.out.print("Введите число: ");
        userNumber = scanner.nextInt();
        scanner.nextLine();

        checkResult();
    }

    private void endGame(boolean isWin, int num) {
        System.out.print(isWin ? ("Число угадано: " + num + ".") : ("Попытки закончились. Правильное число: " + randomNumber));
        System.out.print(" Повторить игру еще раз? 1 - да/0 - нет ");

        int input = scanner.nextInt();
        scanner.nextLine();

        if (input == 1) {
            attempts = ATTEMPTS_VALUE;
            generateNumber();
            startAttempt();
        } else if (input == 0) {
            System.exit(0);
        }
    }

    private void checkResult() {
        if (randomNumber == userNumber) {
            endGame(true, userNumber);
            return;
        } else if (attempts <= 1) {
            endGame(false, userNumber);
        }

        attempts--;

        boolean isLower = randomNumber < userNumber;

        String state = isLower ? "меньше" : "больше";
        String result = "Загаданное число " + state + " чем " + userNumber + ". Осталось попыток: " + attempts;

        System.out.println(result);
        startAttempt();
    }

    public static void main(String[] args) {
        Homework2 hw2 = new Homework2();
        hw2.generateNumber();
        hw2.startAttempt();
    }

}
