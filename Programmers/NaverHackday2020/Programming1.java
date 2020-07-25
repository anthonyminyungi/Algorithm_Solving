package com.algorithms.Programmers.NaverHackday2020;

import java.util.Arrays;
import java.util.Comparator;

public class Programming1 {
    public static void main(String[] args) {
        int[][] test1 = {{1, 3, 1}, {3, 5, 0}, {5, 4, 0}, {2, 5, 0}};
        int[][] test2 = {{5, 6, 0}, {1, 3, 1}, {1, 5, 0}, {7, 6, 0}, {3, 7, 1}, {2, 5, 0}};
        System.out.println(solution(6, test1));
        System.out.println(solution(7, test2));
    }

    public static String solution(int n, int[][] delivery) {
        StringBuilder answer = new StringBuilder();
        String[] a = new String[n + 1];
        Arrays.sort(delivery, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -Integer.compare(o1[2], o2[2]);
            }
        });
        Arrays.fill(a, "");
        for (int[] ints : delivery) {
            int first = ints[0];
            int second = ints[1];
            boolean shipped = ints[2] == 1;
            if (shipped) {
                a[first] = "O";
                a[second] = "O";
            }
            if (!shipped) {
                boolean firstShipped = a[first].equals("O");
                boolean secondShipped = a[second].equals("O");

                if (firstShipped && !secondShipped) {
                    a[second] = "X";
                } else if (!firstShipped && secondShipped) {
                    a[first] = "X";
                } else if (!firstShipped && !secondShipped) {
                    if (!a[first].equals("X") && !a[second].equals("X")) {
                        a[first] = "?";
                        a[second] = "?";
                    } else if (!a[first].equals("X") && a[second].equals("X"))
                        a[first] = "?";
                    else if (a[first].equals("X") && !a[second].equals("X"))
                        a[second] = "?";
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (a[i].equals(""))
                answer.append("?");
            else
                answer.append(a[i]);
        }
        return answer.toString();
    }
}
