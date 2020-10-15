package com.algorithms.Codility.Naver_20201015;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(solution(268));
        System.out.println(solution(670));
        System.out.println(solution(0));
        System.out.println(solution(-999));
    }

    public static int solution(int N) {
        boolean isNegative = N < 0;
        String str = String.valueOf(Math.abs(N));
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            int v = Integer.parseInt(str.substring(0, i) + "5" + str.substring(i));
            v = isNegative ? -v : v;
            list.add(v);
        }
        int last = Integer.parseInt(str + "5");
        list.add(isNegative ? -last : last);
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
