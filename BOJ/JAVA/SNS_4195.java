package com.java.BOJ.JAVA;

import java.io.*;
import java.util.HashMap;

public class SNS_4195 {
    static HashMap hashMap = new HashMap();

    public static String find(String x) {
        if (hashMap.get(x) == null) {
            hashMap.put(x, 1 + "");
            return x;
        }
        if (Character.isDigit(hashMap.get(x).toString().charAt(0)))
            return x;
        else
            return find(hashMap.get(x).toString());
    }

    public static int union(String x, String y) {

        String p = find(x);
        String q = find(y);
        if (p.equals(q))
            return Integer.parseInt(hashMap.get(p).toString());

        int a = Integer.parseInt(hashMap.get(p).toString());
        int b = Integer.parseInt(hashMap.get(q).toString());
        if (a > b) {
            hashMap.replace(p, (a + b) + "");
            hashMap.replace(q, p);
            return Integer.parseInt(hashMap.get(p).toString());
        } else {
            hashMap.replace(p, q);
            hashMap.replace(q, (a + b) + "");
            return Integer.parseInt(hashMap.get(q).toString());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int f = Integer.parseInt(br.readLine());
            for (int j = 0; j < f; j++) {
                String line = br.readLine();
                String[] Friends = line.split(" ");
                String f1 = Friends[0];
                String f2 = Friends[1];
                bw.write(union(f1, f2) + "\n");
            }
            hashMap.clear();
        }
        bw.flush();
        bw.close();
    }
}