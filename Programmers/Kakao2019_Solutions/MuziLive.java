package com.algorithms.Programmers.Kakao2019_Solutions;

import java.util.*;

public class MuziLive {
    static Comparator<Food> compTime = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return Integer.compare(o1.time, o2.time);
        }
    };
    static Comparator<Food> compIndex = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return Integer.compare(o1.index, o2.index);
        }
    };

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2}, 5));
    }

    public static int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<>();
        int n = food_times.length;
        for (int i = 0; i < n; ++i) {
            foods.add(new Food(i + 1, food_times[i]));
        }
        foods.sort(compTime);

        int preTime = 0;
        int idx = 0;
        for (Food f : foods) {
            long diff = f.time - preTime;
            if (diff != 0) {
                long spend = diff * n;
                if (spend <= k) {
                    k -= spend;
                    preTime = f.time;
                } else {
                    k %= n;
                    foods.subList(idx, food_times.length).sort(compIndex);
                    return foods.get(idx + (int) k).index;
                }
            }
            ++idx;
            --n;
        }

        return -1;

//        나의 풀이 13.4 / 100.0
//       int answer = 0;
//        int idx = 0;
//        List<Integer> complete = new ArrayList<>();
//        while (k-- != 0) {
//            if (food_times[idx] == 0) {
//                complete.add(idx);
//                idx++;
//            }
//
//            if (complete.size() == food_times.length)
//                return -1;
//
//            food_times[idx++]--;
//            if (idx == food_times.length)
//                idx = 0;
//        }
//
//        answer = idx + 1;
//        return answer;
    }

    static class Food {
        int index;
        int time;

        Food(int i, int t) {
            this.index = i;
            this.time = t;
        }
    }
}
