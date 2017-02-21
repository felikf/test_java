package com.felix.bloch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 */
public class Main {

    public static void main(String[] args) {
        ObservableList<Integer> list = new ObservableList<>();

//        list.addObserver(new ListObserver<Integer>() {
//            @Override
//            public void added(ObservableList<Integer> l, Integer element) {
//                System.out.println(element);
//
//                if (element == 23) {
//                    l.removeObserver(this);
//                }
//            }
//        });

        list.addObserver(new ListObserver<Integer>() {
            @Override
            public void added(ObservableList<Integer> l, Integer element) {
                System.out.println(element);

                if (element == 23) {
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    final ListObserver<Integer> observer = this;

                    try {
                        executor.submit(new Runnable() {
                            @Override
                            public void run() {
                                l.removeObserver(observer);
                            }
                        });
                    } finally {
                        executor.shutdown();
                    }


                }
            }
        });



        for (int i = 0; i < 100; i++) {
            list.add(i);

        }
    }
}
