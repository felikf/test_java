package com.felix.hackerrank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PriorityQueueSolution {

    private static String input = "12\n" +
                    "ENTER John 3.75 50\n" +
                    "ENTER Mark 3.8 24\n" +
                    "ENTER Shafaet 3.7 35\n" +
                    "SERVED\n" +
                    "SERVED\n" +
                    "ENTER Samiha 3.85 36\n" +
                    "SERVED\n" +
                    "ENTER Ashley 3.9 42\n" +
                    "ENTER Maria 3.6 46\n" +
                    "ENTER Anik 3.95 49\n" +
                    "ENTER Dan 3.95 50\n" +
                    "SERVED\n";


    private static String input1 = "21\n" +
            "ENTER Bidhan 3.75 50\n" +
            "ENTER Rijul 3.8 24\n" +
            "ENTER Shafaet 3.7 35\n" +
            "SERVED\n" +
            "SERVED\n" +
            "ENTER Samiha 3.85 36\n" +
            "SERVED\n" +
            "ENTER Ratul 3.9 42\n" +
            "ENTER Tanvir 3.6 46\n" +
            "ENTER Anik 3.95 49\n" +
            "ENTER Nisha 3.95 50\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED";

    private static String input2 = "30\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED\n" +
            "SERVED";

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(input2).useDelimiter("\n");


        int totalEvents = Integer.parseInt(in.nextLine());

        Queue<Student> queue = new PriorityQueue<>(
                Comparator
                        .comparingDouble(Student::getCgpa).reversed()
                        .thenComparing(Student::getFname)
                        .thenComparingInt(Student::getToken));


        while(totalEvents>0){
            String event = in.next();

            String[] split = event.split(" ");

            //ENTER John 3.75 50

            if ("ENTER".equals(split[0])) {
                int id = Integer.valueOf(split[3]);
                double cgpa = Double.valueOf(split[2]);
                String fname = split[1];
                queue.offer(new Student(id, fname, cgpa));
            } else if ("SERVED".equals(split[0])) {
                Student poll = queue.poll();

//                System.out.println("POLL: " + poll.getFname());
            }

            //Complete your code

            totalEvents--;
        }

        if (queue.isEmpty()) {
            System.out.println("EMPTY");
        }


        while (!queue.isEmpty()) {
            System.out.println(queue.poll().getFname());
        }
    }

    static class Student {
        private int token;
        private String fname;
        private double cgpa;

        public Student(int id, String fname, double cgpa) {
            super();
            this.token = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
        public int getToken() {
            return token;
        }
        public String getFname() {
            return fname;
        }
        public double getCgpa() {
            return cgpa;
        }
    }
}