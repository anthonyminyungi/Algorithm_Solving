package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap_11279 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o2 - o1);
            }
        });
        for (int i = 0; i < N; i++) {
            long k = Long.parseLong(br.readLine());
            if (k > 0)
                queue.add(k);
            if (k == 0) {
                if (queue.isEmpty())
                    bw.append("0\n");
                else
                    bw.append(String.valueOf(queue.remove())).append("\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
