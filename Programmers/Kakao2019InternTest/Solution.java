package com.algorithms.Programmers.Kakao2019InternTest;

import java.util.*;

//통과
public class Solution {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] move = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, move));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = moves.length;
        int h = board.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-100);
        arrayList.add(-200);

        for (int i = 0; i < n; i++) {
            int f = moves[i];
            for (int j = 0; j < h; j++) {
                if (board[j][f - 1] != 0) {
                    arrayList.add(board[j][f - 1]);
                    board[j][f - 1] = 0;
                    break;
                }
            }
            if (arrayList.get(arrayList.size() - 1).equals(arrayList.get(arrayList.size() - 2))) {
                arrayList.remove(arrayList.size() - 1);
                answer++;
                arrayList.remove(arrayList.size() - 1);
                answer++;
            }
        }

        return answer;
    }
}
