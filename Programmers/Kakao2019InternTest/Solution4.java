package com.algorithms.Programmers.Kakao2019InternTest;

import java.util.*;

// Map으로 구현한 Union-find. 기억하기.
public class Solution4 {
    static Map<Long, Long> map;
    static long[] answer;
    static int idx = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, new long[]{1, 3, 4, 1, 3, 1})));
    }

    public static long[] solution(long k, long[] room_number) {
        answer = new long[room_number.length];
        map = new HashMap<>();

        for (long l : room_number) {
            assignIfEmpty(l);
        }

        System.out.println(map);
        return answer;
    }

    static long assignIfEmpty(long room) {
        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            answer[idx] = room;
            idx++;
            return room;
        } else {
            map.put(room, assignIfEmpty(map.get(room)));
            return map.get(room);
        }
    }
}
