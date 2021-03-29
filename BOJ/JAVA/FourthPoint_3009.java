package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class FourthPoint_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> xCounts = new HashMap<>();
        Map<Integer, Integer> yCounts = new HashMap<>();
        int[] p1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        xCounts.put(p1[0], 1);
        yCounts.put(p1[1], 1);
        int[] p2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (!xCounts.containsKey(p2[0])) xCounts.put(p2[0], 1);
        else xCounts.put(p2[0], xCounts.get(p2[0]) + 1);
        if (!yCounts.containsKey(p2[1])) yCounts.put(p2[1], 1);
        else yCounts.put(p2[1], yCounts.get(p2[1]) + 1);
        int[] p3 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (!xCounts.containsKey(p3[0])) xCounts.put(p3[0], 1);
        else xCounts.put(p3[0], xCounts.get(p3[0]) + 1);
        if (!yCounts.containsKey(p3[1])) yCounts.put(p3[1], 1);
        else yCounts.put(p3[1], yCounts.get(p3[1]) + 1);

        int resX = 0, resY = 0;
        for (Map.Entry<Integer, Integer> entry : xCounts.entrySet()) {
            if (entry.getValue() == 1) resX = entry.getKey();
        }
        for (Map.Entry<Integer, Integer> entry : yCounts.entrySet()) {
            if (entry.getValue() == 1) resY = entry.getKey();
        }
        System.out.println(resX + " " + resY);
    }
}
