package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;

public class DidntHW_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 28; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 1; i <= 30; i++) {
            if (!arrayList.contains(i))
                bw.append(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
