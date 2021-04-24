package com.algorithms.BOJ.JAVA;

import java.io.*;

// 선택의 순서 영향 x -> 조합.
public class LadderManipulation_15864 {
    static final int INF = 987654321;
    static final int RIGHT = 1, LEFT = 2; // 사다리를 순회할 때, 해당 좌표를 만나게 되면 이동하게 될 방향을 의미.
    static int N, M, H;
    static int[][] ladders = new int[30][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmh = br.readLine().split(" ");
        N = Integer.parseInt(nmh[0]);
        M = Integer.parseInt(nmh[1]);
        H = Integer.parseInt(nmh[2]);

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            ladders[a - 1][b - 1] = RIGHT;
            ladders[a - 1][b] = LEFT;
        }

        int ans = solve(0, 0);
        System.out.println(ans == INF ? -1 : ans);
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            int row = 0, col = i;

            while (row != H) {
                if (ladders[row][col] == LEFT)
                    --col;
                else if (ladders[row][col] == RIGHT)
                    ++col;

                ++row; // LEFT, RIGHT 에 걸리면 이동 후 아래로, 안걸려도 무조건 아래로 한칸씩은 내려온다.
            }

            if (col != i) return false;
        }

        return true;
    }

    static int solve(int pos, int cnt) { // 두 가지 경우의 재귀호출을 통해서 조합을 구현
        if (cnt == 3 || pos >= N * H) {
            if (check())
                return cnt;
            else
                return INF;
        }

        int ret = INF;
        int row = pos / N, col = pos % N;
        if (col != N - 1 && ladders[row][col] == 0 && ladders[row][col + 1] == 0) { // 가로선을 넣을 수 있는 경우 ==> 넣는 경우
            ladders[row][col] = RIGHT;
            ladders[row][col + 1] = LEFT;
            ret = Math.min(solve(pos + 2, cnt + 1), ret);
            ladders[row][col] = ladders[row][col + 1] = 0;
        }
        ret = Math.min(solve(pos + 1, cnt), ret); // 가로선을 넣지 않는 경우

        return ret;
    }
}
