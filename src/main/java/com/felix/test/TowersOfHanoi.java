package com.felix.test;

import java.util.Stack;

/**
 */
public class TowersOfHanoi {
    static Tower tower1 = new Tower('A');
    static Tower tower2 = new Tower('B');
    static Tower tower3 = new Tower('C');

    public static void main(String[] args) {


        tower1.push(new Ring(4));
        tower1.push(new Ring(3));
        tower1.push(new Ring(2));
        tower1.push(new Ring(1));

        print();


        solve(4, tower1, tower2);


        print();


    }

    private static void print() {

        System.out.println("---------------------------------------------");
        System.out.println('A');
        System.out.println(tower1.rings);

        System.out.println('B');
        System.out.println(tower2.rings);

        System.out.println('C');
        System.out.println(tower3.rings);
    }

    public static void solve(int count, Tower from, Tower to) {
        if (count == 0) {
            return;
        }

        Tower spare = findSpare(from, to);



        solve(count - 1, from, spare);
        move(from, to);
        print();
        solve(count - 1, spare, to);
    }

    private static void move(Tower from, Tower to) {
        to.push(from.pop());
    }

    private static Tower findSpare(Tower from, Tower to) {
        char name = from.getName();
        char name1 = to.getName();

        if (('A' == name  &&  'B' == name1)  ||  ('B' == name  &&  'A' == name1)) {
            return tower3;
        } else if (('A' == name  &&  'C' == name1)  ||  ('C' == name  &&  'A' == name1)) {
            return tower2;
        } else {
            return tower1;
        }
    }


    static class Tower {
        char name;
        Stack<Ring> rings = new Stack<>();

        public Tower(char name) {
            this.name = name;
        }

        public void push(Ring ring) {
            rings.push(ring);
        }

        public Ring pop() {
            return rings.pop();
        }

        public char getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Tower{" +
                    "name=" + name +
                    '}';
        }
    }

    static class Ring {
        int number;

        public Ring(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "" + number;
        }
    }
}
