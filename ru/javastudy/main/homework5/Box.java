package ru.javastudy.homework5;

public record Box<T, U, V>(T first, U second, V third) {

    public static void main(String[] args) {
        BoxTest.testBoxes();
    }

    public float getSum() {
        float sum = 0.0F;

        if (first instanceof Number) sum += ((Number) first).floatValue();
        if (second instanceof Number) sum += ((Number) second).floatValue();
        if (third instanceof Number) sum += ((Number) third).floatValue();

        return sum;
    }

    public static class BoxTest {
        public static void testBoxes() {
            Box<String, Float, Integer> firstBox = new Box<>("test", 5.5F, 30);
            Box<Double, Integer, String> secondBox = new Box<>(15.9D, 127, "test 2");
            Box<Long, String, Integer> thirdBox = new Box<>(99L, "test 3", 15);

            float totalSum = firstBox.getSum() + secondBox.getSum() + thirdBox.getSum();
            System.out.println("\nСумма всех переданных в коробки чисел: " + totalSum);
        }
    }
}
