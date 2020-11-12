package com.algorithms.Programmers.Practice.Level3;

// 문제 이해가 너무 어려워서 인터넷 참고.
// 출처 : https://jayrightthere.tistory.com/entry/DFSJAVA-N%EC%9C%BC%EB%A1%9C-%ED%91%9C%ED%98%84
// DP 문제이지만 이전 연산을 기억해서 처리하는 방식이므로 DFS 로 풀이가 가능하다는 사실을 알았다.
public class Level3_ExpressN {
    static int answer;

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
    }

    public static int solution(int N, int number) {
        answer = -1;
        dfs(N, number, 0, 0);
        return answer;
    }

    static void dfs(int n, int num, int cnt, int prev) {
        int tmp = n;
        if (cnt > 9) {
            answer = -1;
            return;
        }

        if (num == prev) {
            if (answer == -1 || answer > cnt) answer = cnt;
            return;
        }

        for (int i = 0; i < 8 - cnt; i++) {
            dfs(n, num, cnt + i + 1, prev - tmp);
            dfs(n, num, cnt + i + 1, prev + tmp);
            dfs(n, num, cnt + i + 1, prev * tmp);
            dfs(n, num, cnt + i + 1, prev / tmp);
            tmp = tmp * 10 + n;
        }
    }
}
