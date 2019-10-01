package com.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ParkingGod_5054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] a = br.readLine().split(" ");
            int sum = 0;
            for (int j = 0; j < n; j++) {
                arrayList.add(Integer.parseInt(a[j]));
            }
            Collections.sort(arrayList);
            for (int j = 1; j < arrayList.size(); j++) {
                sum += (arrayList.get(j) - arrayList.get(j - 1));
            }
            sum += (arrayList.get(n - 1) - arrayList.get(0));
            bw.append(sum + "\n");
            arrayList.clear();
        }
        bw.flush();
    }
}
