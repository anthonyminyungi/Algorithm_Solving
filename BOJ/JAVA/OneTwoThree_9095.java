package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;

public class OneTwoThree_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        int[] arr = new int[11];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        arr[3] = 7;

        int test = Integer.parseInt(a);
        for (int i = 0; i < test; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 1 || k == 2 || k == 3 || k == 4)
                bw.append(arr[k - 1] + "\n");

            else {
                bw.append(dp(arr, k - 1) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
        ArrayList arrayList = new ArrayList();
        ;

    }

    static int dp(int[] arr, int target) {
        if (arr[target] != 0)
            return arr[target];
        int res = dp(arr, target - 1) + dp(arr, target - 2) + dp(arr, target - 3);
        return res;
    }

}
