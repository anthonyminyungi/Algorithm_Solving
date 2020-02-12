package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AbsHeap_11286 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (Math.abs(o1) > Math.abs(o2))
                    return 1;
                else if (Math.abs(o1) < Math.abs(o2))
                    return -1;
                else {
                    if (o1 > o2)
                        return 1;
                    else if (o1 < o2)
                        return -1;
                    else
                        return 0;
                } // o1.compareTo(o2)로 간소화시킬 수 있지만 정렬 비교할때에는 항상 모든 경우의 수를 고려하자...
            }
        });
        for (int i = 0; i < N; i++) {
            long k = Long.parseLong(br.readLine());
            if (k != 0)
                queue.add(k);
            else {
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
