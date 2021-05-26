package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 우선 내 풀이 기록. 852ms
// 조합을 활용한 주먹구구식 풀이
public class StartAndLink_14889 {
    static List<int[]> team;
    static List<int[]> pointComb;
    static int[] arr;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        int[] res = new int[n / 2];
        team = new ArrayList<>();
        pointComb = new ArrayList<>();
        combi(n, n / 2, 0, 0, arr, res, 0);
        int[] res2;
        int min = 987654321, sum;
        for (int i = 0; i < team.size(); i++) {
            res2 = new int[2];
            combi(n / 2, 2, 0, 0, team.get(i), res2, 1);
            res2 = new int[2];
            combi(n / 2, 2, 0, 0, getOpposite(team.get(i)), res2, 1);
            sum = 0;
            for (int j = 0; j < pointComb.size() / 2; j++) {
                int[] pair = pointComb.get(j);
                sum += grid[pair[0]][pair[1]];
                sum += grid[pair[1]][pair[0]];
            }
            for (int j = pointComb.size() / 2; j < pointComb.size(); j++) {
                int[] pair = pointComb.get(j);
                sum -= grid[pair[0]][pair[1]];
                sum -= grid[pair[1]][pair[0]];
            }
            if (sum < 0) sum = -sum;
            if (min > sum) min = sum;
            pointComb.clear();
        }

        System.out.println(min);
    }

    static void combi(int n, int r, int idx, int depth, int[] arr, int[] result, int flag) {
        if (depth == r) {
            if (flag == 0)
                team.add(result.clone());
            else
                pointComb.add(result.clone());
            return;
        }
        if (idx == n) return;

        result[depth] = arr[idx];

        combi(n, r, idx + 1, depth + 1, arr, result, flag);
        combi(n, r, idx + 1, depth, arr, result, flag);
    }

    static int[] getOpposite(int[] people) {
        boolean[] opposite = new boolean[n];
        int[] res = new int[n / 2];
        for (int p : people) {
            opposite[p] = true;
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (!opposite[i]) {
                res[idx++] = arr[i];
            }
        }
        return res;
    }
}
