package com.algorithms.Programmers.Practice.Level2;

// DP
public class Level2_FindBiggestSquare {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int rowSize = board.length;
        int colSize = board[0].length;
        if (rowSize == 1 || colSize == 1) return 1;

        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                if (board[i][j] >= 1) {
                    int min = Math.min(board[i][j - 1], board[i - 1][j]);
                    board[i][j] = Math.min(min, board[i - 1][j - 1]) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        answer *= answer;
        return answer;

//        효율성 0점 코드
//         int answer = 0;
//         int k = Math.min(board.length, board[0].length);
//         for (int a = 1; a <= k; a++) {
//             int[][] mask = new int[a][a];
//             for (int i = 0; i < a; i++) Arrays.fill(mask[i], 1);

//             for (int i = 0; i < board.length - a + 1; i++) {
//                 for (int j = 0; j < board[0].length - a + 1; j++) {
//                     boolean isCorrect = true;
//                     for (int p = 0; p < a; p++) {
//                         for (int q = 0; q < a; q++) {
//                             if (mask[p][q] != board[i + p][j + q]) {
//                                 isCorrect = false;
//                                 break;
//                             }
//                         }
//                         if (!isCorrect) break;
//                     }
//                     if (isCorrect) {
//                         answer = Math.max(answer, a);
//                     }
//                 }
//             }
//         }
//         answer *= answer;
//         return answer;
    }
}
