package com.java;

import java.io.*;

public class MilkFest_14720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] milks = br.readLine().split(" ");
        int mcnt = 0;
        boolean strawberry = false;
        boolean choco = false;
        boolean banana = false;
        int[] milkis = new int[N];
        for (int i = 0; i < N; i++) {
            milkis[i] = Integer.parseInt(milks[i]);
        }

        for (int i = 0; i < N; i++) {
            if (!strawberry && !choco && !banana) {
                if (milkis[i] == 0) {
                    mcnt++;
                    strawberry = true;
                }
            }

            if (strawberry && milkis[i] == 1) {
                mcnt++;
                strawberry = false;
                choco = true;
                banana = false;
            } else if (choco && milkis[i] == 2) {
                mcnt++;
                banana = true;
                strawberry = false;
                choco = false;
            } else if (banana && milkis[i] == 0) {
                mcnt++;
                strawberry = true;
                choco = false;
                banana = false;
            }

        }
        bw.append(mcnt + "");
        bw.flush();

    }
}
