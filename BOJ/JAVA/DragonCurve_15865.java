package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class DragonCurve_15865 {
    static int N;
    static int[][] map = new int[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            List<Integer> curves = new ArrayList<>(); // 드래곤 커브를 방향으로만 관리하기 위한 리스트 (0: right, 1: up, 2: left, 3: down)
            int[] xydg = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = xydg[0], y = xydg[1], d = xydg[2], g = xydg[3];
            curves.add(d);
            for (int j = 0; j < g; j++) {
                for (int k = curves.size() - 1; k >= 0; k--) { // 이전 세대만큼의 방향들을 거꾸로 순회하면서 1을 더해주면 해당 세대의 드래곤 커브가 완성됨.
                    curves.add((curves.get(k) + 1) % 4); // 4를 넘어갈 경우 4로 나눈 나머지를 취해주면 해당 방향을 가리킬 수 있음.
                }
            }

            map[y][x] = 1;
            for (int dir : curves) {
                x += dx[dir];
                y += dy[dir];
                map[y][x] = 1;
            }
        }

        System.out.println(solve());
    }

    static int solve() {
        int ret = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1)
                    ret++;
            }
        }

        return ret;
    }
}
