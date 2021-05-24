package com.algorithms.LeetCode;

public class MaximumPopulationYear_1854 {
    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int[][]{{1993, 1999}, {2000, 2010}}));
        System.out.println(maximumPopulation(new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}}));
    }

    public static int maximumPopulation(int[][] logs) {
        int[] counts = new int[101];
        for (int[] log : logs) {
            for (int j = log[0] - 1950; j < log[1] - 1950; j++) {
                counts[j] += 1;
            }
        }
        int max = -987654321;
        for (int i = 0; i <= 100; i++) {
            if (counts[i] > max) max = counts[i];
        }
        int answer = 0;
        for (int i = 0; i <= 100; i++) {
            if (counts[i] == max) {
                answer = 1950 + i;
                break;
            }
        }

        return answer;
    }
}
