package ru.javastudy.homework3.first;

public class AnimalsCounter {

    private int catsCount;
    private int dogsCount;

    public void countAnimals(String type, Animal... animals) {
        switch (type) {
            case "cat" -> catsCount = animals.length;
            case "dog" -> dogsCount = animals.length;
        }
    }

    public int getAnimalsCount(String type) {
        return switch (type) {
            case "cat" -> catsCount;
            case "dog" -> dogsCount;
            default -> 0;
        };
    }
}
