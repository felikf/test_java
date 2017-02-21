package com.felix.team;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Member {
    private String name;
    private List<String> skills = new ArrayList<>();

    public Member(String name, List<String> skills) {
        this.name = name;
        this.skills.addAll(skills);
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;

        Member member = (Member) o;

        return name.equals(member.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", skills=" + skills +
                '}';
    }
}
