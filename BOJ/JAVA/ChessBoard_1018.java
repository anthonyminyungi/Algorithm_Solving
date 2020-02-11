package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ChessBoard_1018 {
    public static void main(String[] args) throws IOException {
        char[][] ex1 = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
        char[][] ex2 = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        int col = Integer.parseInt(size[0]);
        int row = Integer.parseInt(size[1]);
        List<Integer> list = new LinkedList<>();
        char[][] comp = new char[col][row];

        for (int i = 0; i < col; i++) {
            comp[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <= col - 8; i++) {
            for (int j = 0; j <= row - 8; j++) {
                int diffcnt1 = 0;
                int diffcnt2 = 0;
                int cidx = 0;
                for (int k = i; k < i + 8; k++) {
                    int ridx = 0;
                    for (int l = j; l < j + 8; l++) {
                        if (comp[k][l] != ex1[cidx][ridx])
                            diffcnt1++;
                        if (comp[k][l] != ex2[cidx][ridx])
                            diffcnt2++;
                        ridx++;
                    }
                    cidx++;
                }
                list.add(diffcnt1);
                list.add(diffcnt2);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}