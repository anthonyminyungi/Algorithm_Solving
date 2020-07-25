package com.algorithms.Programmers.Practice.Level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_NewsClustering {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
        System.out.println(solution("ABCDE", "FGHI"));
        System.out.println(solution("ABCDE", "BCDEF"));
    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> inter = new ArrayList<>();

        String temp;
        for (int i = 0; i < str1.length() - 1; i++) {
            temp = str1.substring(i, i + 2);
            if (!temp.contains(" ") && Character.isLetter(temp.charAt(0)) && Character.isLetter(temp.charAt(1))) {
                A.add(temp.toUpperCase());
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            temp = str2.substring(i, i + 2);
            if (!temp.contains(" ") && Character.isLetter(temp.charAt(0)) && Character.isLetter(temp.charAt(1))) {
                B.add(temp.toUpperCase());
            }
        }
//
        for (String s : A) {
            if (B.remove(s)) {
                inter.add(s);
            }
            union.add(s);
        }
        union.addAll(B);
//        List<String> union = A.size() >= B.size() ? union(A, B) : union(B, A);
//        List<String> inter = A.size() >= B.size() ? inter(A, B) : inter(B, A);

        double jacard = 0;
        if (union.size() == 0) {
            jacard = 1;
        } else if (inter.size() == 0) {
            jacard = 0;
        } else {
            jacard = (double) inter.size() / union.size();
        }
        answer = (int) Math.floor(jacard * 65536);
        return answer;
    }

    // 이 로직이 왜 안되는지 이해를 해보려고 했으나 실패함... 아무리 봐도 똑같은 로직인데 ㅠ
//    public static List<String> union(List<String> a, List<String> b) {
//        List<String> res = new ArrayList<>(a);
//        for (String s : b) {
//            if (!res.contains(s)) {
//                res.add(s);
//            }
//        }
//        return res;
//    }
//
//    public static List<String> inter(List<String> a, List<String> b) {
//        List<String> res = new ArrayList<>();
//        for (String s : b) {
//            if (a.contains(s)) {
//                res.add(s);
//            }
//        }
//        return res;
//    }
}
