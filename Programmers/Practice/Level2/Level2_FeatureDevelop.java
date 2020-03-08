package com.java.Programmers.Practice.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Level2_FeatureDevelop {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] days = new int[progresses.length];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }
        int bench = days[0];
        list.add(1);
        int index = 0;
        for (int i = 1; i < days.length; i++) {
            if (days[i] <= bench) {
                int curr = list.get(index);
                list.remove(index);
                list.add(index, curr + 1);
            } else {
                bench = days[i];
                index++;
                list.add(1);
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
