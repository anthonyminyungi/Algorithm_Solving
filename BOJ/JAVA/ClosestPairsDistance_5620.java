package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class ClosestPairsDistance_5620 {
    private static int dist(Point p1, Point p2) { //두 좌표사이의 거리를 구하는 메소드
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    private static int bruteForce(List<Point> a, int x, int y) { //완전 탐색으로 가장 가까운 거리 찾기
        int ans = -1;
        for (int i = x; i <= y; i++) {
            for (int j = i + 1; j <= y; j++) {
                int k = dist(a.get(i), a.get(j));
                if (ans == -1 || ans > k)
                    ans = k;
            }
        }
        return ans;
    }

    static int closest(List<Point> a, int x, int y) {
        int n = y - x + 1;
        if (n <= 3) { //n이 3이하면 완전탐색으로 x부터 y까지 가장 가까운 두 점 사이의 거리를 찾는다.
            return bruteForce(a, x, y);
        }

        int mid = (x + y) / 2;
        int left = closest(a, x, mid);
        int right = closest(a, mid + 1, y);
        int ans = Math.min(left, right);
        List<Point> b = new ArrayList<>(); //왼쪽과 오른쪽 사이의 점들을 저장할 List

        for (int i = x; i <= y; i++) {
            int d = a.get(i).x - a.get(mid).x;
            if (d * d < ans) {
                b.add(a.get(i));
            }
        }

        Collections.sort(b, new PointComparator()); //y좌표순으로 정렬
        int m = b.size();
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                double k = b.get(j).y - b.get(i).y;
                if (k * k < ans) {
                    int d = dist(b.get(i), b.get(j));
                    if (d < ans) {
                        ans = d;
                    }
                } else { //y좌표 순으로 정렬했기 때문에 앞의 가장 가까운 점이 ans보다 크면 더 볼필요가 없다.
                    break;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Point> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a.add(new Point(x, y));
        }
        Collections.sort(a);
        bw.write(closest(a, 0, n - 1) + "");
        bw.flush();
    }

}

class PointComparator implements Comparator<Point> { //y좌표 순으로 정렬하기 위한 Comparator

    @Override
    public int compare(Point o1, Point o2) {
        return (o1.y - o2.y);
    }

}

class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            if (this.y > o.y) {
                return 1;
            } else if (this.y < o.y) {
                return -1;
            } else return 0;
        } else if (this.x < o.x) {
            return -1;
        } else return 1;

    }
}