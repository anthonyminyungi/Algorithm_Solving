package com.algorithms.Programmers.Practice.Level3;

// 출처 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B6%94%EC%84%9D-%ED%8A%B8%EB%9E%98%ED%94%BD-Java

public class Level3_ThanksGivingTraffic {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
        System.out.println(solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}));
        System.out.println(solution(new String[]{"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"
        }));
    }

    public static int solution(String[] lines) {
        int answer = 0;
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] log = lines[i].split(" ");
            String[] responseTime = log[1].split(":");
            int processingTime = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
            int startTime = 0;
            int endTime = 0;

            endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(responseTime[1]) * 60 * 1000;
            endTime += (int) (Double.parseDouble(responseTime[2]) * 1000);
            startTime = endTime - processingTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }

        for (int i = 0; i < lines.length; ++i) {
            int cnt = 0;
            int startOfSection = startTimes[i];
            int endOfSection = startOfSection + 1000;

            for (int j = 0; j < lines.length; ++j) {
                if (startTimes[j] >= startOfSection && startTimes[j] < endOfSection) {
                    cnt++;
                } else if (endTimes[j] >= startOfSection && endTimes[j] < endOfSection) {
                    cnt++;
                } else if (startTimes[j] <= startOfSection && endTimes[j] >= endOfSection) {
                    cnt++;
                }
            }
            cnt = 0;
            startOfSection = endTimes[i];
            endOfSection = startOfSection + 1000;

            for (int j = 0; j < lines.length; ++j) {
                if (startTimes[j] >= startOfSection && startTimes[j] < endOfSection) {
                    cnt++;
                } else if (endTimes[j] >= startOfSection && endTimes[j] < endOfSection) {
                    cnt++;
                } else if (startTimes[j] <= startOfSection && endTimes[j] >= endOfSection) {
                    cnt++;
                }
            }

            answer = Math.max(cnt, answer);
        }

        return answer;
    }
}
