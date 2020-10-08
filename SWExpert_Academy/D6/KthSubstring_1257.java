package com.algorithms.SWExpert_Academy.D6;

import java.io.*;
import java.util.*;

public class KthSubstring_1257 {
    static List<String> substrings;
    static String[] split;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            String s = br.readLine();
            split = new String[s.length()];

            for (int j = 0; j < s.length(); j++)
                split[j] = s.substring(j);
            Arrays.sort(split);
            substrings = new ArrayList<>();
            getSubstrings(K);
            bw.append("#").append(String.valueOf(i + 1)).append(" ").append(K <= substrings.size() ? substrings.get(K - 1) : "none").append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void getSubstrings(int K) {
        loop:
        for (String s : split) {
            for (int j = 1; j <= s.length(); j++) {
                String str1 = s.substring(0, j);
                if (!substrings.contains(str1))
                    substrings.add(str1);
                if (substrings.size() == K)
                    break loop;
            }
        }
    }
}
