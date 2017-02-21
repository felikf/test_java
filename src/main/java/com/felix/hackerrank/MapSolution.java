package com.felix.hackerrank;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

public class MapSolution{

    public static final String input = "3\n" +
            "uncle sam\n" +
            "99912222\n" +
            "tom\n" +
            "11122222\n" +
            "harry\n" +
            "12299933\n" +
            "uncle sam\n" +
            "uncle tom\n" +
            "harry";

    public static void main(String [] args) {

        Map<String, String> map = new HashMap<>();

        Scanner in = new Scanner(input).useDelimiter("\n");
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
            map.put(name, String.valueOf(phone));
        }

        while(in.hasNext()) {
            String s = in.nextLine();


            String s1 = map.get(s);

            if (s1 == null) {
                System.out.println("Not found");
            } else {
                System.out.printf("%s=%s\n", s, s1);
            }


        }
    }
}
