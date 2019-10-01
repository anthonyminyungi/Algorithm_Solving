package com.java.BOJ.JAVA;

import java.io.*;
import java.util.HashMap;

public class SNS2 {
    static HashMap hashMap = new HashMap();
    static int[] parent;


    public static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < tc; i++) {
            int f = Integer.parseInt(br.readLine());
            parent = new int[2 * f];
            for (int j = 0; j < 2 * f; j++) {
                parent[j] = j;
            }
            String[][] rf = new String[f][2];
            for (int j = 0; j < f; j++) {
                String line = br.readLine();
                String[] Friends = line.split(" ");
                for (int k = 0; k < 2; k++)
                    rf[j][k] = Friends[k];
            }
            for (int j = 0; j < f; j++) {
                for (int k = 0; k < 2; k++) {
                    String e = rf[j][k];
                    if (!hashMap.containsKey(e)) {
                        hashMap.put(e, cnt);
                        cnt++;
                    }
                }
            }
            for (int j = 0; j < f; j++) {
                for (int k = 0; k < 2; k += 2) {
//                    System.out.println(union((int) hashMap.get(rf[j][k]), (int) hashMap.get(rf[j][k + 1])));
                }
            }
            cnt = 0;
            hashMap.clear();
        }
        bw.flush();
        bw.close();
    }
}

