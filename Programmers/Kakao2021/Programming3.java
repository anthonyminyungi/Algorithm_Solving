package com.algorithms.Programmers.Kakao2021;

import java.util.*;
import java.util.stream.*;

// 효율성 0/4
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));

    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        List<Info> infos = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            String[] in = info[i].split(" ");
            System.out.println(Arrays.toString(in));
            infos.add(new Info(in[0], in[1], in[2], in[3], Integer.parseInt(in[4])));
        }

        for (int i = 0; i < query.length; i++) {
            String[] in = query[i].split(" and ");
            System.out.println(Arrays.toString(in));
            String lang = in[0];
            String job = in[1];
            String career = in[2];
            String[] t = in[3].split(" ");
            String food = t[0];
            int score = Integer.parseInt(t[1]);

            List<Info> temp = infos.stream()
                    .filter(a -> (lang.equals("-") || a.lang.equals(lang))
                            && (job.equals("-") || a.job.equals(job))
                            && (career.equals("-") || a.career.equals(career))
                            && (food.equals("-") || (a.food.equals(food)))
                            && (a.score >= score))
                    .collect(Collectors.toList());

            answer[i] += temp.size();
        }

        return answer;
    }

    static class Info {
        String lang;
        String job;
        String career;
        String food;
        int score;

        Info(String l, String j, String c, String f, int s) {
            this.lang = l;
            this.job = j;
            this.career = c;
            this.food = f;
            this.score = s;
        }
    }
}
