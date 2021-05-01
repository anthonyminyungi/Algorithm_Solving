package com.algorithms.Programmers.Line2021Intern;

import java.util.*;

// 미제출
// 정확히 맞는지는 모르겠지만 시험 후 몇시간동안 고민을 거듭해서 스스로 해결완료.
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 3}, {3, 2}, {5, 4}}));
        System.out.println(solution(new int[][]{{0, 3}, {5, 4}}));
        System.out.println(solution(new int[][]{{0, 1}, {0, 2}, {6, 3}, {8, 4}}));
        System.out.println(solution(new int[][]{{5, 2}, {2, 2}, {6, 3}, {9, 2}}));
    }

    public static int solution(int[][] ads) {
        int answer = 0;
        PriorityQueue<Ad> pq = new PriorityQueue<>();
        for (int i = 0; i < ads.length; i++) {
            pq.add(new Ad(ads[i][0], ads[i][1], i));
        }

        List<Ad> overwrap = new ArrayList<>();
        while (!pq.isEmpty()) {
            Ad curr = pq.poll();
            int startTime = curr.startTime;
            while (!pq.isEmpty() && pq.peek().startTime < startTime + 5) {
                overwrap.add(pq.poll());
            }

            while (!overwrap.isEmpty()) {
                Ad ad = overwrap.remove(0);
                answer += (startTime + 5 - ad.startTime) * ad.cost;
                ad.delayedTime += (startTime + 5 - ad.startTime);
                ad.startTime = startTime + 5;
                pq.add(ad);
            }
        }

        return answer;
    }

    public static class Ad implements Comparable<Ad> {
        public int startTime, cost, id, delayedTime;

        Ad(int s, int c, int i) {
            this.startTime = s;
            this.cost = c;
            this.id = i;
            this.delayedTime = 0;
        }


        @Override
        public int compareTo(Ad o) {
            if (this.startTime > o.startTime) return 1;
            else if (this.startTime < o.startTime) return -1;
            else {
                if ((this.delayedTime + 5) * this.cost < (o.delayedTime + 5) * o.cost) return 1;
                else if ((this.delayedTime + 5) * this.cost > (o.delayedTime + 5) * o.cost) return -1;
                return 0;
            }
        }
    }
}
