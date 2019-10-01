package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mul {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
//        int k = Integer.parseInt(a);
        String[] aa = a.split(" ");
        int n = Integer.parseInt(aa[0]);
        int m = Integer.parseInt(aa[1]);
//        int l = Integer.parseInt(aa[2]);
        String b = br.readLine();
        String[] bb = b.split(" ");
        int[] list = new int[n];
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(bb[i]);

        for (int j = 0; j < n; j++)
            if (list[j] < m)
                System.out.print(list[j] + " ");
    }
}
