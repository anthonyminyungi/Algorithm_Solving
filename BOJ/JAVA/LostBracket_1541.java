package com.algorithms.BOJ.JAVA;

import java.io.*;

public class LostBracket_1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();
        int ans = 0;
        String tmp = "";
        char MINUS = '-';

        boolean isMinus = false;
        for (int i = 0; i <= in.length(); i++) {
            if (i == in.length() || !Character.isDigit(in.charAt(i))) {
                if (isMinus)
                    ans -= Integer.parseInt(tmp);
                else
                    ans += Integer.parseInt(tmp);

                if (i < in.length() && in.charAt(i) == MINUS)
                    isMinus = true;
                tmp = "";
                continue;
            }

            tmp += in.charAt(i);
        }

        System.out.println(ans);
    }
}
