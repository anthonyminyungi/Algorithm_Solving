package com.java.BOJ.JAVA;

import java.io.*;

public class Stick_1094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int stick = 64;
        int X = Integer.parseInt(br.readLine());
        int sum = 0;
        int cnt = 0;

        int temp = X;
        int[] sticks = {1, 2, 4, 8, 16, 32, 64};
        while (sum != X) {
            for (int i = sticks.length - 1; i >= 0; i--) {
                if (sticks[i] <= temp) {
                    cnt++;
                    sum += sticks[i];
                    temp -= sticks[i];
                    break;
                }
            }
        }

//        while (true) {
//            int half1 = stick / 2;
//            int half2 = stick / 2;
//            if (half1 + half2 > X) {
//                stick /= 2;
//            }
//            int half2_2 = half2 / 2;
//            if (half2_2 + half1 >= X) {
//                half2 /= 2;
//                continue;
//            }
//        }


        bw.append(cnt + "");
        bw.flush();


    }
}
