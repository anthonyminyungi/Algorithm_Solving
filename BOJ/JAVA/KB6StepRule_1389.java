package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class KB6StepRule_1389 {
    static int[][] friends;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        friends = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            friends[a][b] = friends[b][a] = 1;
        }

        List<KBNum> kbNums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int v = bfs(i, n);
            kbNums.add(new KBNum(i, v));
        }

        kbNums.sort((o1, o2) -> {
            if (o2.val < o1.val) return 1;
            else if (o2.val > o1.val) return -1;
            else return Integer.compare(o1.id, o2.id);
        });

        System.out.println(kbNums.get(0).id);
    }

    static int bfs(int start, int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i != start) {
                int cnt = 0;
                boolean[] visited = new boolean[n + 1];
                Queue<KB> q = new LinkedList<>();
                visited[start] = true;
                q.add(new KB(start, 0));

                while (!q.isEmpty()) {
                    KB cur = q.poll();
                    if (cur.id == i) {
                        cnt += cur.dist;
                        break;
                    }

                    for (int j = 1; j <= n; j++) {
                        if (friends[cur.id][j] == 1) {
                            int next = j;
                            if (visited[next]) continue;

                            visited[next] = true;
                            q.add(new KB(next, cur.dist + 1));
                        }
                    }
                }
                res += cnt;
            }
        }
        return res;
    }

    static class KB {
        int id, dist;

        KB(int i, int d) {
            this.id = i;
            this.dist = d;
        }
    }


    static class KBNum {
        int id, val;

        KBNum(int i, int v) {
            this.id = i;
            this.val = v;
        }
    }
}
