package com.java.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseBall_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            input[i][0] = Integer.parseInt(in[0]);
            input[i][1] = Integer.parseInt(in[1]);
            input[i][2] = Integer.parseInt(in[2]);
        }

        List<Integer> currentList = new ArrayList<>();
        List<Integer> prevList = new ArrayList<>();
        StringBuilder numset = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            numset.append((i));
            for (int j = 1; j <= 9; j++) {
                if (!numset.toString().contains(String.valueOf(j))) {
                    numset.append((j));

                    for (int l = 1; l <= 9; l++) {
                        if (!numset.toString().contains(String.valueOf(l))) {
                            numset.append((l));
                            prevList.add(Integer.parseInt(numset.toString()));
                            numset.deleteCharAt(2);
                        }
                    }
                    numset.deleteCharAt(1);
                }
            }
            numset = new StringBuilder();
        }

        for (int i = 0; i < input.length; i++) {
            int inputNumber = input[i][0];
            int inputStrike = input[i][1];
            int inputBall = input[i][2];
            for (int prev : prevList) {
                int[] checked = check(inputNumber, prev);
                if (inputStrike == checked[0] && inputBall == checked[1]) {
                    currentList.add(prev);
                }
            }
            prevList.clear();
            prevList.addAll(currentList);
            currentList.clear();
        }
        bw.append(String.valueOf(prevList.size()));
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] check(int src, int target) {
        int[] res = new int[2]; // 0: strike, 1: ball
        String strSrc = String.valueOf(src);
        String strTarget = String.valueOf(target);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (strSrc.charAt(i) == strTarget.charAt(i) && i == j) {
                    res[0]++;
                } else if (strSrc.charAt(i) == strTarget.charAt(j) && i != j) {
                    res[1]++;
                }
            }
        }
        return res;
    }
}
