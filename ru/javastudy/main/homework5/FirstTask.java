package ru.javastudy.homework5;

import java.util.Arrays;

public class FirstTask {

    public static void main(String[] args) {
        Integer[] nums = { 1, 2, 3, 4, 5 };

        swapElements(nums, 2, 4);

        System.out.println(Arrays.toString(nums));
    }

    public static <T> void swapElements(T[] array, int in1, int in2) {
        if (
                array == null
                || in1 < 0
                || in1 > array.length
                || in2 < 0
                || in2 > array.length
        ) throw new IllegalArgumentException();

        T arr = array[in1];

        array[in1] = array[in2];
        array[in2] = arr;
    }

}
