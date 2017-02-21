package com.felix.test;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Kombinace {

    public static void main1(String[] args) {
        List<Member> members = Member.create(3);
        List<MemberCombination> result = new ArrayList<>();

        for (int i = 0; i < members.size(); i++) {
//            MemberCombination single = new MemberCombination();
//            result.add(single);
//            single.addMember(members.get(i));


            MemberCombination combination = new MemberCombination();
            result.add(combination);
            combination.addMember(members.get(i));


            for (int j = i + 1; j < members.size() ; j++) {
                combination.addMember(members.get(j));

//                    System.out.println("i: " + i + ", j: " + j + ", k: " + k);


            }
        }




//        result.sort();

        System.out.println(result);


    }


    public static void main(String[] args) {
        List<Member> members = Member.create(3);
        List<MemberCombination> result = new ArrayList<>();

        for (int i = 0; i < members.size(); i++) {

            for (int j = i + 1; j < members.size(); j++) {
                MemberCombination combination = new MemberCombination();
                combination.addMember(members.get(i));

                for (int k = j; k < members.size(); k++) {
                    combination.addMember(members.get(j));
                }

                result.add(combination);

            }
        }

//        result.sort();

        System.out.println(result);


    }

    static class MemberCombination {
        List<Member> members = new ArrayList<>();

        public void addMember(Member member) {
            members.add(member);
        }

        @Override
        public String toString() {
            return "MemberCombination{" +
                    "members=" + members +
                    '}';
        }

        public void addMembers(int start, int amount, List<Member> members) {
            if (start + amount > members.size()) {
                return;
            }

            for (int i = start; i <= amount; i++) {
                addMember(members.get(i));
            }
        }
    }


    static class Member {
        String name;

        public Member(String name) {
            this.name = name;
        }


        static List<Member> create(int size) {
            String[] names = new String[] {"Felix", "Milda", "Fero", "Jarda", "Honza"};
            List<Member> result = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                result.add(new Member(names[i]));
            }

            return result;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
