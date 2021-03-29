package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class FourNumber_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Long.parseLong(in[0] + "" + in[1]) + Long.parseLong(in[2] + "" + in[3]));
    }
}
