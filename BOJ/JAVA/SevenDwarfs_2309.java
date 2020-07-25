package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SevenDwarfs_2309 {
    static List<int[]> list = new LinkedList<>();

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] tall = new int[9];
        int[] com = new int[9];
        int[] answer = new int[7];
        for (int i = 0; i < 9; i++) {
            tall[i] = Integer.parseInt(br.readLine());
        }
        combination(com, 0, 9, 7, 0);
        for (int[] ints : list) {
            int sum = 0;
            for (int i = 0; i < ints.length; i++) {
                sum += tall[ints[i]];
                answer[i] = tall[ints[i]];
            }
            if (sum == 100)
                break;

        }
        Arrays.sort(answer);
        for (int value : answer) {
            System.out.println(value);
        }
    }

    public static void combination(int[] arr, int index, int n, int r, int target) {
        if (r == 0) {
            int[] a = new int[index];
            System.arraycopy(arr, 0, a, 0, index);
            list.add(a);
        } else if (target == n) return;
        else {
            arr[index] = target;
            combination(arr, index + 1, n, r - 1, target + 1);
            combination(arr, index, n, r, target + 1);
        }
    }
}
