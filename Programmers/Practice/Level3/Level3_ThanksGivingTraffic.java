package com.algorithms.Programmers.Practice.Level3;

// 출처 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B6%94%EC%84%9D-%ED%8A%B8%EB%9E%98%ED%94%BD-Java
// 매우 어려움
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
            int startCnt = 0;
            int endCnt = 0;
            int startTmp = startTimes[i];
            int endTmp = endTimes[i];

            for (int j = 0; j < lines.length; ++j) {
                int startOfSection = startTmp;
                int endOfSection = startOfSection + 1000;
                // 로그의 시작 시점 기준에서의 조건 처리
                if (startTimes[j] >= startOfSection && startTimes[j] < endOfSection || endTimes[j] >= startOfSection && endTimes[j] < endOfSection || startTimes[j] <= startOfSection && endTimes[j] >= endOfSection) {
                    // 시작점 끝점을 기준으로 하는 윈도우를 만들고, 해당 윈도우에 처리중인 로그의 경우들은
                    // 시작점이 윈도우에 걸쳐있는 경우
                    // 끝점이 윈도우에 걸쳐있는 경우
                    // 로그가 윈도우를 포함하고 있는 경우
                    startCnt++;
                }

                startOfSection = endTmp;
                endOfSection = startOfSection + 1000;
                // 로그의 종료 시점 기준에 대해서도 똑같이 처리
                if (startTimes[j] >= startOfSection && startTimes[j] < endOfSection || endTimes[j] >= startOfSection && endTimes[j] < endOfSection || startTimes[j] <= startOfSection && endTimes[j] >= endOfSection) {
                    endCnt++;
                }
            }

            answer = Math.max(answer, Math.max(startCnt, endCnt));
            // 로그 시작시간과 끝시간에 대한 카운트 값 중 큰 값과 answer 를 비교하여 큰 값으로 갱신
        }

        return answer;
    }
}
