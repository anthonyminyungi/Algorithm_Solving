package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Ecology_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> trees = new HashMap<>();
        double total = 0.0;
        String in = "";
        while (!(in = br.readLine()).equals("")) {
            total++;
            if (!trees.containsKey(in)) {
                trees.put(in, 1);
            } else {
                trees.put(in, trees.get(in) + 1);
            }
        }
        List<String> keys = new ArrayList<>(trees.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            bw.append(key).append(" ").append(String.format("%.4f", trees.get(key) * 100 / total)).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
