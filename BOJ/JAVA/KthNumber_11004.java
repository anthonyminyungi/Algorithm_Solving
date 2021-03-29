package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class KthNumber_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        Collections.sort(list);
        System.out.println(list.get(k - 1));
    }
}
