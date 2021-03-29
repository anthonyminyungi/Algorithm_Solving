package com.algorithms.BOJ.JAVA;

import java.io.*;

public class OctalToBinary_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            switch (a.charAt(i)) {
                case '0':
                    if (a.length() == 1) sb.append("0");
                    else sb.append("000");
                    break;
                case '1':
                    if (i == 0) sb.append("1");
                    else sb.append("001");
                    break;
                case '2':
                    if (i == 0) sb.append("10");
                    else sb.append("010");
                    break;
                case '3':
                    if (i == 0) sb.append("11");
                    else sb.append("011");
                    break;
                case '4':
                    sb.append("100");
                    break;
                case '5':
                    sb.append("101");
                    break;
                case '6':
                    sb.append("110");
                    break;
                case '7':
                    sb.append("111");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
