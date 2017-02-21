package com.felix.test;

import java.util.Arrays;

/**
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] array = new int[] {2, 8, 5, 7, 0, 9, -1};

        half(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }

    private static void half(int[] array, int p, int r) {
        if (p < r) {
            int q = ((r + p) / 2);

            print(array, p, r);

            half(array, p, q);
            half(array, q + 1, r);

//            mergeParts(array, p, q, r);
        }
    }

    private static void mergeParts(int[] array, int lowerIndex, int middle, int higherIndex) {
        int[] tempMergArr = new int[array.length];


        System.out.println("Before merge: ");
        print(array, lowerIndex, higherIndex);

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

        while (j <= higherIndex) {
            array[k] = tempMergArr[j];
            k++;
            j++;
        }


        System.out.println("After merge: ");
        print(array, lowerIndex, higherIndex);
        System.out.println();
    }

    private static void print(int[] array, int p, int r) {
        for (int i = p; i <= r; i++) {
            System.out.print(array[i]);


            if (i < r) {
                System.out.print("  |  ");
            }
        }

//        System.out.print("   " + ", p: " + p + ", r: " + r);
        System.out.print("   ");

        System.out.println();
    }

}
