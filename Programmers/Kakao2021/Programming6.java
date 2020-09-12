package com.algorithms.Programmers.Kakao2021;

import java.util.*;

// 미제출
public class Programming6 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[][]{{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}}, 1, 0));
        System.out.println(solution(new int[][]{{3, 0, 0, 2}, {0, 0, 1, 0}, {0, 1, 0, 0}, {2, 0, 0, 3}}, 0, 1));
    }

    public static int solution(int[][] board, int r, int c) {
        int count = 0;
        List<Integer> counts = new ArrayList<>();
        while (!checkEnd(board)) {
            int[][] targets;
            int[] pairPoint;
            List<Integer> temp = new ArrayList<>();
            if (board[r][c] == 0) {
                int ts = 0;
                targets = getTargets(board, r, c);
                if (targets.length == 0) {
                    targets = moveCursorNearest(board);
                    ts = 2;
                } else {
                    ts = 1;
                }
                for (int i = 0; i < targets.length; i++) {
                    temp.add(count + ts + solution(board, targets[i][0], targets[i][1]));
                }
            } else {
                pairPoint = getPair(board, r, c, board[r][c]);
                board[pairPoint[0]][pairPoint[1]] = 0;
                board[r][c] = 0;
                r = pairPoint[0];
                c = pairPoint[1];
                count += delete(new int[]{r, c}, pairPoint);
            }
            for (int i = 0; i < temp.size(); i++) {
                counts.add(count + temp.get(i));
            }
        }

        int answer = 0;
        if (counts.isEmpty())
            answer += count;
        else {
            Collections.sort(counts);
            answer += counts.get(0);
        }
        return answer;
    }

    public static int delete(int[] cur, int[] pair) {
        if (cur[0] == pair[0]) {
            if (pair[1] == 3 || pair[1] == 0) {
                return 3;
            } else {
                return Math.abs(pair[1] - cur[1]) + 2;
            }
        } else if (cur[1] == pair[1]) {
            if (pair[0] == 3 || pair[0] == 0) {
                return 3;
            } else {
                return Math.abs(pair[0] - cur[0]) + 2;
            }
        } else {
            return Math.abs(pair[0] - cur[0]) + Math.abs(pair[1] - cur[1]) + 2;
        }
    }

    public static int[] getPair(int[][] board, int r, int c, int v) {
        int[] ret = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i != r && j != c && board[i][j] == v) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }
        return ret;
    }

    public static int[][] getTargets(int[][] board, int r, int c) {
        List<int[]> t = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (board[r][i] != 0)
                t.add(new int[]{r, i});
            if (board[i][c] != 0)
                t.add(new int[]{i, c});
        }
        int[][] ret = new int[t.size()][2];
        for (int i = 0; i < t.size(); i++) {
            System.arraycopy(t.get(i), 0, ret[i], 0, 2);
        }
        return ret;
    }

    public static int[][] moveCursorNearest(int[][] board) {
        List<int[]> t = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    t.add(new int[]{i, j});
                }
            }
        }
        int[][] ret = new int[t.size()][2];
        for (int i = 0; i < t.size(); i++) {
            System.arraycopy(t.get(i), 0, ret[i], 0, 2);
        }
        return ret;
    }

    public static boolean checkEnd(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
}
