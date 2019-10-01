package com.java.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SortInside_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        while (N != 0) {
            al.add(N % 10);
            N /= 10;
        }
        Collections.sort(al);
        Collections.reverse(al);
        Iterator it = al.iterator();
        while (it.hasNext())
            bw.append(it.next() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
