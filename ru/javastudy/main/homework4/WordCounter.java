package ru.javastudy.homework4;

import java.util.*;

public class WordCounter {

    public static void main(String[] args) {
        String[] words = {
                "яблоко", "банан", "банан", "яблоко", "виноград",
                "банан", "киви", "яблоко", "груша", "апельсин",
                "гранат", "виноград", "яблоко", "банан", "слива",
                "киви", "груша", "яблоко", "гранат", "манго"
        };

        System.out.printf("\nВсе слова: %s\n", Arrays.toString(words));

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.printf("\nУникальные слова: %s\n", uniqueWords);

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        System.out.println("\nСколько раз встречается каждое слово:");
        for (Map.Entry<String, Integer> e : wordCount.entrySet()) System.out.println(e.getKey() + ": " + e.getValue() + " раз" + (e.getValue() > 1 && e.getValue() < 5 ? "а" : ""));
    }

}
