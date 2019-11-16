package com.java.Programmers.CnuDevday_2019;

import java.util.Arrays;

public class Solution_2 {
    public static void main(String[] args) {
        int[] p1 = {2, 3};
        int[] t1 = {2, 3, 4};
        System.out.println(solution(p1, t1));

    }

    public static int solution(int[] people, int[] tshirts) {
        int answer = 0;
        Arrays.sort(people);
        Arrays.sort(tshirts);

        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < tshirts.length; j++) {
                if (people[i] <= tshirts[j]) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

}
