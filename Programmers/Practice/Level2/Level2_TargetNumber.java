package com.algorithms.Programmers.Practice.Level2;

public class Level2_TargetNumber {
    static int result = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, target, 0, 0);
        answer = result;
        return answer;
    }

    public static void dfs(int[] numbers, int target, int index, int current) {
        if (index == numbers.length) {
            if (current == target) {
                result++;
            }
            return;
        }
        dfs(numbers, target, index + 1, current + numbers[index]);
        dfs(numbers, target, index + 1, current - numbers[index]);
    }
}
