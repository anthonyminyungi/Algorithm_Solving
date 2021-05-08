package com.algorithms.Programmers.Kakao2021Intern;

import java.util.*;

public class Programming2 {
    static Queue<Person> q;
    static char[][] place;
    static int[][] orthogonal = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] diagonal = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        })));
    }

    static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int k = 0; k < 5; k++) {
            place = new char[5][5];
            q = new LinkedList<>();
            for (int i = 0; i < 5; i++) {
                place[i] = places[k][i].toCharArray();
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i][j] == 'P') q.offer(new Person(i, j));
                }
            }

            answer[k] = bfs() ? 1 : 0;
        }

        return answer;
    }

    static boolean bfs() {
        while (!q.isEmpty()) {
            Person cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + orthogonal[i][0], ny = cur.y + orthogonal[i][1];

                if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
                if (place[nx][ny] == 'P') return false;

                StringBuilder sb = new StringBuilder();
                sb.append(place[nx][ny]);
                boolean detected = false;
                while (true) {
                    nx += orthogonal[i][0];
                    ny += orthogonal[i][1];
                    if (nx < 0 || nx > 4 || ny < 0 || ny > 4) break;
                    if (place[nx][ny] == 'P') {
                        detected = true;
                        break;
                    }
                    sb.append(place[nx][ny]);
                }

                if (detected && sb.toString().equals("O")) {
                    return false;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + diagonal[i][0], ny = cur.y + diagonal[i][1];
                if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;

                if (place[nx][ny] == 'P') {
                    if (place[nx][cur.y] != 'X' || place[cur.x][ny] != 'X')
                        return false;
                }
            }
        }

        return true;
    }

    static class Person {
        int x, y;

        Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
