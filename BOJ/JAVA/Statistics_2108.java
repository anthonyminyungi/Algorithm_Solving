package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Statistics_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> numbers = new HashMap<>();
        int[] values = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            values[i] = cur;
            sum += cur;
            if (numbers.containsKey(cur))
                numbers.put(cur, numbers.get(cur) + 1);
            else
                numbers.put(cur, 1);
        }
        Arrays.sort(values);
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(numbers.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue().equals(o2.getValue()))
                    return Integer.compare(o1.getKey(), o2.getKey());

                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        int target = list.get(list.size() - 1).getValue();
        list = list.stream().filter(v -> v.getValue() == target).collect(Collectors.toList());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue().equals(o2.getValue()))
                    return Integer.compare(o1.getKey(), o2.getKey());

                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });
        int avg = (int) Math.round((double) sum / N);
        int median = N % 2 == 0 ? values[(N / 2) - 1] : values[N / 2];
        int freq = list.size() > 1 ? list.get(1).getKey() : list.get(0).getKey();
        int range = values[N - 1] - values[0];
        bw.append(String.valueOf(avg)).append("\n");
        bw.append(String.valueOf(median)).append("\n");
        bw.append(String.valueOf(freq)).append("\n");
        bw.append(String.valueOf(range)).append("\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
