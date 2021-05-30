package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class MinimumCost_1916 {
    static final int INF = 987654321;
    static ArrayList<Road>[] adj;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1]; // 가급적 인접리스트 활용.
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        Arrays.fill(dist, INF);

        StringTokenizer st;
        int s, e, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            adj[s].add(new Road(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Road cur = pq.poll();
            // 가중치가 낮은 정점부터 탐색하고, 큐에 다시 넣을때에는 가중치의 합을 가진 채로 삽입하므로
            // 재방문 시에는 현재보다 반드시 큰 가중치를 갖는다는 의미이고, 이 경우 탐색의 의미가 없기 때문에, 즉 재방문시에는 반드시 continue.
            if (dist[cur.num] != cur.dist) continue;

            for (Road next : adj[cur.num]) {
                int nextNum = next.num, nextDist = next.dist;

                // 다음 방문할 지점의 가중치가 (현재 지점에서의 가중치합 + 둘 사이의 가중치) 보다 크다면
                // 최단거리로서 업데이트해야할 필요가 있다는 의미이므로 가중치 배열을 업데이트하고 큐에 삽입.
                if (dist[nextNum] > dist[cur.num] + nextDist) {
                    dist[nextNum] = dist[cur.num] + nextDist;
                    pq.offer(new Road(nextNum, dist[nextNum]));
                }
            }
        }
    }

    // 인접리스트를 활용해 각 시작점에 해당하는 도착점과 가중치를 연결할 것이기 때문에
    // 도착점과 해당 경로의 가중치만 갖는 클래스 생성.
    static class Road implements Comparable<Road> {
        int num, dist;

        Road(int n, int d) {
            this.num = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Road o) {
            return Integer.compare(this.dist, o.dist); // 우선순위 큐에서 가중치가 작은 순부터 탐색하기 위해
        }
    }
}
