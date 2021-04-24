package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Monitoring_15683 {
    static final int INF = 987654321;
    static int N, M;
    static int[][] map = new int[8][8];
    static int camCnt;
    static int[] campType = new int[8];
    static int[] camRow = new int[8];
    static int[] camCol = new int[8];
    static int[] dr = {0, -1, 0, 1}; // 0 = right, 1 = up, 2 = left, 3 = down;
    static int[] dc = {1, 0, -1, 0};
    static int[][] dcam = {
            {1, 0, 0, 0, 4},
            {1, 0, 1, 0, 2},
            {1, 1, 0, 0, 4},
            {1, 1, 1, 0, 4},
            {1, 1, 1, 1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        camCnt = 0;
        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = arr[j];
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    campType[camCnt] = map[i][j];
                    camRow[camCnt] = i;
                    camCol[camCnt++] = j;
                }
            }
        }

        System.out.println(solve(0));
    }

    static int solve(int pos) {
        if (pos == camCnt) { // 카메라 번호가 끝까지 도달하게 되면 종료 조건이 되므로 현재 맵의 사각지대 영역의 개수를 세서 반환
            int sum = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    if (map[i][j] == 0) sum++;
            return sum;
        }

        int[][] backup = new int[8][8];
        int ret = INF;

        int type = campType[pos] - 1; // 카메라 타입을 인덱스로 활용하기 위해 0부터 시작하도록
        for (int i = 0; i < dcam[type][4]; i++) { // i: 카메라 타입별 카메라 90도 회전의 경우의 수
            copyMap(backup, map); // 기존 맵을 백업
            for (int j = 0; j < 4; j++) { // j: 방향의 경우의 수
                if (dcam[type][j] == 1)
                    // 감시영역 마킹
                    watch(camRow[pos], camCol[pos], (i + j) % 4); // i+j:  90도 회전한 뒤 카메라가 감시할 수 있는 방향을 의미함. 90도 회전의 4방향을 의미하므로 4를 넘어갈 경우를 위해 4로 나눈 나머지로 적용
            }

            ret = Math.min(solve(pos + 1), ret); // 재귀호출을 통해 최종 결과값 중 가장 작은 값으로 재할당

            copyMap(map, backup); // 변경한 맵을 원상복구
        }

        return ret;
    }

    static void copyMap(int[][] dst, int[][] src) { // src의 값을 dst로 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dst[i][j] = src[i][j];
            }
        }
    }

    static void watch(int r, int c, int dir) {
        int sr = r, sc = c;

        while (true) {
            int nr = sr + dr[dir], nc = sc + dc[dir];
            if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1) return;
            if (map[nr][nc] == 6) return; // 벽일경우 감시 불가
            map[nr][nc] = 7; // 조건에서 사용되지 않는 숫자로 감시 영역 정의
            sr = nr;
            sc = nc;
        }
    }
}
