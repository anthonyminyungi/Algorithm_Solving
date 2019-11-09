package com.java.Programmers.Kakao2019InternTest;

import java.util.Arrays;

//효율성검사에서 떨어짐
public class Solution4 {
    public static void main(String[] args) {
        long[] room = {1, 3, 4, 1, 3, 1};
        System.out.println(Arrays.toString(solution(10, room)));
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        boolean[] check = new boolean[(int) k];

        for (int i = 0; i < room_number.length; i++) {
            if (!check[(int) room_number[i]]) {
                answer[i] = room_number[i];
                check[(int) room_number[i]] = true;
            } else {
                for (int j = 1; answer[answer.length - 1] == 0; j++) {
                    if (!check[j] && room_number[i] < j) {
                        answer[i] = j;
                        check[j] = true;
                        break;
                    }
                }

            }
        }

        return answer;
    }

}
