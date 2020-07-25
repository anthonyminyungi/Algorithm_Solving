package com.algorithms.Programmers.CnuDevday_2019;

public class Solution_1 {
    public static void main(String[] args) {
        System.out.println(solution(2, 2));
        System.out.println(solution(9, 3));

    }

    //n m ans
    //2 2 3
    //9 3 13
    public static int solution(int n, int m) {
        int answer = 0;
        int day = 0;
        int num = n;
        int in = m;
        while (true) {
            num--;
            day++;
            if (day == in) {
                num += 1;
                day = 0;
            }
            answer++;

            if (num == 0)
                break;
        }

        return answer;
    }
}
