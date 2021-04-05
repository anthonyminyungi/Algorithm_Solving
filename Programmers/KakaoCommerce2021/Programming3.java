package com.algorithms.Programmers.KakaoCommerce2021;

import java.util.*;

// 마지막에 거의 다풀었는데 시간 부족으로 미제출
public class Programming3 {
    static LinkedList<Node>[] tree;
    static boolean[] visited;
    static int[] distance;
    static int max = Integer.MIN_VALUE, index = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, new int[]{1, 1, 1, 1, 1, 1}, new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}})));
        System.out.println(Arrays.toString(solution(4, new int[]{2, 1, 2, 2}, new int[][]{{1, 2}, {1, 3}, {2, 4}})));
        System.out.println(Arrays.toString(solution(5, new int[]{1, 1, 2, 3, 4}, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}})));
    }

    public static int[] solution(int n, int[] passenger, int[][] train) {
        tree = new LinkedList[n];
        distance = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            tree[i] = new LinkedList<>();
        for (int[] t : train) {
            int s = t[0] - 1, e = t[1] - 1;
            tree[s].add(new Node(e, passenger[e]));
            tree[e].add(new Node(s, passenger[s]));
        }

        dfs(0, passenger[0]);

        int[] answer = {index + 1, max};
        return answer;
    }

    public static void dfs(int node, int weight) {
        distance[node] = weight;
        visited[node] = true;
        if (weight > max) {
            max = weight;
            index = node;
        } else if (weight == max)
            if (node > index)
                index = node;

        for (Node next : tree[node]) {
            if (!visited[next.num])
                dfs(next.num, weight + next.dist);
        }
    }

    static class Node {
        int num, dist;

        Node(int n, int d) {
            this.num = n;
            this.dist = d;
        }
    }
}
