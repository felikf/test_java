package com.felix.backtracking.wordinmatrix;

import java.awt.*;

/**
 */
public class WordMatrix {

    public int[][] solution;
    int path = 1;

    public WordMatrix(int N) {
        solution = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution[i][j] = 0;
            }
        }
    }

    private Point[] moves = {
            new Point(1, 0),
            new Point(-1, 0),
            new Point(0, 1),
            new Point(0, -1),
            new Point(-1, 1),
            new Point(-1, -1),
            new Point(1, -1),
            new Point(1, 1),
    };

    public boolean searchWord(char[][] matrix, String word) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (search(matrix, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] matrix, String word, int i, int j, int index) {

        if (isOut(i, j, matrix.length)  ||  solution[i][j] != 0  ||  word.charAt(index) != matrix[i][j]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        solution[i][j] = path++;

        for (Point move : moves) {

            if (search(matrix, word, i + move.x, j + move.y, index + 1)) {
                return true;
            }

        }

        //backtrack
        solution[i][j] = 0;
        path--;

        return false;
    }

    private boolean isOut(int i, int j, int length) {
        return i < 0  ||  j < 0  ||  i >= length  ||  j >= length;
    }

    public void print() {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print(" " + solution[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'t', 'z', 'x', 'c', 'd'},
                {'a', 'h', 'n', 'z', 'x'},
                {'h', 'w', 'o', 'i', 'o'},
                {'o', 'r', 'n', 'r', 'n'},
                {'a', 'b', 'r', 'i', 'n'}
        };
        WordMatrix w = new WordMatrix(matrix.length);
        if (w.searchWord(matrix, "horizon")) {
            w.print();
        } else {
            System.out.println("NO PATH FOUND");
        }

    }


}
