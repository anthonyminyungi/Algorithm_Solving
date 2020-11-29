package com.algorithms.OnCoder.NHNGodo;

public class Problem5 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 7, 7}));
        System.out.println(solution(new int[]{5, 10, 7, 3, 8}));
        System.out.println(solution(new int[]{10, 10, 10, 10}));
        System.out.println(solution(new int[]{1}));
    }

    public static int solution(int[] votes) {
        if (votes.length == 1) return 0;
        int initial = votes[0];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < votes.length; i++) max = Math.max(max, votes[i]);
        while (votes[0] <= max) {
            for (int i = 1; i < votes.length; i++) {
                if (votes[i] == max) {
                    votes[i]--;
                    votes[0]++;
                    break;
                }
            }
            max = Integer.MIN_VALUE;
            for (int i = 1; i < votes.length; i++) max = Math.max(max, votes[i]);
        }

        return votes[0] - initial;
    }
}
