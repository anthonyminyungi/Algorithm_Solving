package com.algorithms.Programmers.Practice.Level4;


// Parametric Search ?
// 처음 들어보는 개념의 문제. 풀이를 보고 이해하는 식으로 해결. 이해하기 쉽지 않다.
// https://velog.io/@ptm0304/%EC%84%A0%EC%9E%85-%EC%84%A0%EC%B6%9C-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81-Parametric-Search
public class Level4_FIFOScheduling {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 2, 3}));
        System.out.println(solution(6, new int[]{1, 2, 2}));
    }

    public static int solution(int n, int[] cores) {
        if (cores.length >= n) return n;
        int answer = 0;
        int maxCore = cores[0], minCore = cores[0], numOfCores = cores.length;
        for (int i = 0; i < cores.length; i++) {
            if (cores[i] < minCore) minCore = cores[i];
            if (cores[i] > maxCore) maxCore = cores[i];
        }

        // 0초에 모든 코어에 작업이 할당되므로 소요될 수 있는 최대시간과 최소시간을 구할 때 그만큼은 빼주어야 함.
        int maxTime = (n - numOfCores) * maxCore / numOfCores, minTime = (n - numOfCores) * minCore / numOfCores, midTime;

        while (minTime <= maxTime) {
            midTime = (maxTime + minTime) / 2;
            int processed = numOfCores, justStarted = 0; // 해당 시간에 완료 가능한 전체 작업 수, 현재 시간에 갓 할당된 작업 수.
            for (int core : cores) {
                processed += (midTime / core);
                if (midTime % core == 0) justStarted++;
            }

            if (n > processed)
                minTime = midTime + 1;
            else if (n <= (processed - justStarted))
                maxTime = midTime - 1;
            else { // (processed - justStarted) < n <= processed
                int cnt = (processed - justStarted);
                for (int i = 0; i < numOfCores; i++) {
                    if (midTime % cores[i] == 0) cnt++;
                    if (cnt == n) return (i + 1);
                }
            }
        }

        return answer;
    }
}
