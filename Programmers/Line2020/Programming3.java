package com.algorithms.Programmers.Line2020;

import java.util.*;

public class Programming3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(73425)));
        System.out.println(Arrays.toString(solution(10007)));
        System.out.println(Arrays.toString(solution(9)));
    }

    public static int[] solution(int n) {
        int preLength = 1;
        int plusCnt = 0;
        int[] answer = new int[2];
        List<Integer> cases;
        String temp = String.valueOf(n);
        while (temp.length() > 1) {
            cases = new ArrayList<>();
            while (preLength <= temp.length() - 1) {
                String prefix = temp.substring(0, preLength);
                String suffix = temp.substring(preLength);
                if (suffix.charAt(0) == '0') {
                    for (int i = 1; i < temp.length(); i++) {
                        if (temp.charAt(i) != '0') {
                            preLength = i;
                            break;
                        }
                    }
                    continue;
                }
                cases.add(Integer.parseInt(prefix) + Integer.parseInt(suffix));
                preLength++;
            }
            if (cases.size() > 1)
                Collections.sort(cases);
            temp = String.valueOf(cases.get(0));
            plusCnt++;
            preLength = 1;
        }

        answer[0] = plusCnt;
        answer[1] = Integer.parseInt(temp);

        return answer;
    }
}
