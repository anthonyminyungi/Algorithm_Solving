package com.java.Kakao_Coding_Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

//통과
public class Solution2 {
    public static void main(String[] args) {
        String test1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String test2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String test3 = "{{20,111},{111}}";
        String test4 = "{{123}}";
        String test5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        System.out.println(Arrays.toString(solution(test5)));
    }

    public static int[] solution(String s) {
        int[] answer;
        char[] a = s.toCharArray();
        a[0] = ' ';
        a[a.length - 1] = ' ';
        String news = String.valueOf(a).trim();
        char[] bb = news.toCharArray();
        bb[0] = ' ';
        bb[bb.length - 1] = ' ';
        news = String.valueOf(bb).trim();
//        System.out.println(news);
        String[] b = news.split("},\\{");
        Arrays.sort(b, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

//        System.out.println(Arrays.toString(b));

        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();

        for (int i = 0; i < b.length; i++) {
            String[] nt = b[i].split(",");
            for (int j = 0; j < nt.length; j++) {
                hashSet.add(Integer.parseInt(nt[j]));
            }
        }
        Object[] o = hashSet.toArray();
        answer = new int[o.length];
        for (int i = 0; i < o.length; i++) {
            answer[i] = (Integer) o[i];
        }
//
//        System.out.println(Arrays.toString(hashSet.toArray()));
//        System.out.println(Arrays.toString(answer));
//        System.out.println(hashSet);
        return answer;
    }
}
