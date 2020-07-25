package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ClosestPairPoints_2261 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(points, (a, b) -> (a.x - b.x));
        TreeSet<Point> set = new TreeSet<>((a, b) -> ((a.y == b.y) ? a.x - b.x : a.y - b.y));
        set.add(points[0]);
        set.add(points[1]);
        int answer = distSquare(points[0], points[1]);
        int start = 0;
        for (int i = 2; i < n; i++) {
            Point here = points[i];
            while (start < i) {
                Point p = points[start];
                int x = here.x - p.x;
                if (x * x > answer) {
                    set.remove(p);
                    start += 1;
                } else {
                    break;
                }
            }
            int d = (int) Math.sqrt((double) answer) + 1;
            Point from = new Point(-10001, here.y - d);
            Point to = new Point(10001, here.y + d);
            for (Point p : set.subSet(from, to)) {
                d = distSquare(here, p);
                answer = Math.min(answer, d);
            }
            set.add(here);
        }
        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();

    }

    static int distSquare(Point A, Point B) {
        return (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}