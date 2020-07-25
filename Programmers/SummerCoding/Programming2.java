package com.algorithms.Programmers.SummerCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programming2 {
    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(11));
    }

    //3의 20승까지
    public static long solution(long n) {
        long answer = 0;
        long[] tempList = new long[21];
        tempList[0] = 1;
        tempList[1] = 3;
        tempList[2] = 9;
        List<Long> list = new ArrayList<>();
        list.add((long) 1);
        list.add((long) 3);
        list.add((long) 4);
        list.add((long) 9);
        list.add((long) 10);
        list.add((long) 12);
        list.add((long) 13);

        for (int i = 3; i <= 20; i++) {
            long current = (long) Math.pow(3, i);
            int listSize = list.size();
            list.add(current);
            for (int j = 0; j < listSize; j++) {
                list.add(current + list.get(j));
            }
        }
        Collections.sort(list);
        answer = list.get((int) n - 1);
        return answer;
    }
}
