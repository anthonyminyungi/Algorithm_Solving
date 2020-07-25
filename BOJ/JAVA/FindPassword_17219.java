package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindPassword_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            map.put(in[0], in[1]);
        }
        for (int i = 0; i < m; i++) {
            bw.append(map.get(br.readLine())).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
