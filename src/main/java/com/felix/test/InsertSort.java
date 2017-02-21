package com.felix.test;

import java.util.Arrays;

/**
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] numbers = new int[] {-3, 0, 5, 2, 9, 6, -1};

        System.out.println(Arrays.toString(numbers));

        sort(numbers);

        System.out.println(Arrays.toString(numbers));


    }

    private static void sort(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {
            insert(numbers, i - 1, numbers[i]);
        }

    }

    private static void insert(int[] numbers, int rightIndex, int value) {
        int i = rightIndex;

        for (i = rightIndex; i > 0  &&  numbers[i] > value; i--) {
            numbers[i + 1] = numbers[i];
        }

        numbers[i + 1] = value;
    }

}
