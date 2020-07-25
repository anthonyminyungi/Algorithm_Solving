package com.algorithms.Programmers.Practice.Level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Level1_FailureRate {
    public static void main(String[] args) {
        int n1 = 5;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int n2 = 4;
        int[] stages2 = {4, 4, 4, 4};
        System.out.println(Arrays.toString(solution(n1, stages1)));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Double, Integer> map = new HashMap<>();
        Double[] temp = new Double[N];
        int len = stages.length;
        int each = len;
        for (int i = 1; i <= N; i++) {
            int fail = 0;
            for (int stage : stages) {
                if (stage == i)
                    fail++;
            }
            double rate = 0.0;
            if (each != 0)
                rate = ((double) fail / (double) each);
            while (map.containsKey(rate)) {
                rate -= 0.00000001;
            }
            map.put(rate, i);
            temp[i - 1] = rate;
            each -= fail;
        }
        Arrays.sort(temp, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o2 > o1)
                    return 1;
                else if (o2.equals(o1))
                    return 0;
                else
                    return -1;

            }
        });
        for (int i = 0; i < N; i++) {
            answer[i] = map.get(temp[i]);
        }
        return answer;
    }
}
