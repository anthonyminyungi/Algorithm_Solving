package com.algorithms.Programmers.Practice.Level2;

import java.util.*;

public class Level2_Compression {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
    }

    public static int[] solution(String msg) {
        int[] answer = {};
        Map<String, Integer> dict = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 26; i++) {
            dict.put(String.valueOf((char) (i + 64)), i);
        }
        int finalIndexOfDict = 27;
        int idx = 0;

        while (!msg.equals("")) {
            StringBuilder sb = new StringBuilder(String.valueOf(msg.charAt(idx)));
            while (dict.containsKey(sb.toString())) {
                if (idx < msg.length() - 1 && dict.containsKey(sb.toString() + msg.charAt(idx + 1))) {
                    sb.append(msg.charAt(idx + 1));
                    idx++;
                } else {
                    break;
                }
            }
            list.add(dict.get(sb.toString()));
            msg = msg.replaceFirst(sb.toString(), "");
            idx = 0;
            if (!msg.equals("")) {
                if (!dict.containsKey(sb.toString() + msg.charAt(idx))) {
                    sb.append(msg.charAt(idx));
                    dict.put(sb.toString(), finalIndexOfDict++);
                }
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
