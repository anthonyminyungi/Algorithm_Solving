package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// 가장 늦은 시간을 구하라고 해서 전체 분 단위의 배열의 구간별 합으로 뒤에부터 구했던 것이 잘못. 그렇게 구하면 겹치는 시간의 카운트에 대한 처리를 해주기가 까다로움.
// 이런식으로 기존 배열의 구조를 유지한 채 정렬 후 시간 단위로 인덱스를 옮기며 카운트를 구하는 것이 더 알맞은 방법인듯.
public class Level3_ShuttleBus {
    public static void main(String[] args) {
        System.out.println(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        System.out.println(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        System.out.println(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:01"}));
        System.out.println(solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println(solution(1, 1, 1, new String[]{"23:59"}));
        System.out.println(solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        int tl = timetable.length;
        int[] times = new int[tl];
        for (int i = 0; i < tl; i++) {
            times[i] = stoi(timetable[i]);
        }
        Arrays.sort(times);
        int idx = 0, res = 0, arrival, cnt;
        for (int i = 0; i < n; i++) {
            arrival = 540 + i * t;
            cnt = 0;
            res = arrival;
            if (i == n - 1) {
                for (int j = idx; j < tl; j++) {
                    if (times[j] <= arrival) cnt++;

                    if (cnt == m) {
                        res = times[j] - 1;
                        break;
                    }
                }
            } else {
                for (int j = idx; j < tl; j++) {
                    if (times[j] <= arrival) {
                        cnt++;
                        idx++;
                    }
                    if (cnt == m) break;
                }
            }
        }

        return itos(res);
    }

    static int stoi(String s) {
        String[] sp = s.split(":");
        return Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
    }

    static String itos(int n) {
        return ((n / 60) < 10 ? "0" + n / 60 : String.valueOf(n / 60)) + ":" + ((n % 60) < 10 ? "0" + n % 60 : String.valueOf(n % 60));
    }
}
