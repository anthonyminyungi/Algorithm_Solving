package com.java;

import java.io.*;

public class BaekDaeYeol_14490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(":");
        int n = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);
        int gdc = gdc(n, m);
        System.out.println(n / gdc + ":" + m / gdc);
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

}
