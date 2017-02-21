package com.felix.test;

/**
 */
public class ClassTest {

    public int x = 0;

    class Inner {
        public int x = 1;

//        public static int test = 0;

        void methodInInner(int x) {
            System.out.println("x  = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ClassTest.this.x = " + ClassTest.this.x);
        }
    }

    static class StaticInner {
        public int x = 1;

        void methodInInner(int x) {
            ClassTest ct = new ClassTest();

            System.out.println("x  = " + x);
            System.out.println("this.x = " + this.x);
//            System.out.println("ClassTest.this.x = " + ClassTest.this.x);
            System.out.println("ct.x = " + ct.x);
        }
    }

    public static void main(String[] args) {
        ClassTest ct = new ClassTest();
        Inner inner = ct.new Inner();

        inner.methodInInner(23);
    }

    void doInInner() {
        int y = 0;

        class InMain {
            void doSomething() {
                x = 5;
                System.out.println(y);
            }
        }

//        y = 3;  //error
    }
}
