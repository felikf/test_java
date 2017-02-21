package com.felix.team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 */
public class FindTeams {

    List<String> requiredSkills;

    private Map<String, List<Member>> skillMap;

    public FindTeams(List<Member> members, List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;

        skillMap = new HashMap<>();

        for (Member member : members) {
            for (String skill : member.getSkills()) {


                if (skillMap.containsKey(skill)) {
                    List<Member> memberList = skillMap.get(skill);
                    memberList.add(member);

                } else {
                    List<Member> memberList = new ArrayList<>();
                    memberList.add(member);
                    skillMap.put(skill, memberList);
                }
            }
        }

    }

    public List<Team> createTeams() {
        printSkillMap();

        boolean shouldContinue = true;

        Set<Member> used = new HashSet<>();
        List<Team> teams = new ArrayList<>();

        while (shouldContinue) {

            Team team = new Team();

            for (String requiredSkill : requiredSkills) {
                List<Member> memberList = skillMap.get(requiredSkill);

                Member member = null;
                while (member == null  &&  !memberList.isEmpty()) {
                    member = memberList.remove(0);

                    if (used.contains(member)) {
                        member = null;
                    }

                }

                if (member != null) {
                    team.addMember(member);
                    used.add(member);
                } else {
                    shouldContinue = false;
                    break;
                }

            }

            if (shouldContinue) {
                teams.add(team);
            }

        }

        return teams;
    }

    private void printSkillMap() {
        System.out.println();
        System.out.println();
        System.out.println();

        skillMap
                .entrySet()
                .forEach(entry ->  {
                    System.out.print(entry.getKey() + "  ");
                    System.out.println(entry.getValue().stream().map(member -> member.getName()).collect(Collectors.toList()));
                });
    }


}
