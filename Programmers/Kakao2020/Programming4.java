package com.algorithms.Programmers.Kakao2020;

// 시간 모자라서 못품. 다시 풀어보기

public class Programming4 {
    private static final int PATHWAY_COLOR = 0;
    //    private static final int WALL_COLOR = 1;
//    private static final int BLOCKED_COLOR = 2;
    private static final int PATH_COLOR = 3;
    private static int N;
    private static int[][] map;
    private static String direction = "up";
    private static int corner;
    private static int straight;

    public static void main(String[] args) {
        int[][] one = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        int[][] two = {
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}};

        int[][] three = {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {1, 0, 0, 0}
        };
        int[][] four = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
        };
        System.out.println(solution(two));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, map[i], 0, N);
        }
        findMazePath(0, 0);
        printMaze();
        calculate();
        return answer;
    }

    public static void calculate() {
        int x = 0, y = 0;
        boolean isEnd = x == N - 1 && y == N - 1;
        while (!isEnd) {
            if (map[x][y + 1] == PATH_COLOR) {
                if (!direction.equals("down"))
                    corner++;
                direction = "down";
                y++;
            } else if (map[x + 1][y] == PATH_COLOR) {
                if (!direction.equals("right"))
                    corner++;
                direction = "right";
                x++;
            }
        }
        System.out.println(corner - 1);
    }

    public static boolean findMazePath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return false;
        else if (map[x][y] != PATHWAY_COLOR)
            return false;
        else if (x == N - 1 && y == N - 1) {
            map[x][y] = PATH_COLOR;
            return true;
        } else {
            map[x][y] = PATH_COLOR;
            return findMazePath(x - 1, y) || findMazePath(x, y + 1)
                    || findMazePath(x + 1, y) || findMazePath(x, y - 1);
//            map[x][y] = BLOCKED_COLOR;
        }
    }

    private static void printMaze() {
        for (int x = 0; x < N; x++) {
            System.out.print("{");
            for (int y = 0; y < N; y++)
                System.out.print(map[x][y] + ", ");
            System.out.println("}");
        }
    }


}
