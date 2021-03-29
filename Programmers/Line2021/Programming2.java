package com.algorithms.Programmers.Line2021;

import java.util.*;

public class Programming2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("AaTa+!12-3")));
        System.out.println(Arrays.toString(solution("aaaaZZZZ)")));
        System.out.println(Arrays.toString(solution("CaCbCgCdC888834A")));
        System.out.println(Arrays.toString(solution("UUUUU")));
        System.out.println(Arrays.toString(solution("ZzZz9Z824")));
    }

    public static int[] solution(String inp_str) {
        Set<Integer> falses = new HashSet<>();

        // 1번
        if (inp_str.length() < 8 || inp_str.length() > 15) falses.add(1);

        boolean[] types = {false, false, false, false};

        Map<Character, Integer> counts = new HashMap<>();

        for (char c : inp_str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) types[0] = true;
                else types[1] = true;
            } else if (Character.isDigit(c))
                types[2] = true;
            else {
                if ("~!@#$%^&*".contains(String.valueOf(c))) types[3] = true;
                else falses.add(2);
            }

            if (inp_str.contains(String.valueOf(c) + c + c + c)) falses.add(4);

            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int trueCnt = 0;
        for (boolean type : types) {
            if (type) trueCnt++;
        }
        if (trueCnt < 3) falses.add(3);
        List<Integer> countList = new ArrayList<>(counts.values());
        Collections.sort(countList);
        if (countList.get(countList.size() - 1) >= 5) falses.add(5);

        List<Integer> res = new ArrayList<>(falses);
        Collections.sort(res);
        if (res.isEmpty()) res.add(0);
        int[] answer = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }
}
