package com.algorithms.SWExpert_Academy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acronym_8741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] a = br.readLine().split(" ");
            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < a.length; j++) {
                char[] b = a[j].toCharArray();
                ans.append(b[0]);
            }
            System.out.println("#" + (i + 1) + " " + ans.toString().toUpperCase());
        }
    }
}
