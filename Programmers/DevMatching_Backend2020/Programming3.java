package com.algorithms.Programmers.DevMatching_Backend2020;

import java.util.*;

// 풀긴 풀었는데 제출 전에 시험이 끝나 제출을 못해봐서 맞는지는 모르겠음.
// 주어진 테스트만 통과.
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(solution(10, new int[][]{{1, 5}, {2, 7}, {4, 8}, {3, 6}}));
        System.out.println(solution(7, new int[][]{{6, 7}, {1, 4}, {2, 4}}));
        System.out.println(solution(100, new int[][]{{1, 50}, {1, 100}, {51, 100}}));
    }

    public static int solution(int n, int[][] groups) {
        int answer = 0;

        List<GroupWork> works = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        works.add(new GroupWork(groups[0], (groups[0][1] - groups[0][0] + 1), 1));

        for (int i = 1; i < groups.length; i++) {
            int[] cur = groups[i];
            int currentSize = works.size();
            for (int j = 0; j < currentSize; j++) {
                int[] prev = works.get(j).group;
                int prevCnt = works.get(j).groupCount;
                int prevCov = works.get(j).coverage;

                if (prev[1] > cur[0]) {
                    if (prev[0] > cur[0] && prevCov + (prev[0] - cur[0]) < n) {
                        works.add(new GroupWork(prev, prevCov + (prev[0] - cur[0]), prevCnt + 1));
                    }

                    if (prev[1] < cur[1] && prevCov + (cur[1] - prev[1]) < n) {
                        works.add(new GroupWork(prev, prevCov + (cur[1] - prev[1]), prevCnt + 1));
                    }
                } else {
                    if (prevCov + (cur[1] - cur[0] + 1) < n)
                        works.add(new GroupWork(prev, prevCov + (cur[1] - cur[0] + 1), prevCnt + 1));
                }


            }
            works.add(new GroupWork(cur, (cur[1] - cur[0] + 1), 1));
        }
        works.sort(new Comparator<GroupWork>() {
            @Override
            public int compare(GroupWork o1, GroupWork o2) {
                int totalA = n - o1.coverage + o1.groupCount;
                int totalB = n - o2.coverage + o2.groupCount;

                return Integer.compare(totalA, totalB);
            }
        });

//        for (int i = 0; i < works.size(); i++) {
//            System.out.println(Arrays.toString(works.get(i).group) + " " + works.get(i).coverage + " " + works.get(i).groupCount);
//        }

        answer = works.get(0).groupCount + (n - works.get(0).coverage);

        return answer;
    }

    static class GroupWork {
        int[] group;
        int coverage;
        int groupCount;

        GroupWork(int[] gr, int cv, int gc) {
            this.group = gr;
            this.coverage = cv;
            this.groupCount = gc;
        }
    }
}
