package com.felix.test;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 */
public class DateTime {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();

        System.out.println(clock.instant());


        System.out.println(LocalTime.now());
        System.out.println(LocalTime.of(20, 20));
    }

}
