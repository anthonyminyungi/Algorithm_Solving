package com.algorithms.Programmers.Practice.Level2;

import java.util.*;

public class Level2_RankingSearch {
    static Map<String, Integer> WordMap = new HashMap<>();
    static List<List<Integer>> ScoreList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"})));
    }

    public static int[] solution(String[] info, String[] query) {
        WordMap.put("-", 0);
        WordMap.put("cpp", 1);
        WordMap.put("java", 2);
        WordMap.put("python", 3);
        WordMap.put("backend", 1);
        WordMap.put("frontend", 2);
        WordMap.put("junior", 1);
        WordMap.put("senior", 2);
        WordMap.put("chicken", 1);
        WordMap.put("pizza", 2);
        for (int i = 0; i < 4 * 3 * 3 * 3; i++)
            ScoreList.add(new ArrayList<>());

        for (String str : info) {
            String[] words = str.split(" ");
            int[] arr = {WordMap.get(words[0]) * 3 * 3 * 3,
                    WordMap.get(words[1]) * 3 * 3,
                    WordMap.get(words[2]) * 3,
                    WordMap.get(words[3])};
            int score = Integer.parseInt(words[4]);

            for (int i = 0; i < (1 << 4); i++) {
                int idx = 0;
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) != 0) {
                        idx += arr[j];
                    }
                }
                ScoreList.get(idx).add(score);
            }
        }

        for (int i = 0; i < 4 * 3 * 3 * 3; i++) {
            Collections.sort(ScoreList.get(i));
        }

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] words = query[i].split(" ");
            int idx = WordMap.get(words[0]) * 3 * 3 * 3 +
                    WordMap.get(words[2]) * 3 * 3 +
                    WordMap.get(words[4]) * 3 +
                    WordMap.get(words[6]);
            int score = Integer.parseInt(words[7]);
            int ret = Collections.binarySearch(ScoreList.get(idx), score);

            if (ret < 0) ret = -(ret + 1);
            else {
                for (int j = ret - 1; j >= 0; j--) {
                    if (ScoreList.get(idx).get(j) == score) ret = j;
                    else break;
                }
            }
            answer[i] = ScoreList.get(idx).size() - ret;
        }

        return answer;
    }
}
