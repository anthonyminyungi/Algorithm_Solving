package com.java.Programmers.Practice.Level2;

// 정답 코드 찾아서 풀었음.
// 다시 풀어보기. https://geehye.github.io/programmers-greedy-02/#

public class Level2_MakeBigNumber {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
        System.out.println(solution("12222211456", 3));
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int localMaxIndex = 0;
        char localMaxValue;
        char[] numbers = number.toCharArray();

        for (int i = 0; i < numbers.length - k; i++) {
            localMaxValue = '0';
            for (int j = localMaxIndex; j <= k + i; j++) {
                if (localMaxValue < numbers[j]) {
                    localMaxValue = numbers[j];
                    localMaxIndex = j + 1;
                }
            }
            answer.append(localMaxValue);
        }

        return answer.toString();
    }
}

