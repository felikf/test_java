package com.felix.fibonacchi;

/**
 */
public class Fibonacchi {

    public int fibRec(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibRec(n - 1) + fibRec(n - 2);
    }

    public int fibDP(int n) {
        int fib[] = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }


    private int[] fib;

    public int fibTopDown(int n) {
        fib = new int[n + 1];
        return fibTopDownInner(n);
    }

    private int fibTopDownInner(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (fib[n] != 0) {
            return fib[n];
        }

        fib[n] = fibTopDownInner(n - 1) + fibTopDownInner(n - 2);
        return  fib[n];
    }

    /**
     * 0 1 1 2 3
     * @param args
     */
    public static void main(String[] args) {
        Fibonacchi fib = new Fibonacchi();
        System.out.printf("fibRec(5) = %d", fib.fibRec(5));
        System.out.println();
        System.out.printf("fibDP(5) = %d", fib.fibDP(5));
        System.out.println();
        System.out.printf("fibTopDown(5) = %d", fib.fibTopDown(5));
    }

}
