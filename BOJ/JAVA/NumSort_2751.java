package com.java.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class NumSort_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hashSet.add(Integer.parseInt(br.readLine()));
        }
//        System.out.println(hashSet);
        int[] arr = new int[hashSet.size()];

        int i = 0;
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            arr[i] = (int) iterator.next();
            i++;
        }
        Arrays.sort(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }
}
