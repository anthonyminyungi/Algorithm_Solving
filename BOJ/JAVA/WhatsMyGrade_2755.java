package com.java.BOJ.JAVA;

import java.io.*;

public class WhatsMyGrade_2755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        double sum = 0;
        int psum = 0;
        for (int i = 0; i < t; i++) {
            String[] a = br.readLine().split(" ");
            int num = Integer.parseInt(a[1]);
            psum += num;
            double gr = 0;
            switch (a[2]) {
                case "A+":
                    gr = 4.3;
                    break;
                case "A0":
                    gr = 4.0;
                    break;
                case "A-":
                    gr = 3.7;
                    break;
                case "B+":
                    gr = 3.3;
                    break;
                case "B0":
                    gr = 3.0;
                    break;
                case "B-":
                    gr = 2.7;
                    break;
                case "C+":
                    gr = 2.3;
                    break;
                case "C0":
                    gr = 2.0;
                    break;
                case "C-":
                    gr = 1.7;
                    break;
                case "D+":
                    gr = 1.3;
                    break;
                case "D0":
                    gr = 1.0;
                    break;
                case "D-":
                    gr = 0.7;
                    break;
                case "F":
                    gr = 0.0;
                    break;
            }
            sum += (num * gr);
        }
//        System.out.println(sum/psum-0.00000001);
        System.out.println(String.format("%.2f", (sum / psum + 0.00000001)));
    }
}
