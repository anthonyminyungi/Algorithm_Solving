package com.algorithms.Programmers.Practice.Level3;

// DFS
public class Level3_WordTransform {
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public static int solution(String begin, String target, String[] words) {
        int n = words.length;
        visited = new boolean[n];
        int answer = dfs(begin, target, words, 0, n);
        if (answer == n) return 0;
        return answer + 1;
    }

    static int dfs(String begin, String target, String[] words, int k, int min) {
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canTransform(begin, words[i])) {
                if (words[i].equals(target)) {
                    return Math.min(min, k);
                }
                visited[i] = true;
                int num = dfs(words[i], target, words, k + 1, min);
                min = Math.min(num, min);
            }
        }
        return min;
    }

    private static boolean canTransform(String a, String b) {
        int diffCnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diffCnt++;
        }
        return diffCnt == 1;
    }
}
