package com.algorithms.Goorm.SaramIn;

import java.io.*;
import java.util.*;

public class ChangingMedian {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        long prevNum = 1983;
        PriorityQueue<Long> max = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
        PriorityQueue<Long> min = new PriorityQueue<>(Comparator.comparingLong(o -> o));

        long res = 0;
        for (int i = 0; i < n; i++) {
            if (max.size() == min.size()) {
                max.add(prevNum);
            } else {
                min.add(prevNum);
            }
            prevNum = (prevNum * (a + b)) % 20090711;
            if (!max.isEmpty() && !min.isEmpty() && min.peek() < max.peek()) {
                long maxPop = max.poll();
                long minPop = min.poll();
                max.add(minPop);
                min.add(maxPop);
            }

            res += max.peek();
            res %= 20090711;
        }
        System.out.println(res);
    }
}
