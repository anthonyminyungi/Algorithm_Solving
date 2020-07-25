package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.ArrayDeque;

//리스트로 구현했을 때는 틀렸다고 뜸. 왜인지 모르겠음
public class Deque_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] inst = br.readLine().split(" ");
            switch (inst[0]) {
                case "push_back":
                    deque.addLast(Integer.parseInt(inst[1]));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(inst[1]));
                    break;
                case "pop_front":
                    if (deque.isEmpty())
                        bw.append("-1\n");
                    else {
                        bw.append(String.valueOf(deque.removeFirst())).append("\n");
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty())
                        bw.append("-1\n");
                    else {
                        bw.append(String.valueOf(deque.removeLast())).append("\n");
                    }
                    break;
                case "size":
                    bw.append(String.valueOf(deque.size())).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty())
                        bw.append("1\n");
                    else
                        bw.append("0\n");
                    break;
                case "front":
                    if (deque.isEmpty())
                        bw.append("-1\n");
                    else
                        bw.append(String.valueOf(deque.getFirst())).append("\n");
                    break;
                case "back":
                    if (deque.isEmpty())
                        bw.append("-1\n");
                    else
                        bw.append(String.valueOf(deque.getLast())).append("\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
