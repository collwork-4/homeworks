package ru.javastudy.homework5;

import java.util.Scanner;

public class ThirdTask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите строку: ");
        String input = sc.nextLine();

        try {
            validateString(input);
            System.out.println("Строка не содержит ошибок.");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void validateString(String str) {
        if (str == null) return;

        for (char c : str.toCharArray())
            if (Character.isDigit(c)) throw new IllegalArgumentException("Строка не должна содержать число.");
    }

}
