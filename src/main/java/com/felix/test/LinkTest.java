package com.felix.test;

/**
 */
public class LinkTest {


    public static void main(String[] args) {
        MujList mujList = create();
        System.out.println(mujList);

        mujList.reverse();
        System.out.println(mujList);

        mujList.reverseLinkedList();
        System.out.println(mujList);
    }

    private static MujList create() {

        ListItem prev = null;
        ListItem first = null;

        for (int i = 0; i < 5; i++) {
            ListItem novy = new ListItem(i);
            if (i == 0) {
                first = novy;
            }

            if (prev != null) {
                prev.next = novy;
            }

            prev = novy;
        }

        return new MujList(first);
    }


    static class MujList {
        ListItem start;

        public MujList(ListItem start) {
            this.start = start;
        }

        public void reverse() {
            ListItem current = start;
            ListItem prev = null;
            ListItem next;

            while (current != null) {
                next = current.next;
                current.next = prev;

                prev = current;
                current = next;
            }

            start = prev;

        }

        public void reverseLinkedList() {
            this.start = reverseLinkedListInner(this.start);
        }



        public ListItem reverseLinkedListInner(ListItem node) {

            if (node == null || node.next == null) {
                return node;
            }

            ListItem remaining = reverseLinkedListInner(node.next);
            node.next.next = node;
            node.next = null;
            return remaining;
        }



        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (start != null) {
                ListItem temp = start;
                do {
                    sb.append(" -> " + temp);
                    temp = temp.next;
                } while (temp != null);
            }

            return sb.toString();

        }
    }

    static class ListItem {
        int value;
        ListItem next;

        public ListItem(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }
}
