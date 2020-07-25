package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Multitab_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String[] aa = a.split(" ");
        int N = Integer.parseInt(aa[0]);
        int K = Integer.parseInt(aa[1]);

        String b = br.readLine();
        String[] bb = b.split(" ");
        int[] usingOrder = new int[K];
        HashSet<Integer> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < bb.length; i++) {
            usingOrder[i] = Integer.parseInt(bb[i]) - 1;
            if (hashSet.size() >= N) {
                continue;
            } else {
                hashSet.add(usingOrder[i]);
            }
        }
        int[][] preProcess = new int[K][K];


//        System.out.println(hashSet);

        for (int i = K - 1; i >= 0; i--) {
            int temp = Integer.MAX_VALUE / 2;
            int d = 0;
            for (int j = K - 1; j >= 0; j--) {
                if (temp != Integer.MAX_VALUE / 2) {
                    temp++;
//                    d++;
//                    temp = d;
                }
                if (i == usingOrder[j]) {
                    temp = 0;
//                    if (d > 1)
//                        d--;
                }
                preProcess[i][j] = temp;
            }
        }
        int outcnt = 0;
        for (int i = N; i < K; i++) {
            int disc = -1;
            int getindex = 0;
            if (hashSet.contains(usingOrder[i]))
                continue;
            else {
                for (int j = 0; j < K; j++) {
                    Iterator iterator = hashSet.iterator();
                    while (iterator.hasNext()) {
                        int te = (int) iterator.next();
                        if (preProcess[te][i] > disc) {
                            getindex = te;
//                            System.out.println(getindex + "////");
                            disc = preProcess[getindex][i];
                        }
                    }
                }
                hashSet.remove(getindex);
                hashSet.add(usingOrder[i]);
//                System.out.println(hashSet);
                outcnt++;
            }
        }
        bw.append(outcnt + "");
//        for (int i = 0; i < K; i++) {
//            System.out.println(Arrays.toString(preProcess[i]));
//        }
        bw.flush();
        bw.close();
        br.close();

    }
}
