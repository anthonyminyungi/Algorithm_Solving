package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Find_1786 {
    static LinkedHashSet<Integer> ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String T = br.readLine();
        String P = br.readLine();
        char[] tarr = T.toCharArray();
        char[] parr = P.toCharArray();
        int n = tarr.length;
        int m = parr.length;
//        String[] prefix = new String[m];
//        String[] suffix = new String[m];
        ret = new LinkedHashSet<Integer>();
//
//        System.out.println(Arrays.toString(tarr) + " / " + n);
//        System.out.println(Arrays.toString(parr) + " / " + m);

        kmpSearch(tarr, parr);
        bw.append(ret.size() + "\n");
        Iterator iterator = ret.iterator();
        while (iterator.hasNext())
            bw.append(iterator.next() + " ");
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
