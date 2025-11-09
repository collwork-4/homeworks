package ru.javastudy.homework4.secondtask;

import java.util.List;
import java.util.Map;

public interface PhoneBookInterface {

    void add(String lastName, String phoneNumber);

    List<String> get(String lastName);

    Map<String, List<String>> getAllEntries();

}
