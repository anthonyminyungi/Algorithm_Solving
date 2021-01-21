package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Cmd_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(br.readLine());
        }
        String target = list.get(0);
        Set<Integer> diffs = new HashSet<>();

        for (int i = 1; i < list.size(); i++) {
            String got = list.get(i);
            for (int j = 0; j < got.length(); j++) {
                if (target.charAt(j) != got.charAt(j))
                    diffs.add(j);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            if (diffs.contains(i))
                ans.append("?");
            else
                ans.append(target.charAt(i));
        }
        System.out.println(ans.toString());
    }
}
