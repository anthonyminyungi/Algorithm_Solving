package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

/**
 * 문제에 관한 고찰
 * 문제와 풀이를 단순화시키는 연습이 필요하다. 단순하게 풀지 못해서 시간초과만 9번 반복함.
 * D,S,L,R 값 및 연속적인 연산을 저장하는 방식을 너무 어렵게 생각했었다.
 * 무엇보다 풀이를 보고 내가 푼 방식을 돌이켜봤을때 문제 조건을 정확히 이해하지 못한 부분이 있었다.
 * 참고 : https://dundung.tistory.com/66
 * <p>
 * <p>
 * 속도에 관한 고찰
 * 1. StringTokenizer 가 String 배열로 변환하는 것보다 빠르다.
 * 2. 매번 초기화하거나 new 를 통해 재할당해야한다면 객체를 그때그때 선언과 동시에 생성하는 것이 static 으로 두는 것보다 빠르다. (배열에 static 활용시 fill 로 초기화)
 * 3. BufferedWriter 보다 StringBuilder 가 더 빠른 경우도 있다.
 * 4. 매 테스트케이스마다 String 으로 변환하는 것보다 StringBuilder 자체를 반환하는 것이 더 빠르다.
 * 5. BFS loop 에 비례하는 최소값을 구하는 문제의 경우 가장 처음 조건에 일치하는 경우가 최소값이다.
 * 6. 테스트 케이스별 결과 도출 문제는 while (t -- > 0) 보다 for 문을 활용하는 편이 근소하게 빠르다. (이건 왜그러지?)
 * 7. 큐 삽입 연산에서 add 와 offer 의 속도 차이는 근소하다.
 * 이 문제 1000ms 초반대로 푼 사람이 있던데 방법이 도저히 상상이 가질 않는다.
 */

public class DSLR_9019 {
    static char[] op = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(bfs(a, b)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static StringBuilder bfs(int src, int target) {
        char[] commands = new char[10000];
        boolean[] visited = new boolean[10000];
        int[] preValues = new int[10000];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int n_val = process(cur, i);
                if (!visited[n_val]) {
                    q.add(n_val);
                    preValues[n_val] = cur;
                    visited[n_val] = true;
                    commands[n_val] = op[i];
                }
                if (n_val == target) {
                    StringBuilder sb = new StringBuilder();
                    while (n_val != src) {
                        sb.insert(0, commands[n_val]);
                        n_val = preValues[n_val];
                    }
                    return sb;
                }
            }
        }
        return null;
    }

    static int process(int val, int command) {
        switch (command) {
            case 0:
                return (2 * val) % 10000;
            case 1:
                return val == 0 ? 9999 : val - 1;
            case 2:
                return (val % 1000) * 10 + val / 1000;
            default:
                return (val % 10) * 1000 + val / 10;
        }
    }
}