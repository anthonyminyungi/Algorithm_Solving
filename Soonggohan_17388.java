package com.java;

import java.io.*;

public class Soonggohan_17388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int S = Integer.parseInt(a[0]);
        int K = Integer.parseInt(a[1]);
        int H = Integer.parseInt(a[2]);

        if (S + K + H >= 100)
            bw.append("OK");
        else {
            int min = Math.min(S, K);
            min = Math.min(min, H);


            if (min == S)
                bw.append("Soongsil");
            else if (min == K)
                bw.append("Korea");
            else if (min == H)
                bw.append("Hanyang");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
