package com.felix.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.felix.team.RandomSkill.random;

/**
 */
public class Main {

    public static void main(String[] args) {
        List<Member> members = prepareMembers(10);

        List<Team> teams = new FindTeams(members, Arrays.asList("java", "angular")).createTeams();

        teams.forEach(team -> {
            System.out.println(team);
            System.out.println(team.getSkills());

        });
    }

    private static List<Member> prepareMembers(int cnt) {
        List<Member> members = new ArrayList<>();

        IntStream.range(0, 10)
                .forEach(i -> members.add(new Member("A" + i, random(3))));

        members.stream().forEach(member -> System.out.println(member));

        return members;
    }

}
