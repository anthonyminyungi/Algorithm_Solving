package com.algorithms.Programmers.Practice.Level2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Level2_SkillTree {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] skillSequence = skill.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < skillSequence.length; i++) {
            map.put(skillSequence[i], i);
        }
        for (int i = 0; i < skill_trees.length; i++) {
            StringBuilder sb = new StringBuilder();
            String cur = skill_trees[i];
            for (int j = 0; j < cur.length(); j++) {
                char c = cur.charAt(j);
                if (skill.contains(String.valueOf(c))) {
                    sb.append(c);
                }
            }
//            System.out.println(sb.toString());
            if (skill.startsWith(sb.toString())) {
                answer++;
            }
        }
//        System.out.println(map);
        return answer;
    }
}
