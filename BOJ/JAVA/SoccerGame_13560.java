package com.java.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SoccerGame_13560 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < s.length; i++) {
            arrayList.add(Integer.parseInt(s[i]));
            sum += arrayList.get(i);
        }
        Collections.sort(arrayList);

        int combi = (n * (n - 1)) / 2;


        if (sum == combi) {
            if (arrayList.get(n - 1) == n - 1 && arrayList.get(n - 2).equals(arrayList.get(n - 1))) {
                bw.append("-1");
            } else if (arrayList.get(0) == 0 && arrayList.get(0).equals(arrayList.get(1))) {
                bw.append("-1");
            } else {
                int tempsum = 0;
                int trueflag = 0;
                for (int i = 1; i <= n; i++) {
                    tempsum += arrayList.get(i - 1);
                    if (tempsum >= (i * (i - 1)) / 2) {
                        trueflag++;
                        if (trueflag == n)
                            bw.append("1");
                    } else {
                        bw.append("-1");
                        break;
                    }
                }
            }
        } else
            bw.append("-1");
        bw.flush();
    }
}
