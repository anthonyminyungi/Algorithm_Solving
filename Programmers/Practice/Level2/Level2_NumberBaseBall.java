package com.java.Programmers.Practice.Level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_NumberBaseBall {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}}));
    }

    public static int solution(int[][] baseball) {
        int answer = 0;
        List<Integer> currentList = new ArrayList<>();
        List<Integer> prevList = new ArrayList<>();
        StringBuilder numset = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            numset.append((i));
            for (int j = 1; j <= 9; j++) {
                if (!numset.toString().contains(String.valueOf(j))) {
                    numset.append((j));

                    for (int l = 1; l <= 9; l++) {
                        if (!numset.toString().contains(String.valueOf(l))) {
                            numset.append((l));
                            prevList.add(Integer.parseInt(numset.toString()));
                            numset.deleteCharAt(2);
                        }
                    }
                    numset.deleteCharAt(1);
                }
            }
            numset = new StringBuilder();
        }

        for (int i = 0; i < baseball.length; i++) {
            int inputNumber = baseball[i][0];
            int inputStrike = baseball[i][1];
            int inputBall = baseball[i][2];
            for (int prev : prevList) {
                int[] checked = check(inputNumber, prev);
                if (inputStrike == checked[0] && inputBall == checked[1]) {
                    currentList.add(prev);
                }
            }
            prevList.clear();
            prevList.addAll(currentList);
            currentList.clear();
        }
        answer = prevList.size();
        return answer;
    }

    static int[] check(int src, int target) {
        int[] res = new int[2]; // 0: strike, 1: ball
        String strSrc = String.valueOf(src);
        String strTarget = String.valueOf(target);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (strSrc.charAt(i) == strTarget.charAt(i) && i == j) {
                    res[0]++;
                } else if (strSrc.charAt(i) == strTarget.charAt(j) && i != j) {
                    res[1]++;
                }

            }
        }

        return res;
    }
}
