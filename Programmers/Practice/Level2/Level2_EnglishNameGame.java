package com.algorithms.Programmers.Practice.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2_EnglishNameGame {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));


    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        boolean wrong = true;
        List<String> list = new ArrayList<>();
        int[] times = new int[n];
        int idx = -1;
        int turn = 1;
        for (int i = 0; i < words.length; i++) {
            idx++;
            if (idx == n) {
                idx = 0;
                turn++;
            }
            times[idx] = turn;

            if (!list.contains(words[i])) {
                if (!list.isEmpty()) {
                    String a = list.get(list.size() - 1);
                    if (a.charAt(a.length() - 1) != words[i].charAt(0)) {
                        wrong = false;
                        break;
                    }
                }
                list.add(words[i]);
            } else {
                wrong = false;
                break;
            }
        }

        if (wrong)
            return new int[]{0, 0};
        else {
            answer[0] = idx + 1;
            answer[1] = times[idx];
            return answer;
        }
    }
}
