package com.java.BOJ.JAVA;

import java.io.*;

public class TaeboTaeboGatling_17249 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int leftcnt = 0;
        int rightcont = 0;

        String[] a = br.readLine().split("0");
        String left = a[0];
        String right = a[1];

        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) == '@') {
                leftcnt++;
            }
        }
        for (int i = 0; i < right.length(); i++) {
            if (right.charAt(i) == '@') {
                rightcont++;
            }
        }
        bw.append(leftcnt + " " + rightcont);
        bw.flush();
        bw.close();
        br.close();

    }
}
