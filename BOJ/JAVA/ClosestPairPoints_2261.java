package com.java.BOJ.JAVA;

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
//public static void main(String... args) throws IOException {
//		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer parser = new StringTokenizer(input.readLine());
//		Point points[] = new Point[Integer.parseInt(parser.nextToken())];
//
//		for (int index = 0; index < points.length; index++) {
//			parser = new StringTokenizer(input.readLine());
//			points[index] = new Point(Integer.parseInt(parser.nextToken()), Integer.parseInt(parser.nextToken()));
//		}
//
//		quickSort(points, 0, points.length - 1, true);
//		int smallestDistance = closestPair(points, 0, points.length - 1);
//		System.out.println((smallestDistance == Integer.MAX_VALUE) ? 0 : smallestDistance);
//	}
//
//	private static int closestPair(Point[] array, int start, int end) {
//		int delta = Integer.MAX_VALUE;
//		int length = end - start + 1;
//
//		if (length <= 2)
//			return distance(array[start], array[end]);
//
//		int mid = (start + end) / 2;
//		int alpha = closestPair(array, start, mid);
//		int beta = closestPair(array, mid + 1, end);
//		delta = Math.min(alpha, beta);
//
//		int lengthOfBand = 0;
//		Point[] band = new Point[length];
//		for (int index = start; index <= end; index++)
//			if (square(array[index].x - array[mid].x) <= delta)
//				band[lengthOfBand++] = array[index];
//
//		quickSort(band, 0, lengthOfBand - 1, false);
//
//		for (int i = 0; i < lengthOfBand; i++) {
//			for (int j = i + 1; j < i + 12 && j < lengthOfBand; j++) {
//				int tempDistance = distance(band[i], band[j]);
//
//				if (tempDistance < delta) {
//					delta = tempDistance;
//					break;
//				}
//			}
//		}
//
//		return delta;
//	}
//
//	private static int distance(Point first, Point second) {
//		int distance = square(first.x - second.x) + square(first.y - second.y);
//		return (distance == 0) ? Integer.MAX_VALUE : distance;
//	}
//
//	private static int square(int x) {
//		return x * x;
//	}
//
//	private static void quickSort(Point[] array, int low, int high, boolean coordinate) {
//		if (array == null || array.length == 0)
//			return;
//		if (low >= high)
//			return;
//
//		int middle = low + (high - low) / 2;
//		int pivot = coordinate ? array[middle].x : array[middle].y;
//		int i = low, j = high;
//
//		while (i <= j) {
//			while ((coordinate ? array[i].x : array[i].y) < pivot)
//				i++;
//			while ((coordinate ? array[j].x : array[j].y) > pivot)
//				j--;
//
//			if (i <= j) {
//				Point temp = array[i];
//				array[i] = array[j];
//				array[j] = temp;
//				i++;
//				j--;
//			}
//		}
//
//		if (low < j)
//			quickSort(array, low, j, coordinate);
//		if (high > i)
//			quickSort(array, i, high, coordinate);
//	}
//
//	private static class Point {
//		public int x;
//		public int y;
//
//		public Point(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}