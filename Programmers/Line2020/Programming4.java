package com.algorithms.Programmers.Line2020;

import java.util.*;

// 후기 풀이 보고 작성.
// 출처 : https://velog.io/@devgosunman/%ED%9B%84%EA%B8%B0-2020%EB%85%84-%ED%95%98%EB%B0%98%EA%B8%B0-SW%EA%B0%9C%EB%B0%9C-%EC%8B%A0%EC%9E%85-LINER-%EA%B3%B5%EA%B0%9C%EC%B1%84%EC%9A%A9-%EC%98%A8%EB%9D%BC%EC%9D%B8-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8

public class Programming4 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 1, 0}}));
    }

    public static int solution(int[][] maze) {
        int answer = 0;
        int size = maze.length;
        int x = 0, y = 0;
        String currentDirection = "R";
        Map<String, String[]> rotation = new HashMap<>();
        rotation.put("U", new String[]{"L", "U", "R", "D"});
        rotation.put("L", new String[]{"D", "L", "U", "R"});
        rotation.put("D", new String[]{"R", "D", "L", "U"});
        rotation.put("R", new String[]{"U", "R", "D", "L"});

        Map<String, int[]> direction = new HashMap<>();
        direction.put("U", new int[]{-1, 0});
        direction.put("L", new int[]{0, -1});
        direction.put("R", new int[]{0, 1});
        direction.put("D", new int[]{1, 0});

        while (true) {
            for (String r : rotation.get(currentDirection)) {
                int[] way = direction.get(r);
                int newX = x + way[0], newY = y + way[1];
                if (newX >= 0 && newX < size && newY >= 0 && newY < size && maze[newX][newY] == 0) {
                    x = newX;
                    y = newY;
                    currentDirection = r;
                    answer += 1;
                    break;
                }
            }
            if (x == maze.length - 1 && y == maze.length - 1)
                break;
        }

        return answer;
    }
}
