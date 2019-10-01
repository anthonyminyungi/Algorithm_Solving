package com.java;

import java.io.*;

public class ToAndFro4246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0)
                break;
            char[] s = br.readLine().toCharArray();
            char[][] arr = new char[s.length / a][a];
            int k = 0;
            int ll = 0;
            boolean isA = false;
            for (int i = 0; i < s.length / a; i++) {
                for (int j = 0; j < a; j++) {
                    if (k > a - 1) {
                        isA = true;
                        --k;
                    } else if (k < 0) {
                        isA = false;
                        ++k;
                    }
                    if (!isA) {
                        arr[i][k] = s[ll];
                        k++;
                    } else {
                        arr[i][k] = s[ll];
                        k--;
                    }

                    ll++;
                    System.out.println(arr[i][j]);
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < s.length / a; j++) {
                    bw.append(arr[j][i] + "");
                }
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
