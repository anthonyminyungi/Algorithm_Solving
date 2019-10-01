package com.java;

import java.io.*;

public class Back2018_16674 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String main = "2018";
        boolean isRel = false;
        boolean isClose = false;
        boolean isTied = false;
        int t = 0;
        int z = 0;
        int o = 0;
        int e = 0;
        int othrer = 0;
        String a = br.readLine();
        for (int i = 0; i < a.length(); i++) {
            if (main.contains(a.charAt(i) + "")) {
                if (a.charAt(i) == '2')
                    t++;
                else if (a.charAt(i) == '0')
                    z++;
                else if (a.charAt(i) == '1')
                    o++;
                else if (a.charAt(i) == '8')
                    e++;

            } else
                othrer++;
        }

        if (t >= 1 && othrer == 0 || z >= 1 && othrer == 0 || o >= 1 && othrer == 0 || e >= 1 && othrer == 0) {
            isRel = true;
            if (t >= 1 && z >= 1 && o >= 1 && e >= 1) {
                isClose = true;
                if (t == z && z == o && o == e) {
                    isTied = true;
                }
            }
        }

        if (isTied)
            System.out.println(8);
        else if (isClose)
            System.out.println(2);
        else if (isRel)
            System.out.println(1);
        else
            System.out.println(0);
    }

}
