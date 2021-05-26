package com.algorithms.LeetCode;

// 제한사항이 num 이 1000000 까지라 배열을 활용한 dp로 가면 오히려 더 느리다. 그냥 주어진 규칙대로 -1, /2 를 수행하는게 빠름.
public class NumberOfStepsToMakeZero_1342 {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
    }

    public static int numberOfSteps(int num) {
        int cnt = 0;
        while (num != 0) {
            if (num % 2 == 0)
                num /= 2;
            else
                num -= 1;
            cnt++;
        }
        return cnt;
    }
}
