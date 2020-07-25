package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.StringTokenizer;

public class Ring_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            int e = Integer.parseInt(st.nextToken());
            int gdcs = gdc(one, e);
            bw.append((one / gdcs) + "/" + (e / gdcs) + "\n");
        }
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
}
