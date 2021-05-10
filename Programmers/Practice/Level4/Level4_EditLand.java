package com.algorithms.Programmers.Practice.Level4;

public class Level4_EditLand {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}}, 3, 2));
        System.out.println(solution(new int[][]{{4, 4, 3}, {3, 2, 2}, {2, 1, 0}}, 5, 3));
    }

    // 직접 시도했던 풀이. 조잡하지만 기록용으로 저장.
//    static class BlockCount {
//        int num, cnt;
//
//        BlockCount(int n, int c) {
//            this.num = n;
//            this.cnt = c;
//        }
//    }
//
//    public static long solution(int[][] land, int P, int Q) {
//        double answer = Double.MAX_VALUE;
//        int n = land.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                map.put(land[i][j], map.getOrDefault(land[i][j], 0) + 1);
//            }
//        }
//        List<BlockCount> list = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            list.add(new BlockCount(entry.getKey(), entry.getValue()));
//        }
//
//        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).num > right) right = list.get(i).num;
//            if (list.get(i).num < left) left = list.get(i).num;
//        }
//
//        int mid;
//        long res1, res2;
//        while (left <= right) {
//            mid = (left + right) / 2;
//            res1 = calculate(mid, list, P, Q);
//            res2 = calculate(mid + 1, list, P, Q);
//
//            if (res1 < res2) {
//                right = mid - 1;
//                answer = res1;
//            } else {
//                answer = res2;
//                if (left == right) break;
//                left = mid + 1;
//            }
//        }
//        return (long) answer;
//    }
//
//    static long calculate(int h, List<BlockCount> list, int P, int Q) {
//        int sum = 0;
//        for (int j = 0; j < list.size(); j++) {
//            BlockCount cur = list.get(j);
//            if (cur.num > h) sum += (cur.num - h) * cur.cnt * Q;
//            else if (cur.num < h) sum += (h - cur.num) * cur.cnt * P;
//        }
//
//        return sum;
//    }
    public static long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
        int n = land.length;
        long left = Long.MAX_VALUE, right = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] > right) right = land[i][j];
                if (land[i][j] < left) left = land[i][j];
            }
        }

        long mid, res1, res2;
        while (left <= right) {
            mid = (left + right) / 2;
            res1 = calculate(mid, land, P, Q);
            res2 = calculate(mid + 1, land, P, Q);

            if (res1 < res2) {
                right = mid - 1;
                answer = res1;
            } else {
                answer = res2;
                if (res1 == res2) break;
                left = mid + 1;
            }
        }
        return answer;
    }

    static long calculate(long h, int[][] land, int P, int Q) {
        long sum = 0;
        int n = land.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] > h) sum += (land[i][j] - h) * Q;
                else if (land[i][j] < h) sum += (h - land[i][j]) * P;
            }
        }
        return sum;
    }
}
