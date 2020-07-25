package com.algorithms.SWExpert_Academy.D2;


import java.io.*;
import java.util.Base64;

public class Base64Decoder_1928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        Base64.Decoder decoder = Base64.getDecoder();
        for (int i = 1; i <= T; i++) {
            String encodedString = br.readLine();
            byte[] temp = decoder.decode(encodedString);
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < temp.length; j++) {
                result.append((char) temp[j]);
            }
            bw.append("#").append(String.valueOf(i)).append(" ").append(result.toString()).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
