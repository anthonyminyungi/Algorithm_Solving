package com.algorithms.Programmers.Practice.Level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_Friends4Block {
    static char[][] map;
    static List<int[]> pointSet;

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
        System.out.println(solution(4, 4, new String[]{"ABCD", "BACE", "BCDD", "BCDD"}));

    }

    // 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[] letter = new char[26];
        for (int i = 0; i < letter.length; i++) {
            letter[i] = (char) (65 + i);
        }
        boolean canBlow = true;
        map = new char[m][n];
        pointSet = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int currentSetSize = 0;
        while (canBlow) {
            find(letter);
            currentSetSize = pointSet.size();
            if (currentSetSize == 0) {
                canBlow = false;
                continue;
            }
            answer += bomb();

            pointSet.clear();
            down();
        }

        return answer;
    }

    public static void find(char[] letter) {
        for (char c : letter) {
            for (int i = 0; i < map.length - 1; i++) {
                for (int j = 0; j < map[0].length - 1; j++) {
                    if (map[i][j] == c && map[i][j + 1] == c && map[i + 1][j] == c && map[i + 1][j + 1] == c) {
                        pointSet.add(new int[]{i, j});
                        pointSet.add(new int[]{i + 1, j});
                        pointSet.add(new int[]{i, j + 1});
                        pointSet.add(new int[]{i + 1, j + 1});
                    }
                }
            }
        }
    }

    public static int bomb() {
        int count = 0;
        for (int[] arr : pointSet) {
            if (map[arr[0]][arr[1]] != '*') {
                map[arr[0]][arr[1]] = '*';
                count++;
            }
        }
        return count;
    }

    public static void down() {
        for (int i = map.length - 1; i > 0; i--) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '*') {
                    int detectedX = 0;
                    for (int k = i; k >= 0; k--) {
                        if (map[k][j] != '*') {
                            detectedX = k;
                            break;
                        }
                    }
                    char temp = map[detectedX][j];
                    map[detectedX][j] = map[i][j];
                    map[i][j] = temp;
                }
            }
        }
    }
}


