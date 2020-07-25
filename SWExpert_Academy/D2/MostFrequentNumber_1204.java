package com.algorithms.SWExpert_Academy.D2;

import java.io.*;
import java.util.Arrays;

public class MostFrequentNumber_1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int seq = Integer.parseInt(br.readLine());
            String[] scores = br.readLine().split(" ");
            int[] frequency = new int[101];
            for (String score : scores) {
                frequency[Integer.parseInt(score)]++;
            }
            int[] freq2 = new int[101];
            System.arraycopy(frequency, 0, freq2, 0, frequency.length);
            Arrays.sort(frequency);
            int result = 0;
            for (int j = 100; j >= 0; j--) {
                if (freq2[j] == frequency[100]) {
                    result = j;
                    break;
                }
            }
            bw.append("#").append(String.valueOf(seq)).append(" ").append(String.valueOf(result)).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
//10 8 7 2 2 4 8 8 8 9 5 5 3