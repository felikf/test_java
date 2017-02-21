package com.felix.test;

/**
 */
public class Strings {

    public static void main(String[] args) {

        String input = "asdfghcjfjfajjdjcjaj";

        char first = 'a';
        char last = 'c';

        int firstIndex = -1;
        int lastIndex = -1;
        int min = 1;


        for (int i = 0; i < input.length() ; i++) {
            if (input.charAt(i) == first) {
                firstIndex = i;

                if (lastIndex > -1) {
                    int distance = Math.abs(firstIndex - lastIndex);

                    if (distance <= min ) {
                        System.out.println(distance);
                    }
                }

            }

            if (input.charAt(i) == last) {
                lastIndex = i;

                if (firstIndex > -1) {
                    int distance = Math.abs(firstIndex - lastIndex);

                    if (distance <= min ) {
                        System.out.println(distance);
                    }
                }
            }

        }

    }


}
