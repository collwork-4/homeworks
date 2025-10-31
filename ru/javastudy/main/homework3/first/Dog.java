package ru.javastudy.homework3.first;

public class Dog extends Animal {
    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
    }

    public void run(int distance) {
        if (distance > getMaxRunDistance()) {
            System.out.printf("\n%s не сможет пробежать дальше чем на %dм.", getName(), getMaxRunDistance());
            return;
        }

        System.out.printf("\n%s пробежал %d м.", getName(), distance);
    }

    public void swim(int distance) {
        if (distance > getMaxSwimDistance()) {
            System.out.printf("\n%s не сможет проплыть дальше чем на %dм.", getName(), getMaxSwimDistance());
            return;
        }

        System.out.printf("\n%s проплыл %d м.", getName(), distance);
    }

}
