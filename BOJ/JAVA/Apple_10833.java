package com.java.BOJ.JAVA;

import java.io.*;

public class Apple_10833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ing = 0;
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            int stu = Integer.parseInt(a[0]);
            int app = Integer.parseInt(a[1]);
            ing += app % stu;
        }
        bw.append(ing + "");
        bw.flush();
    }
}
