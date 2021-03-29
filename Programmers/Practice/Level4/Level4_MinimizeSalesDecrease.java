package com.algorithms.Programmers.Practice.Level4;

import java.util.*;

// 트리 DP
// 다른 방법으로 다시 풀어보기 (C++ 코드 참고)
public class Level4_MinimizeSalesDecrease {
    static int[] dp;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17}, new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}}));
        System.out.println(solution(new int[]{5, 6, 5, 3, 4}, new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}}));
        System.out.println(solution(new int[]{5, 6, 5, 1, 4}, new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}}));
        System.out.println(solution(new int[]{10, 10, 1, 1}, new int[][]{{3, 2}, {4, 3}, {1, 4}}));
    }

    public static int solution(int[] sales, int[][] links) {
        Node[] nodes = new Node[sales.length + 1];

        for (int i = 0; i < sales.length; i++) {
            nodes[i + 1] = new Node(sales[i], i + 1);
        }

        for (int[] link : links) nodes[link[0]].childList.add(nodes[link[1]]);
        dp = new int[sales.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        return recursive(nodes[1]);
    }

    static int recursive(Node node) {
        if (node == null) return 0;
        if (dp[node.id] != Integer.MIN_VALUE) return dp[node.id];
        if (node.childList.size() == 0) return 0;

        int min = Integer.MAX_VALUE;

        int sum;
        for (int i = 0; i < node.childList.size(); i++) {
            sum = 0;
            for (int j = 0; j < node.childList.size(); j++) {
                if (i == j) continue;
                sum += recursive(node.childList.get(j));
            }

            for (Node child : node.childList.get(i).childList)
                sum += recursive(child);

            min = Math.min(min, sum + node.childList.get(i).sales);
        }

        sum = 0;
        for (Node child : node.childList)
            sum += recursive(child);
        min = Math.min(min, sum + node.sales);
        dp[node.id] = min;

        return min;
    }

    static class Node {
        int sales, id;
        List<Node> childList;

        Node(int sales, int id) {
            this.sales = sales;
            this.id = id;
            this.childList = new ArrayList<>();
        }
    }
}
