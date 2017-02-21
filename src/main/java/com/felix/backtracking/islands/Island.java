package com.felix.backtracking.islands;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 */
public class Island {

    int space[][] = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0}
    };

//    int space[][] = {
//            {0, 0, 0},
//            {0, 1, 0},
//            {0, 1, 0},
//            {0, 1, 0},
//    };

    Point[] moves = {
            new Point(-1, 0), //left
            new Point(0, -1), //up
            new Point(1, 0),  //right
            new Point(0, 1)   //down
    };


    private Set<Point> solved = new HashSet<>();


    private void analyzeIndex(Point point, boolean shouldKeep) {
        if (isOut(point)) {
            return;
        }

        printSolved(point, shouldKeep);

        if (solved.contains(point)) {
            return;
        }

        if (space[point.x][point.y]  ==  0) {
            solved.add(point);
            return;
        }

        if (shouldKeep) {
            solved.add(point);
        }

        if (!shouldKeep) {
            space[point.x][point.y] = 0;
            solved.add(point);
        }

        for (int i = 0; i < moves.length; i++) {
            analyzeIndex(new Point(point.x + moves[i].x, point.y + moves[i].y), shouldKeep);
        }

    }

    private boolean isOut(Point point) {
        return point.x < 0 || point.y < 0 || point.x >= space.length  ||  point.y >= space.length;

    }

    private boolean isOnEdge(Point point) {
        return (point.x == 0  ||  point.y == 0  ||  point.x == (space.length - 1)  ||  point.y == (space.length - 1));
    }

    private void solve() {
        for (int i = 0; i < space.length; i++) {
            Point point = new Point(0, i);
            analyzeIndex(point, true);
        }
        for (int i = 0; i < space.length; i++) {
            Point point = new Point(space.length - 1, i);
            analyzeIndex(point, true);
        }

        for (int i = 0; i < space.length; i++) {
            Point point = new Point(i, 0);
            analyzeIndex(point, true);
        }
        for (int i = 0; i < space.length; i++) {
            Point point = new Point(i, space.length - 1);
            analyzeIndex(point, true);
        }


        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space.length; j++) {
                analyzeIndex(new Point(i, j), false);
            }
        }
    }

    private void print() {
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                System.out.print(space[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void printSolved(Point point, boolean shouldKeep) {
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                if (point.x == i  &&  point.y == j) {
                    System.out.print("x");
                } else  if (solved.contains(new Point(i, j))) {
                    System.out.print("s");
                } else {
                    System.out.print("-");
                }
            }

            System.out.print("       ");

            for (int j = 0; j < space[i].length; j++) {
                System.out.print(space[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    public static void main(String[] args) {
        Island island = new Island();

        island.solve();


        island.print();
    }

}
