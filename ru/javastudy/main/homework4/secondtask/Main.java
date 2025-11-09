package ru.javastudy.homework4.secondtask;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();

        System.out.println("Добавление записей...");
        book.add("Иванов", "+7-911-123-45-67");
        book.add("Петров", "+7-912-345-67-89");
        book.add("Сидоров", "+7-913-456-78-90");
        book.add("Иванов", "+7-914-567-89-01");
        book.add("Петров", "+7-915-678-90-12");
        book.add("Иванов", "+7-916-789-01-23");

        book.printAll();
        System.out.println();

        System.out.println("Поиск номеров...\n");

        searchEntries(book, "Иванов");
        searchEntries(book, "Петров");
        searchEntries(book, "Сидоров");
        searchEntries(book, "Кузнецов");

        System.out.println("\nРабота с однофамильцами...\n");

        book.add("Смирнов", "+7-917-890-12-34");
        book.add("Смирнов", "+7-918-901-23-45");
        book.add("Смирнов", "+7-919-012-34-56");

        searchEntries(book, "Смирнов");
        searchEntries(book, "Сидоров");

        book.printAll();

        System.out.println("\nВсего записей: " + book.getAllEntries().size());
    }

    private static void searchEntries(PhoneBookInterface book, String lastName) {
        List<String> phones = book.get(lastName);

        String result = phones.isEmpty() ? "Фамилия '" + lastName + "' не найдена в справочнике" : "Найдены номера для '" + lastName + "': " + phones;
        System.out.println(result);
    }

}
