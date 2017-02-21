package com.felix.team;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 */
public class Team {
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);
    }

    public List<String> getSkills() {
        return members.stream()
                .map(member -> member.getSkills())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Team{" +
                "members=" + members +
                '}';
    }
}
