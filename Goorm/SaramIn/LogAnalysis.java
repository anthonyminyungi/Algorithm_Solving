package com.algorithms.Goorm.SaramIn;

import java.io.*;

public class LogAnalysis {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int byteNum = Integer.parseInt(br.readLine());
            String[] low = br.readLine().split("-");
            String[] high = br.readLine().split("-");
            String[] normal = br.readLine().split("-");

            int diffCnt = 0;
            for (int i = 0; i < byteNum; i++) {
                low[i] = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(low[i]))));
                high[i] = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(high[i]))));
                normal[i] = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(normal[i]))));
                for (int j = 0; j < 8; j++) {
                    if (low[i].charAt(j) == high[i].charAt(j) && high[i].charAt(j) == normal[i].charAt(j)) {
                    } else diffCnt++;
                }
            }

            bw.append(String.valueOf(diffCnt)).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
