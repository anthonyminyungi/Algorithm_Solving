package com.java.Programmers.CnuDevday_2019;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//못품
public class Solution_4 {
    public static void main(String[] args) {
        int[][] dic1 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}};
        int[][] q1 = {{1, 5}, {2, 5}, {3, 5}, {4, 5}};

        solution(5, dic1, q1);
    }

    public static int[] solution(int N, int[][] directory, int[][] query) {
        int[] answer = new int[query.length];
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        LinkedList<Integer> list = null;
        for (int i = 0; i < directory.length; i++) {

            if (!map.containsKey(directory[i][0])) {
                list = new LinkedList<>();
                list.add(directory[i][1]);
                map.put(directory[i][0], list);
            } else {
                list.add(directory[i][1]);
                map.put(directory[i][0], list);
            }
        }
        System.out.println(map);

        int[][] tmp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            tmp[i][i] = 1;
        }


        return answer;
    }
}
