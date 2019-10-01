package com.java;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Olympic_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String[] aa = a.split(" ");
        Integer a1 = Integer.parseInt(aa[0]);
        Integer a2 = Integer.parseInt(aa[1]);
        HashMap hashMap = new HashMap();
        Long[] arr = new Long[a1];
        Long[] arr2;
        int[] b = new int[a1];
        for (int i = 0; i < a1; i++) {
            String[] bb = br.readLine().split(" ");
            arr[i] = Long.parseLong(bb[1]) * (long) Math.pow(1000000, 2) + Long.parseLong(bb[2]) * 1000000 + Long.parseLong(bb[3]) * 1;
            b[i] = Integer.parseInt(bb[0]);
        }
        Long[] arr3 = new Long[a1];
        System.arraycopy(arr, 0, arr3, 0, arr.length);
        Arrays.sort(arr3);
        List<Long> list = Arrays.asList(arr3);
        Collections.reverse(list);
        arr2 = list.toArray(new Long[list.size()]);
        int rank = 1;
        for (int i = 0; i < a1; i++) {
            if (!hashMap.containsKey(arr2[i] + ""))
                hashMap.put(arr2[i] + "", rank);
            rank++;
        }
        int index = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == a2) {
                index = i;
                break;
            }
        }
        bw.write(hashMap.get(arr[index] + "") + "\n");
        bw.flush();
        bw.close();
    }
}
