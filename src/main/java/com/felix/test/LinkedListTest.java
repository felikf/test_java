package com.felix.test;

/**
 */
public class LinkedListTest {

    public static void main(String[] args) {

        MujList mujList = create();

        printList(mujList);

        mujList.reverse();

        System.out.println();

        printList(mujList);

    }

    private static void printList(MujList list) {
        Node n = list.start;

        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }

    }

    private static MujList create() {
        MujList mujList = new MujList();

        Node prev = null;
        for (int i = 0; i < 5; i++) {
            Node n = new Node(i);

            if (prev != null) {
                prev.next = n;
            }
            prev = n;

            if (mujList.start == null) {
                mujList.start = n;
            }
        }

        return mujList;
    }

    static class MujList {
        Node start;


        public void reverse() {

            Node current = start;

            Node next = null;
            Node prev = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;

                current = next;
            }

            start = prev;
        }
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
