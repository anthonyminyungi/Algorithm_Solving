package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MatrixMultiplicationOrder_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            if (i == 0) {
                arrayList.add(Integer.parseInt(tmp));
            }
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        int[] p = new int[arrayList.size()];
        for (int i = 0; i < p.length; i++) {
            p[i] = arrayList.get(i);
        }
        System.out.println(Matrix_Chain_Order(p));
    }

    private static int Matrix_Chain_Order(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        int j;
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }
        return m[1][m[1].length - 1];
    }
}
