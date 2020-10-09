package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class YootGame_2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, String> map = new HashMap<>();
        map.put("0111", "A");
        map.put("0011", "B");
        map.put("0001", "C");
        map.put("0000", "D");
        map.put("1111", "E");
        for (int i = 0; i < 3; i++) {
            String[] in = br.readLine().split(" ");
            Arrays.sort(in);
            String val = in[0] + in[1] + in[2] + in[3];
            bw.append(map.get(val)).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
