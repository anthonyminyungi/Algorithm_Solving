package com.algorithms.Programmers.DevMatching2020;

public class Programming2 {

    public static void main(String[] args) {
        int[][] o = {{5, -1, 4}, {6, 3, -1}, {2, -1, 1}};
        System.out.println(solution(o, 1, 0, new String[]{"go", "go", "right", "go", "right", "go", "left", "go"}));
    }

    public static int solution(int[][] office, int r, int c, String[] move) {
        int answer = 0;
        int rmax = office.length;
        int cmax = office[0].length;
        String dir = "north";
        answer += office[r][c];
        office[r][c] = 0;
        for (String inst : move) {
            switch (inst) {
                case "left":
                    switch (dir) {
                        case "north":
                            dir = "west";
                            break;
                        case "west":
                            dir = "south";
                            break;
                        case "south":
                            dir = "east";
                            break;
                        default:
                            dir = "north";
                            break;
                    }
                    break;
                case "right":
                    switch (dir) {
                        case "north":
                            dir = "east";
                            break;
                        case "east":
                            dir = "south";
                            break;
                        case "south":
                            dir = "west";
                            break;
                        default:
                            dir = "north";
                            break;
                    }
                    break;
                case "go":
                    switch (dir) {
                        case "north":
                            if (!(r - 1 < 0) && office[r - 1][c] != -1) r -= 1;
                            break;
                        case "west":
                            if (!(c - 1 < 0) && office[r][c - 1] != -1) c -= 1;
                            break;
                        case "south":
                            if (!(r + 1 >= rmax) && office[r + 1][c] != -1) r += 1;
                            break;
                        default:
                            if (!(c + 1 >= cmax) && office[r][c + 1] != -1) c += 1;
                            break;
                    }
                    answer += office[r][c];
                    office[r][c] = 0;
                    break;
            }
        }
        return answer;
    }
}
