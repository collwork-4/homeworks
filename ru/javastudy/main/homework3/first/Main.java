package ru.javastudy.homework3.first;

public class Main {

    private static final AnimalsCounter ANIMALS_COUNTER = new AnimalsCounter();

    public static void main(String[] args) {
        Cat cat1 = new Cat("Кот 1", 200, 0);
        Cat cat2 = new Cat("Кот 2", 200, 0);

        Dog dog = new Dog("Собака", 500, 10);

        ANIMALS_COUNTER.countAnimals("cat", cat1, cat2);
        ANIMALS_COUNTER.countAnimals("dog", dog);

        System.out.printf(
                "\nКоличество котов: %d \nКоличество собак: %d\n",
                ANIMALS_COUNTER.getAnimalsCount("cat"),
                ANIMALS_COUNTER.getAnimalsCount("dog")
        );

        cat1.run(149);
        cat2.swim(20);

        dog.run(600);
    }

}
