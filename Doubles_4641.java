package com.java;

import java.io.*;

public class Doubles_4641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] a = br.readLine().split(" ");
            int cnt = 0;
            if (Integer.parseInt(a[0]) == -1)
                break;
            for (int i = 0; i < a.length - 1; i++) {
                int var = Integer.parseInt(a[i]);
                for (int j = 0; j < a.length - 1; j++) {
                    if (j == i)
                        continue;
                    int comp = Integer.parseInt(a[j]);
                    if (var * 2 == comp)
                        cnt++;

                }
            }
            bw.append(cnt + "\n");


        }
        bw.flush();
        bw.close();
        br.close();
    }
}
