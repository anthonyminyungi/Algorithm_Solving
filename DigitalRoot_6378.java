package com.java;

import java.io.*;

public class DigitalRoot_6378 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String a = (br.readLine());
            if (a.equals("0"))
                break;
            String temp = a;
            while (temp.length() >= 2) {
                char[] arr = temp.toCharArray();
                int tempsum = 0;
                for (int i = 0; i < arr.length; i++) {
                    tempsum += Integer.parseInt(String.valueOf(arr[i]));
                }
                temp = Integer.toString(tempsum);
            }
            bw.append(temp + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
