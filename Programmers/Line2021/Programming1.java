package com.algorithms.Programmers.Line2021;

import java.util.*;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
                new String[]{"PYTHON", "C++", "SQL"}, new int[]{7, 5, 5}));
        System.out.println(solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
                new String[]{"JAVA", "JAVASCRIPT"}, new int[]{7, 5}));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        Map<String, Map<String, Integer>> tableMap = new HashMap<>();

        for (String row : table) {
            String[] split = row.split(" ");
            tableMap.put(split[0], new HashMap<>());
            for (int j = 1; j < split.length; j++) {
                tableMap.get(split[0]).put(split[j], 5 - j + 1);
            }
        }
//        System.out.println(tableMap);

        Map<String, Integer> scoreMap = new TreeMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : tableMap.entrySet()) {
            Map<String, Integer> map = entry.getValue();
            int score = 0;
            for (int i = 0; i < languages.length; i++) {
                score += map.getOrDefault(languages[i], 0) * preference[i];
            }
            scoreMap.put(entry.getKey(), score);
        }
//        System.out.println(scoreMap);

        List<Integer> scoreList = new ArrayList<>(scoreMap.values());
        List<String> sections = new ArrayList<>();
        Collections.sort(scoreList);

        for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            if (entry.getValue().equals(scoreList.get(scoreList.size() - 1))) {
                sections.add(entry.getKey());
            }
        }

        Collections.sort(sections);

        answer = sections.get(0);
        return answer;
    }
}
