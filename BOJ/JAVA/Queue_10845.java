package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

// 얘는 왜 리스트로 풀었는데도 통과되는걸까
public class Queue_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] inst = br.readLine().split(" ");
            switch (inst[0]) {
                case "push":
                    list.add(Integer.parseInt(inst[1]));
                    break;
                case "pop":
                    if (list.isEmpty())
                        bw.append("-1\n");
                    else {
                        bw.append(String.valueOf(list.get(0))).append("\n");
                        list.remove(list.get(0));
                    }
                    break;
                case "size":
                    bw.append(String.valueOf(list.size())).append("\n");
                    break;
                case "empty":
                    if (list.isEmpty())
                        bw.append("1\n");
                    else
                        bw.append("0\n");
                    break;
                case "front":
                    if (list.isEmpty())
                        bw.append("-1\n");
                    else
                        bw.append(String.valueOf(list.get(0))).append("\n");
                    break;
                case "back":
                    if (list.isEmpty())
                        bw.append("-1\n");
                    else
                        bw.append(String.valueOf(list.get(list.size() - 1))).append("\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
