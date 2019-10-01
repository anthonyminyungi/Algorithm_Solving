
package com.java.CodeForces.R587_Div3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Codeforces_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] a = br.readLine().split(" ");
        int[] seq = new int[a.length];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arrayList.add(Integer.parseInt(a[i]));
        }
        Object[] origin = arrayList.toArray();
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;

        for (int i = 0; i < origin.length; i++) {
            int max = 0;
            for (int j = 0; j < origin.length; j++) {
                if ((int) origin[j] > max && (int) origin[j] != -1) {
                    index = j + 1;
                    max = (int) origin[j];
                }
                if (j == origin.length - 1) {
                    origin[index - 1] = -1;
                    if (i == 0)
                        stringBuilder.append(index);
                    else
                        stringBuilder.append(" " + index);
                }
            }
        }
        ArrayList<Integer> t = (ArrayList<Integer>) arrayList.clone();
        Collections.sort(t);
        Collections.reverse(t);
        Object[] sorted = t.toArray();

        int shots = 0;
        for (int i = 0; i < sorted.length; i++) {
            shots += ((int) sorted[i] * i) + 1;
        }
        bw.append(shots + "\n");
        bw.append(stringBuilder.toString());

        bw.flush();

    }
}
