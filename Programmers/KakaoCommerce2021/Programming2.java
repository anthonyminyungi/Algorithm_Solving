package com.algorithms.Programmers.KakaoCommerce2021;

import java.util.*;

public class Programming2 {
    static List<List<Integer>> combs;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}}, 2));
    }

    public static int solution(int[][] needs, int r) {
        int n = needs[0].length;
        combs = new ArrayList<>();
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        combination(arr, visited, 0, n, r);

        List<Integer> cnts = new ArrayList<>();
        for (List<Integer> combi : combs) {
            int cnt = 0;
            for (int[] need : needs) {
                boolean canMake = true;
                for (int i = 0; i < n; i++) {
                    if (need[i] == 1 && !combi.contains(i)) {
                        canMake = false;
                        break;
                    }
                }
                if (canMake) cnt++;
            }
            cnts.add(cnt);
        }
        Collections.sort(cnts);

        return cnts.get(cnts.size() - 1);
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++)
                if (visited[i]) res.add(arr[i]);

            combs.add(res);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}