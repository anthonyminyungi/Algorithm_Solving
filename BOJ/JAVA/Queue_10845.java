package com.java.BOJ.JAVA;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Queue_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] inst = br.readLine().split(" ");
            if (inst[0].equals("push")) {
                list.add(Integer.parseInt(inst[1]));
            } else if (inst[0].equals("pop")) {
                if (list.isEmpty())
                    bw.append("-1\n");
                else {
                    bw.append(list.get(0) + "\n");
                    list.remove(list.get(0));
                }
            } else if (inst[0].equals("size")) {
                bw.append(list.size() + "\n");
            } else if (inst[0].equals("empty")) {
                if (list.isEmpty())
                    bw.append("1\n");
                else
                    bw.append("0\n");
            } else if (inst[0].equals("front")) {
                if (list.isEmpty())
                    bw.append("-1\n");
                else
                    bw.append(list.get(0) + "\n");
            } else if (inst[0].equals("back")) {
                if (list.isEmpty())
                    bw.append("-1\n");
                else
                    bw.append(list.get(list.size() - 1) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
