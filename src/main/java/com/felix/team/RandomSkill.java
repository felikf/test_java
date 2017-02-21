package com.felix.team;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 */
public class RandomSkill {
    static String[] skills = new String[] {"java", ".net", "javascript", "scala", "groovy", "lisp", "c", "angular"};

    public static List<String> random(int cnt) {
        Set<String> result = new HashSet<>();

        Random random = new Random();

        for (int i = 0; i < cnt; i++) {
            int index = random.nextInt(skills.length);
            result.add(skills[index]);
        }

        return new ArrayList<>(result);
    }

}
