package com.algorithms.Programmers.LINEFintech;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution("123903"));
        System.out.println(solution("123901"));
    }

    public static int solution(String inputString) {
        int answer = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 1000; i++) sb.append(i);
        char[] comp = sb.toString().toCharArray();
        char[] input = inputString.toCharArray();

        int comLen = comp.length, inputIdx = 0, endIdx = 0;
        for (int i = 0; i < comLen; i++) {
            if (input[inputIdx] == comp[i]) {
                inputIdx++;
                if (inputIdx == inputString.length()) {
                    endIdx = i;
                    break;
                }
            } else {
                while (input[inputIdx] != comp[i]) {
                    i++;
                }
                i--;
            }
        }
        sb = new StringBuilder();
        for (int i = 1; i < 1000; i++) {
            sb.append(i);
            if (sb.length() - 1 >= endIdx) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
