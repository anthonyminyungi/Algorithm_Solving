package com.java;

import java.io.*;

public class Vowel_1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String vowel = "aeiouAEIOU";
        while (true) {
            int cnt = 0;
            String a = br.readLine();
            System.out.println(a);
            if (a.contains("#"))
                break;
            char[] arr = a.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                String b = "" + arr[i];
                if (vowel.contains(b) && b != " ") {
                    cnt++;
                }
            }
            bw.append(cnt + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
