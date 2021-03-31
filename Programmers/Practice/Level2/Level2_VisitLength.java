package com.algorithms.Programmers.Practice.Level2;

import java.util.*;

public class Level2_VisitLength {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
        System.out.println(solution("DDDDDDDDDDD"));
        System.out.println(solution("LRLRL"));
    }

    public static int solution(String dirs) {
        char[] dirArr = dirs.toCharArray();
        int[] curr = {0, 0};
        Map<Character, int[]> dirMap = new HashMap<>();
        dirMap.put('U', new int[]{1, 0});
        dirMap.put('R', new int[]{0, 1});
        dirMap.put('L', new int[]{0, -1});
        dirMap.put('D', new int[]{-1, 0});

        List<int[]> visited = new ArrayList<>();

        for (char dir : dirArr) {
            int[] d = dirMap.get(dir);
            int[] newPnt = {curr[0] + d[0] >= -5 && curr[0] + d[0] <= 5 ? curr[0] + d[0] : curr[0],
                    curr[1] + d[1] >= -5 && curr[1] + d[1] <= 5 ? curr[1] + d[1] : curr[1]};

            int[] newPath = {curr[0], curr[1], newPnt[0], newPnt[1]};
            int[] newPathReverse = {newPnt[0], newPnt[1], curr[0], curr[1]};


            boolean isVisitPath = false;
            for (int[] path : visited) {
                if ((path[0] == curr[0]) && (path[1] == curr[1]) && (path[2] == newPnt[0]) && (path[3] == newPnt[1])
                        || (path[0] == newPnt[0]) && (path[1] == newPnt[1]) && (path[2] == curr[0]) && (path[3] == curr[1])
                        || ((curr[0] == newPnt[0]) && (curr[1] == newPnt[1]))) {
                    isVisitPath = true;
                    break;
                }
            }
            curr = newPnt;

            if (!isVisitPath) {
                visited.add(newPath);
                visited.add(newPathReverse);
            }
        }
        return visited.size() / 2;
    }
}
