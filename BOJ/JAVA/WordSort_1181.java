package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class WordSort_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String in = br.readLine();
            if (!list.contains(in))
                list.add(in);
        }
        Collections.sort(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() < o2.length())
                    return -1;
                else
                    return 0;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            bw.append(list.get(i) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
