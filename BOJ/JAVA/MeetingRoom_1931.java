package com.java.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MeetingRoom_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] times = new long[N][2];

        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            times[i][0] = Long.parseLong(in[0]);
            times[i][1] = Long.parseLong(in[1]);
        }
        Arrays.sort(times, (o1, o2) -> {
            if ((((Comparable) o1[1]).compareTo(o2[1])) > 0) return 1;
            else if (o1[1] == o2[1] && (((Comparable) o1[0]).compareTo(o2[0]) > 0)) return 1;
            else return -1;
        });

        long last = 0;
        ArrayList<long[]> result = new ArrayList<>();

        for (long[] a : times) {
            System.out.println(Arrays.toString(a));
            if (last < a[0]) {
                last = a[1];
                result.add(a);
            }
        }
        System.out.println(result.size());
    }
}
