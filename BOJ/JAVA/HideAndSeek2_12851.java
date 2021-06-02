package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

/**
 * 두가지 풀이로 풀어봄
 * 1. visited 배열이 아니라 visited count 와 방문 시간 두 배열을 활용해 다음 단게인 경우만 체크하는 방식
 * https://www.acmicpc.net/submit/12851/29769028 188ms 60mb
 * 2. visited 배열을 활용하고 큐에서 뽑을 때 방문 처리해서 최소시간과 일치할때만 카운트하는 방식
 * https://www.acmicpc.net/source/29769525 280ms 145mb
 * <p>
 * 첫번째 풀이가 확실히 더 빠르고 메모리를 적게 쓰는 걸 볼 수 있었다.
 */
public class HideAndSeek2_12851 {
    static final int minPos = 0, maxPos = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] answer = bfs(n, k);
        System.out.println(answer[0] + "\n" + answer[1]);
    }

    static int[] bfs(int n, int k) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[maxPos + 1];
        q.add(new int[]{n, 0});
        visited[n] = true;

        int minTime = -1, visitCnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]] = true;

            if (cur[0] == k) {
                if (minTime == -1) {
                    minTime = cur[1];
                    visitCnt++;
                } else if (minTime == cur[1])
                    visitCnt++;
            }

            int[] next = {cur[0] - 1, cur[0] + 1, cur[0] * 2};

            for (int i = 0; i < 3; i++) {
                if (next[i] >= minPos && next[i] <= maxPos && !visited[next[i]])
                    q.add(new int[]{next[i], cur[1] + 1});
            }
        }

        return new int[]{minTime, visitCnt};
    }
}
