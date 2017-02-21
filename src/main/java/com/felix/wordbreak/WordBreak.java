package com.felix.wordbreak;

import java.util.HashSet;
import java.util.Set;

/**
 */
public class WordBreak {
    Set<String> dict = new HashSet<>();
    Set<String> memory = new HashSet<>();

    public boolean find(String s, String answer) {

        if (s.length() == 0) {
            System.out.println("Answer: " + answer);
            return true;
        }

        int index = 0;
        String word = "";

        while (index < s.length()) {
            word += s.charAt(index);

            if (dict.contains(word)) {

                if (find(s.substring(index + 1), answer + " " + word)) {
                    return true;
                } else {
                    System.out.println("backtrack " + word);
                    index++;
                }

            } else {
                index++;
            }

        }

        return false;
    }

    private void addWord(String word) {
        this.dict.add(word);
    }

    public boolean findUsingDP(String s, String answer) {
        if (s.length() == 0) {
            System.out.println(answer);
            return true;
        } else if (memory.contains(s)) {
            return false;
        } else {

            int index = 0;
            String word = "";
            while (index < s.length()) {
                word += s.charAt(index);// add one char at a time
                // check if word already being solved
                if (dict.contains(word)) {
                    if (findUsingDP(s.substring(index + 1), answer + word + " ")) {
                        return true;
                    } else {
                        System.out.println("backtrack " + s);
                        index++;
                    }
                } else {
                    index++;
                }
            }
            memory.add(s);// memoization for future;
            return false;
        }
    }



    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();

//        wordBreak.addWord("isis");
//        wordBreak.addWord("is");
//        wordBreak.addWord("sumit");
//        wordBreak.addWord("jain");
//        wordBreak.addWord("the");
//        wordBreak.addWord("problem");
//        wordBreak.addWord("it");
//        wordBreak.addWord("sum");
//
//        wordBreak.find("thisissumitaaa", "");
//        System.out.println("----------------------------------------");

        wordBreak = new WordBreak();
        wordBreak.addWord("isis");
        wordBreak.addWord("is");
        wordBreak.addWord("sumit");
        wordBreak.addWord("jain");
        wordBreak.addWord("the");
        wordBreak.addWord("problem");
        wordBreak.addWord("it");
        wordBreak.addWord("sum");

        // create another HashSet so store the sub problems result
        wordBreak.findUsingDP("isissumitait", "");
   }

}