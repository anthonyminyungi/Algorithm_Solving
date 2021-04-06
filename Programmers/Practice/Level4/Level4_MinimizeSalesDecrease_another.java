package com.algorithms.Programmers.Practice.Level4;

import java.util.*;

public class Level4_MinimizeSalesDecrease_another {
    static final int INF = 987654321;
    static int[] Sales;
    static List<List<Integer>> Children;
    static int[][] Cost;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17}, new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}}));
        System.out.println(solution(new int[]{5, 6, 5, 3, 4}, new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}}));
        System.out.println(solution(new int[]{5, 6, 5, 1, 4}, new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}}));
        System.out.println(solution(new int[]{10, 10, 1, 1}, new int[][]{{3, 2}, {4, 3}, {1, 4}}));
    }

    public static int solution(int[] sales, int[][] links) {
        Children = new ArrayList<>();
        Sales = sales;
        Cost = new int[300000][2];

        for (int i = 0; i < sales.length; i++) {
            Children.add(new ArrayList<>());
        }

        for (int[] link : links) {
            Children.get(link[0] - 1).add(link[1] - 1);
        }

        traversal(0);
        return Math.min(Cost[0][0], Cost[0][1]);
    }

    static void traversal(int node) {
        Cost[node][0] = 0;
        Cost[node][1] = Sales[node];
        if (Children.get(node).isEmpty()) return;

        int extraCost = INF;
        for (int child : Children.get(node)) {
            traversal(child);
            if (Cost[child][0] < Cost[child][1]) {
                Cost[node][0] += Cost[child][0];
                Cost[node][1] += Cost[child][0];
                extraCost = Math.min(extraCost, Cost[child][1] - Cost[child][0]);
            } else {
                Cost[node][0] += Cost[child][1];
                Cost[node][1] += Cost[child][1];
                extraCost = 0;
            }
        }
        Cost[node][0] += extraCost;
    }
}
