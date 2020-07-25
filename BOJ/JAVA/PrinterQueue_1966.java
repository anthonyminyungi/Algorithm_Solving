package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class PrinterQueue_1966 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            String[] nm = br.readLine().split(" ");
            int N = Integer.parseInt(nm[0]);
            int M = Integer.parseInt(nm[1]);
            String[] a = br.readLine().split(" ");
            queue.clear();
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                Pair pair = new Pair(j, Integer.parseInt(a[j]));
                max = Math.max(pair.priority, max);
                queue.add(pair);
            }
            int cnt = 0;
            while (!queue.isEmpty()) {
                int find = 0;
                while (true) {
                    if (!queue.isEmpty() && queue.peek().priority != max) {
                        queue.add(queue.remove());
                    } else {
                        find = queue.remove().index;
                        max = Integer.MIN_VALUE;
                        for (int l = 0; l < queue.size(); l++) {
                            Pair tmp = queue.remove();
                            max = Math.max(max, tmp.priority);
                            queue.add(tmp);
                        }
                        break;
                    }
                }
                cnt++;
                if (find == M)
                    break;
            }
            System.out.println(cnt);
        }
    }
}

class Pair {
    int index;
    int priority;

    Pair(int i, int p) {
        this.index = i;
        this.priority = p;
    }
}