package com.felix.team;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 */
public class PriorityQueueTest {


    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Queue<Integer> linkedList= new LinkedList<>();

        priorityQueue.offer(Integer.valueOf(1));
        priorityQueue.offer(Integer.valueOf(4));
        priorityQueue.offer(Integer.valueOf(2));
        priorityQueue.offer(Integer.valueOf(3));

        linkedList.offer(Integer.valueOf(1));
        linkedList.offer(Integer.valueOf(4));
        linkedList.offer(Integer.valueOf(2));
        linkedList.offer(Integer.valueOf(3));

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        System.out.println();


        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.poll());
        }

    }
}
