package com.algorithms.BOJ.JAVA;

import java.io.*;

public class lcm_gdc_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int k = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);

        bw.append(gdc(k, m) + "\n");
        bw.append(lcm(k, m) + "");
        bw.flush();
        bw.close();
        br.close();

    }

    static int gdc(int a, int b) //최대공약수를 반환하는 함수

    {
        int i, j;
        int temp = 1; //공약수를 저장할 변수
        j = (a < b) ? a : b; //둘중 작은수를 구함


        for (i = 1; i <= j; i++) {

            if (a % i == 0 && b % i == 0)

                temp = i;

        }


        return temp;

    }


    static int lcm(int a, int b) //최소공배수를 반환하는 함수

    {

        int i, j;

        int temp; //공배수를 저장할 변수


        j = (a > b) ? a : b; //둘중 큰수를 구함

        for (i = j; ; i++) {

            if (i % a == 0 && i % b == 0) {

                temp = i;

                break;

            }

        }


        return temp;

    }

}
