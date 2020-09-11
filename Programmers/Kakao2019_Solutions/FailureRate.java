package com.algorithms.Programmers.Kakao2019_Solutions;

import java.util.*;

public class FailureRate {
    static Comparator<Failure> comp = new Comparator<Failure>() {
        @Override
        public int compare(Failure o1, Failure o2) {
            if (o1.rate < o2.rate)
                return 1;
            else if (o1.rate > o2.rate)
                return -1;
            else {
                return Integer.compare(o1.stage, o2.stage);
            }
        }
    };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Failure> fails = new ArrayList<>();
        int total = stages.length;
        int[] users = new int[N + 1];
        for (int s : stages) {
            users[s - 1]++;
        }
        for (int i = 0; i < N; ++i) {
            if (users[i] == 0) {
                fails.add(new Failure(i + 1, 0));
            } else {
                fails.add(new Failure(i + 1, (double) users[i] / total));
                total -= users[i];
            }
        }
        fails.sort(comp);
        for (int i = 0; i < N; ++i) {
            answer[i] = fails.get(i).stage;
        }

        return answer;
    }

    static class Failure {
        int stage;
        double rate;

        Failure(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }
    }
}
