package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 처음에 너무 이상하게 접근했음. 진짜로 문자를 추가하는방식을 취할 필요가 없었음.
public class String_1120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray(), b = st.nextToken().toCharArray();
        int lenA = a.length, lenB = b.length;
        int lengthDiff = lenB - lenA, dif, answer = 987654321;
        for (int i = 0; i <= lengthDiff; i++) {
            dif = 0;
            for (int j = 0; j < lenA; j++) {
                if (a[j] != b[j + i]) dif++;
            }
            if (answer > dif) answer = dif;
        }
        System.out.println(answer);
    }
}
