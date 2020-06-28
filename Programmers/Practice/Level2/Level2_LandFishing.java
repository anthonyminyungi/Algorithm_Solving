package com.java.Programmers.Practice.Level2;

public class Level2_LandFishing {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }

    public static int solution(int[][] land) {
        int answer = 0;
        int[][] maxPoints = new int[land.length][4];
        System.arraycopy(land[0], 0, maxPoints[0], 0, 4);
        for (int i = 1; i < land.length; i++) {
            int v1 = Math.max(maxPoints[i - 1][1], maxPoints[i - 1][2]);
            maxPoints[i][0] = Math.max(maxPoints[i - 1][3], v1) + land[i][0];
            int v2 = Math.max(maxPoints[i - 1][0], maxPoints[i - 1][2]);
            maxPoints[i][1] = Math.max(maxPoints[i - 1][3], v2) + land[i][1];
            int v3 = Math.max(maxPoints[i - 1][0], maxPoints[i - 1][1]);
            maxPoints[i][2] = Math.max(maxPoints[i - 1][3], v3) + land[i][2];
            int v4 = Math.max(maxPoints[i - 1][0], maxPoints[i - 1][1]);
            maxPoints[i][3] = Math.max(maxPoints[i - 1][2], v4) + land[i][3];
        }
        for (int i = 0; i < 4; i++) {
            if (maxPoints[maxPoints.length - 1][i] > answer) {
                answer = maxPoints[maxPoints.length - 1][i];
            }
        }
        return answer;
    }
}
