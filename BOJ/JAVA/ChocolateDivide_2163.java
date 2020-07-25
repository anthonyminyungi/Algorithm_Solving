package com.algorithms.BOJ.JAVA;

import java.io.*;

public class ChocolateDivide_2163 {
    static int cut = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int size = Integer.parseInt(a[0]) * Integer.parseInt(a[1]);

        cutting(size);
        bw.append(cut + "");
        bw.flush();


    }

    static void cutting(int size) {
        int temp = size / 2;

        if (size == 1) {

            return;
        }
        if (size % 2 != 0) {
            cut++;
            cutting(size / 2 + 1);
            cutting(temp);

        } else {
            cut++;
            cutting(size / 2);
            cutting(temp);
        }
    }
}
