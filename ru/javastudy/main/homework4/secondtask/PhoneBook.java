package ru.javastudy.homework4.secondtask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook implements PhoneBookInterface {
    private final Map<String, List<String>> directory = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        if (lastName == null || lastName.isEmpty()) throw new IllegalArgumentException("Фамилия не может быть пустой");
        if (phoneNumber == null || phoneNumber.isEmpty()) throw new IllegalArgumentException("Номер телефона не может быть пустым");

        lastName = formatLastName(lastName);
        directory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) return new ArrayList<>();

        lastName = formatLastName(lastName);
        return directory.getOrDefault(lastName, new ArrayList<>());
    }

    public Map<String, List<String>> getAllEntries() {
        Map<String, List<String>> copy = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : directory.entrySet())
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));

        return copy;
    }

    private String formatLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) return lastName;

        return lastName.substring(0, 1).toUpperCase() +
                lastName.substring(1).toLowerCase();
    }

    public void printAll() {
        if (directory.isEmpty()) {
            System.out.println("Телефонный справочник пуст");
            return;
        }

        System.out.println("\nТелефонный справочник:\n");

        for (Map.Entry<String, List<String>> entry : directory.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }

}
