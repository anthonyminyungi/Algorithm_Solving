package com.algorithms.CodeForces.R587_Div3;

import java.io.*;

public class Codeforce_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int len = Integer.parseInt(br.readLine());
        String a = br.readLine();

        int cnt = 0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len - 1; i += 2) {
            String s = a.substring(i, i + 2);
            if (s.equals("aa")) {
                temp.append("ab");
            } else if (s.equals("bb")) {
                temp.append("ab");
            } else
                temp.append(s);
        }
        String t = temp.toString();
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != t.charAt(i))
                cnt++;
            else
                cnt += 0;
        }
        bw.append(cnt + "\n");
        bw.append(temp);
        bw.flush();

    }
}
