package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class WhoIsCharge_14724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] dong = {"PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY"};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String[] a = br.readLine().split(" ");
            int max1 = 0;
            for (int j = 0; j < a.length; j++) {
                max1 = Math.max(max1, Integer.parseInt(a[j]));
            }
            arrayList.add(max1);
        }
        ArrayList<Integer> temp = (ArrayList<Integer>) arrayList.clone();
        Collections.sort(temp);
        Object[] o = temp.toArray();
        Object[] o2 = arrayList.toArray();

        for (int i = 0; i < o2.length; i++) {
            if (o2[i].equals(o[8])) {
                bw.append(dong[i]);
                break;
            }
        }
        bw.flush();

    }
}
