package com.felix.test;

/**
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        Converter<String, Integer> converter =  main::convert;
        Integer converted = converter.convert("123");

        System.out.println(converted);

        int num = 5;
        Converter<Integer, String> converter2 = from -> String.valueOf(from + num);

        String converted2 = converter2.convert(1);

        System.out.println(converted2);



    }

    public Integer convert(String s) {
        return 0;
    }

    static class Lambda4 {
        static int outerStaticNum;
        int outerNum;

        void testScopes() {
            Converter<Integer, String> stringConverter1 = (from) -> {
                outerNum = 23;
                return String.valueOf(from);
            };

            Converter<Integer, String> stringConverter2 = (from) -> {
                outerStaticNum = 72;
                return String.valueOf(from);
            };
        }
    }

}
