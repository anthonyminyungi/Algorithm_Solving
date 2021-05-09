package com.algorithms.Programmers.Practice.Level4;

// 슬라이딩윈도우인줄 알았는데 투포인터. l ~ m, m+1 ~ r 이 같은 길이일 필요가 없다.
// 혹은 누적합/구간합.
public class Level4_BuyingCookie {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 2, 3}));
        System.out.println(solution(new int[]{1, 2, 4, 5}));
    }

    public static int solution(int[] cookie) {
        int answer = 0;
        int n = cookie.length;
        int left, right;
        for (int i = 0; i < n - 1; i++) {
            int leftSum = cookie[i], rightSum = cookie[i + 1];
            left = i;
            right = i + 1;
            while (true) {
                if (rightSum == leftSum && leftSum > answer) {
                    answer = leftSum;
                } else if (leftSum <= rightSum && left > 0) { // 여기서 =조건이 왜 들어가야 하는지 아직도 이해가 안됨.
                    leftSum += cookie[--left];
                } else if (leftSum > rightSum && right < n - 1) {
                    rightSum += cookie[++right];
                } else break;
            }
        }

        return answer;
    }
}
