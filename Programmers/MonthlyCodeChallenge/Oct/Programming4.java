package com.algorithms.Programmers.MonthlyCodeChallenge.Oct;

// 시험 종료 후 재작성함. 맞는지는 프로그래머스에 문제 나온 뒤 확인해보기

// 10.20 업데이트
// 세그먼트 트리를 활용한 풀이 적용
// C++로 작성된 블로그 코드를 필사함
<<<<<<< HEAD
// 출처 https://openingsound.tistory.com/97
=======
>>>>>>> f05c738907b1bfa5ed5ba37c0110edffad99ce29
// 정확한 동작 과정을 이해하지 못함.
// 디버깅 돌려보면서 정확한 이해가 필요할 듯.

public class Programming4 {
    public static void main(String[] args) {
        System.out.println(solution("baby"));
        System.out.println(solution("oo"));
        System.out.println(solution("baabaa"));
    }

    static long answer;
    static int[] arr;
    static long[] segL;
    static long[] segR;

    public static long solution(String s) {
        answer = 0;
        int n = s.length();
        arr = new int[n + 1];
        segL = new long[n * 4 + 1];
        segR = new long[n * 4 + 1];

        for (long i = 2; i <= n; i++) {
            answer += (i - 1) * (n - i + 1);
        }
        System.out.println(answer);

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            leftSeg(1, n, 1);
            rightSeg(1, n, 1);

            int right = 0;
            int ch = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(j) != c) {
                    right = 0;
                    continue;
                }
                right++;
                if (ch == 0) {
                    updateLeft(1, n, 1, right, 1);
                    updateRight(1, n, 1, right, right);
                    ch = 1;
                    continue;
                }

                answer -= right * sumLeft(1, n, 1, right + 1, n);
                answer -= sumRight(1, n, 1, 1, right);
                updateLeft(1, n, 1, right, 1);
                updateRight(1, n, 1, right, right);
            }
        }

        return answer;
    }

    static long leftSeg(int left, int right, int node) {
        if (left == right)
            return segL[node] = arr[left];
        int mid = (left + right) / 2;
        return segL[node] = leftSeg(left, mid, node * 2) + leftSeg(mid + 1, right, node * 2 + 1);
    }

    static void updateLeft(int left, int right, int node, int change, int diff) {
        if (!(left <= change && change <= right))
            return;
        segL[node] += diff;
        if (left == right) return;
        int mid = (left + right) / 2;
        updateLeft(left, mid, node * 2, change, diff);
        updateLeft(mid + 1, right, node * 2 + 1, change, diff);
    }

    static long sumLeft(int left, int right, int node, int start, int end) {
        if (left >= start && end >= right)
            return segL[node];
        if (right < start || left > end)
            return 0;
        int mid = (left + right) / 2;
        return sumLeft(left, mid, node * 2, start, end) + sumLeft(mid + 1, right, node * 2 + 1, start, end);
    }

    static long rightSeg(int left, int right, int node) {
        if (left == right)
            return segR[node] = arr[left];
        int mid = (left + right) / 2;
        return segR[node] = rightSeg(left, mid, node * 2) + rightSeg(mid + 1, right, node * 2 + 1);
    }

    static void updateRight(int left, int right, int node, int change, int diff) {
        if (!(left <= change && change <= right))
            return;
        segR[node] += diff;
        if (left == right) return;
        int mid = (left + right) / 2;
        updateRight(left, mid, node * 2, change, diff);
        updateRight(mid + 1, right, node * 2 + 1, change, diff);
    }

    static long sumRight(int left, int right, int node, int start, int end) {
        if (left >= start && end >= right)
            return segR[node];
        if (right < start || left > end)
            return 0;
        int mid = (left + right) / 2;
        return sumRight(left, mid, node * 2, start, end) + sumRight(mid + 1, right, node * 2 + 1, start, end);
    }
}
