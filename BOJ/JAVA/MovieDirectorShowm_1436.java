package com.java.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDirectorShowm_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (list.size() < 10000) {
            if (String.valueOf(i).contains("666")) {
                list.add(i);
            }
            if (list.size() == N)
                break;
            i++;
        }
        System.out.println(list.get(list.size() - 1));
    }
}
