package com.algorithms.Programmers.Practice.Level3;

public class Level3_AdInsertion_another {
    public static void main(String[] args) {
        System.out.println(solution("02:03:05", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
        System.out.println(solution("99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));
        System.out.println(solution("50:00:00", "50:00:00", new String[]{"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}));
//        System.out.println(solution("00:00:10", "00:00:03", new String[]{"00:00:00-00:00:01", "00:00:02-00:00:08", "00:00:03-00:00:06"}));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int playSec = convert(play_time);
        int advSec = convert(adv_time);
        int[] totalSec = new int[100 * 60 * 60];
        for (String log : logs) {
            int start = convert(log.substring(0, 8));
            int end = convert(log.substring(9, 17));
            for (int i = start; i < end; i++) {
                totalSec[i] += 1;
            }
        }

        long curSum = 0;
        for (int i = 0; i < advSec; i++) {
            curSum += totalSec[i];
        }
        long maxSum = curSum;
        int maxIdx = 0;

        for (int i = advSec; i < playSec; i++) {
            curSum = curSum + totalSec[i] - totalSec[i - advSec];
            if (curSum > maxSum) {
                maxSum = curSum;
                maxIdx = i - advSec + 1;
            }
        }

        return String.format("%02d:%02d:%02d", maxIdx / 3600, maxIdx / 60 % 60, maxIdx % 60);
    }

    static int convert(String time) {
        String[] nums = time.split(":");
        return Integer.parseInt(nums[0]) * 60 * 60 + Integer.parseInt(nums[1]) * 60 + Integer.parseInt(nums[2]);
    }
}
