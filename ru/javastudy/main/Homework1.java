package ru.javastudy.main;

public class Homework1 {

    // задание 1
    private byte a = 127;
    private short s = 32000;
    private int i = 99999999;
    private float f = 5.0F;
    private double d = 15.0D;
    private long l = 1000000000000L;

    private String str = "Hello world!";
    private char c = 'a';
    private boolean bool = false;

    private void greetUser(String name) { // задание 2
        System.out.println("Привет, " + name);
    }

    private boolean isNumberNegative(int num) { // задание 3
        return num < 0;
    }

    private void printNumberSign(int num) { // задание 4
        System.out.println(num > 0 ? num + " положительное число." : num + " отрицательное число.");
    }

    private void printMultipleNumbers() { // задание 5
        for (int i = 1000; i >= 0; i--)
            if (i % 3 == 0) System.out.println(i);
    }

    public static void main(String[] args) {
        Homework1 homework = new Homework1();

        homework.greetUser("Артём");
        System.out.println(homework.isNumberNegative(-15));
        homework.printNumberSign(20);
        homework.printMultipleNumbers();
    }

}
