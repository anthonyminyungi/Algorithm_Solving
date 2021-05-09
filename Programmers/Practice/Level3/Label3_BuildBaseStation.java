package com.algorithms.Programmers.Practice.Level3;

// Math 라이브러리는 반복사용하면 시간을 많이 잡아먹는다.
// 이분탐색에 대한 변형문제.
public class Label3_BuildBaseStation {
    public static void main(String[] args) {
        System.out.println(solution(11, new int[]{4, 11}, 1));
        System.out.println(solution(16, new int[]{9}, 2));
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int k = stations.length;
        int left, right, cur = 1, cover = 2 * w + 1, area;

        for (int station : stations) {
            left = station - w;
            right = station + w;
            if (cur >= left) cur = right + 1;
            else {
                area = left - cur;
                if (area % cover == 0) answer += area / cover;
                else answer += area / cover + 1;
                cur = right + 1;
            }
        }

        if (cur <= n) {
            area = n + 1 - cur;
            if (area % cover == 0) answer += area / cover;
            else answer += area / cover + 1;
        }

        return answer;
    }
}
