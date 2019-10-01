package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;

//c++코드 보고 공부하기
public class FlyCity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String[] aa = a.split(" ");
        int n = Integer.parseInt(aa[0]);
        int m = Integer.parseInt(aa[1]);
        int[][] city = new int[n + 1][n + 1];
        for (int[] row : city)
            Arrays.fill(row, 0);
//        for(int[] row: city)
//            System.out.println(Arrays.toString(row));

        for (int i = 0; i < m; i++) {
            String b = br.readLine();
            String[] bb = b.split(" ");
            int t1 = Integer.parseInt(bb[0]);
            int t2 = Integer.parseInt(bb[1]);
            city[t1][t2] = city[t2][t1] = 1;
        }
//        for (int[] row : city)
//            System.out.println(Arrays.toString(row));
    }
}
