package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// 수열과 팩토리얼의 상관관계를 묻는 문제였다. 순열로 처리하면 시간초과.
// 이런식의 수열 처리는 아직도 익숙해지지가 않는다. 나중에 다시 봐야지.
// 참고 : https://tosuccess.tistory.com/75
public class Level3_HowToLine {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 5)));
        System.out.println(Arrays.toString(solution(4, 5)));
    }

    public static int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>(); // LinkedList 가 중간 삭제가 더 오래걸림.
        int[] answer = new int[n];
        long facto = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            facto *= i;
        }
        k--; // k를 활용해 index 에 접근해야하므로 k 번째 경우 -> k-1 번째 인덱스

        int idx = 0;
        while (n > 0) {
            facto /= n; // 남은 자리수 중 첫번째 자리수(현재)가 고정될 경우의 수
            System.out.println(n + " " + k + " " + facto + " " + (int) (k / facto) + " " + k % facto + " " + list);
            answer[idx++] = list.get((int) (k / facto));
            list.remove((int) (k / facto));
            k %= facto;
            n--;
        }

        return answer;
    }

}
