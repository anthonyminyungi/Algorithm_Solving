package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 무식한 풀이 저장
public class RemoteController_1107 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int currentChannel = 100;
        String targetStr = br.readLine();
        int targetChannel = Integer.parseInt(targetStr);
        int nOfBroken = Integer.parseInt(br.readLine());
        List<Integer> buttons = new ArrayList<>();
        boolean[] broken = new boolean[10];
        StringTokenizer st;
        if (nOfBroken != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < nOfBroken; i++) broken[Integer.parseInt(st.nextToken())] = true;
        }
        for (int i = 0; i < 10; i++)
            if (!broken[i])
                buttons.add(i);
        Collections.sort(buttons);

        int ans = 987654321;
        for (int i = 0; i <= 1000000; i++) {
            if (Math.abs(i - targetChannel) < Math.abs(ans - targetChannel)) {
                String s = String.valueOf(i);
                int available = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (buttons.contains(s.charAt(j) - '0')) {
                        available++;
                    }
                }
                if (available == s.length())
                    ans = i;
            }
        }

        System.out.println(Math.min(Math.abs(currentChannel - targetChannel), Math.abs(ans - targetChannel) + String.valueOf(ans).length()));
    }
}
