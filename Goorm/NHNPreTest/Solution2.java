package com.algorithms.Goorm.NHNPreTest;

// 시멘트 양 계산하기
public class Solution2 {
    public static void main(String[] args) {
        solution(2, 6, new int[][]{{6, 2, 11, 0, 3, 5}, {6, 3, 0, 9, 0, 5}}); // 20
        solution(3, 10, new int[][]{{6, 12, 0, 2, 8, 4, 0, 7, 3, 6}, {6, 1, 3, 0, 2, 8, 0, 0, 13, 8}, {6, 3, 0, 10, 6, 5, 7, 0, 0, 3}}); // 69
    }

    private static void solution(int day, int width, int[][] blocks) {
        int[] allBlocks = new int[width];
        int sum = 0;
        for (int d = 0; d < day; d++) {
            int[] todayBlocks = blocks[d];
            for (int i = 0; i < width; i++) allBlocks[i] += todayBlocks[i];
            sum += fill(allBlocks);
        }
        System.out.println(sum);
    }

    private static int fill(int[] allBlocks) {
        int lIdx = 0, rIdx = 0;
        int filled = 0;
        for (int i = 0; i < allBlocks.length; i++) {
            if (allBlocks[i] > allBlocks[lIdx]) {
                rIdx = i;
                for (int j = lIdx + 1; j < rIdx; j++) {
                    int diff = (allBlocks[lIdx] - allBlocks[j]);
                    allBlocks[j] += diff;
                    filled += diff;
                }
                lIdx = rIdx;
            }
        }

        lIdx = rIdx = allBlocks.length - 1;
        for (int i = allBlocks.length - 1; i >= 0; i--) {
            if (allBlocks[i] > allBlocks[rIdx]) {
                lIdx = i;
                for (int j = lIdx + 1; j < rIdx; j++) {
                    int diff = (allBlocks[rIdx] - allBlocks[j]);
                    allBlocks[j] += diff;
                    filled += diff;
                }
                rIdx = lIdx;
            }
        }
        return filled;
    }
}
