package com.algorithms.Programmers.DevMatchingBackend2021_1;

import java.util.*;

public class Programming1 {
    public static void main(String[] args) {

        //[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
        //[0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
        //[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]
        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
        System.out.println(Arrays.toString(solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> lottoMap = new HashMap<>();
        lottoMap.put(6, 1);
        lottoMap.put(5, 2);
        lottoMap.put(4, 3);
        lottoMap.put(3, 4);
        lottoMap.put(2, 5);
        lottoMap.put(1, 6);
        lottoMap.put(0, 6);

        int max = 6;
        int zCnt = 0;
        for (int l : lottos) {
            if (l == 0) {
                zCnt++;
                continue;
            }
            boolean flag = false;
            for (int w : win_nums) {
                if (w == l) flag = true;
            }
            if (!flag) max--;
        }

        int[] answer = {lottoMap.get(max), lottoMap.get(max - zCnt)};
        return answer;
    }
}
