package com.felix.test;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        boolean isEven = (i % 2) == 0;   //sudy
        boolean isOdd = !isEven;         //lichy

        if (isOdd  ||  (isEven &&  i>= 6 &&  i <= 20)) {
            System.out.println("Weird");
        }

        if (isEven &&  ((i>= 2  &&  i <= 5)  ||  i > 20)) {
            System.out.println("Not weird");
        }

    }
}