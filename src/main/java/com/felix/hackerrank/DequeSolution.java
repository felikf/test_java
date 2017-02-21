package com.felix.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 */
public class DequeSolution {

    public static final String input = "{}()\n({()})\n{}(\n[]";

    public static void main(String[] args) {
        //        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(input).useDelimiter("\n");

        System.out.println("1");

        while (sc.hasNext()) {
            System.out.println(solutionUsingStack(sc.next()));
        }

        sc = new Scanner(input).useDelimiter("\n");
        System.out.println("2");

        while (sc.hasNext()) {
            System.out.println(solution2(sc.next()));
        }

    }


    private static boolean solutionUsingStack(String input) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            Character current = input.charAt(i);

            if (!stack.isEmpty() && matches(stack.peek(), current)) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }

        return stack.isEmpty();
    }


    private static boolean matches(char a, char b) {
        return (a == '{' && b == '}') || (a == '(' && b == ')') || (a == '[' && b == ']');
    }


    private static boolean solution2(String input) {
        while (input.length() != (input = input.replaceAll("\\(\\)|\\{\\}|\\[\\]", "")).length()) ;

        return input.isEmpty();
    }
}
