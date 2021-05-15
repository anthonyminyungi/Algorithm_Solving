package com.algorithms.Programmers.MonthlyCodeChallenge2.May;

import java.util.*;

// 장시간 걸려서 품. 통과 뜨는거 보고서 솔직히 어이없었음.
// 전반적으로 지난달 챌린지보다 어려웠다고 생각.
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"1110", "100111100", "0111111010"})));
        System.out.println(Arrays.toString(solution(new String[]{"1011110", "01110", "101101111010"})));
        // [1101, 100110110, 0110110111]
        // [1011011, 01101, 101101101101]
    }

    public static String[] solution(String[] s) {
        int n = s.length;
        String[] answer = new String[n];
        StringBuilder cur;
        StringBuilder ooz;
        char[] chars;
        Stack<Character> stack;
        for (int i = 0; i < n; i++) {
            cur = new StringBuilder();
            ooz = new StringBuilder();
            chars = s[i].toCharArray();
            stack = new Stack<>();
            for (int j = 0; j < chars.length; j++) { // 스택을 써야만 선형시간에 "110" 제거가 가능하다는 사실이 아직도 와닿지가 않음.
                if (chars[j] == '0') {
                    if (!stack.isEmpty()) {
                        char first = stack.pop();
                        if (first == '1' && !stack.isEmpty() && stack.peek() == '1') {
                            stack.pop();
                            ooz.append("110");
                            continue;

                        } else stack.push(first);
                    }
                }
                stack.push(chars[j]);
            }

            while (!stack.isEmpty()) {
                cur.insert(0, stack.pop());
            }

            int ooo = cur.indexOf("111"), oo = cur.indexOf("11"), lo = cur.lastIndexOf("1"), lz = cur.lastIndexOf("0");
            if (ooo >= 0) {
                cur.insert(ooo, ooz);
            } else if (oo >= 0) {
                cur.insert(oo, ooz);
            } else if (lo > lz) {
                cur.insert(lo, ooz);
            } else {
                cur.append(ooz);
            }

            answer[i] = cur.toString();
        }
        return answer;
    }
}
