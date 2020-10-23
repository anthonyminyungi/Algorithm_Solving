package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// Greedy
// 단순 그리디
// 출처 : https://velog.io/@ptm0304/%EB%8B%A8%EC%86%8D%EC%B9%B4%EB%A9%94%EB%9D%BC-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.3
public class Level3_CCTV {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }

    public static int solution(int[][] routes) {
        int answer = 1;
        int len = routes.length;
        Arrays.sort(routes, Comparator.comparingInt(o -> o[0]));
        int[] tmp = routes[0];
        for (int i = 1; i < len; i++) {
            int[] cur = routes[i];
            if (tmp[1] > cur[1]) tmp = cur;
            else if (tmp[1] < cur[0]) {
                answer++;
                tmp = cur;
            }
        }
        return answer;
    }
}
