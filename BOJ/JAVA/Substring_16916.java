package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.LinkedHashSet;

// 다시 풀어보기
// 풀이 참조 1786 찾기
public class Substring_16916 {
    static LinkedHashSet<Integer> ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String T = br.readLine();
        String P = br.readLine();
        char[] tarr = T.toCharArray();
        char[] parr = P.toCharArray();
        ret = new LinkedHashSet<>();

        kmpSearch(tarr, parr);
        bw.append(String.valueOf(ret.size() == 0 ? 0 : 1));
        bw.flush();
        bw.close();
        br.close();
    }

    static void kmpSearch(char[] T, char[] P) {
        int n = T.length, m = P.length;
        int[] pi = getPartialMatch(P);

        int begin = 0, matched = 0;

        while (begin <= n - m) {
            if (matched < m && T[begin + matched] == P[matched]) {
                ++matched;
                if (matched == m) ret.add(begin + 1);
            } else {
                if (matched == 0)
                    ++begin;
                else {
                    begin += matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }
    }

    static int[] getPartialMatch(char[] P) {
        int m = P.length;
        int[] pi = new int[m];

        int begin = 1, matched = 0;

        while (begin + matched < m) {
            if (P[begin + matched] == P[matched]) {
                ++matched;
                pi[begin + matched - 1] = matched;
            } else {
                if (matched == 0)
                    ++begin;
                else {
                    begin += matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }

        return pi;
    }
}