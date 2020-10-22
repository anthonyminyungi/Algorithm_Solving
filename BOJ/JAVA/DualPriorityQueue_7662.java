package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// PriorityQueue 와 TreeMap 은 동일하게 동작하지만 요소 별 접근이 가능한지에 대해 차이가 있다.
public class DualPriorityQueue_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Long> map = new TreeMap<>();

            while (k-- > 0) {
                String[] a = br.readLine().split(" ");
                if (a[0].equals("I")) {
                    long val = Long.parseLong(a[1]);
                    if (map.containsKey(val))
                        map.put(val, map.get(val) + 1);
                    else
                        map.put(val, 1L);
                } else {
                    if (map.isEmpty()) continue;
                    if (a[1].equals("1")) {
                        long max = map.lastKey();
                        long cnt = map.get(max) - 1;
                        if (cnt == 0) map.remove(max);
                        else map.put(max, cnt);
                    }
                    if (a[1].equals("-1")) {
                        long min = map.firstKey();
                        long cnt = map.get(min) - 1;
                        if (cnt == 0) map.remove(min);
                        else map.put(min, cnt);
                    }
                }
            }

            if (map.isEmpty())
                bw.write("EMPTY\n");
            else
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
