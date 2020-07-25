package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

public class Level3_BadUser {
    static Set<Set<String>> globalSet;

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"******", "fr*d*", "c*odo"}));

    }

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        Map<String, List<String>> map = new LinkedHashMap<>();
        globalSet = new LinkedHashSet<>();
        for (int i = 0; i < banned_id.length; i++) {
            map.put(banned_id[i], new LinkedList<>());
            for (int j = 0; j < user_id.length; j++) {
                if (banned_id[i].length() == user_id[j].length() && compareString(user_id[j], banned_id[i])) {
                    if (!map.get(banned_id[i]).contains(user_id[j])) {
                        List<String> got = map.get(banned_id[i]);
                        got.add(user_id[j]);
                        map.replace(banned_id[i], got);
                    }
                }
            }
        }

        List<List<String>> res = new LinkedList<>();
        for (int i = 0; i < banned_id.length; i++) {
            res.add(map.get(banned_id[i]));
        }
        System.out.println(res);

        recursion(res, new LinkedList<>(), 0, banned_id.length);
//        int resIndex = 0;
//        for (int i = 0; i < banned_id.length; i++) {
//            List<String> got = map.get(banned_id[i]);
//            System.out.println("got : " + got);
//            if (i == 0) {
//                for (int j = 0; j < got.size(); j++) {
//                    List<String> cur = new LinkedList<>();
//                    cur.add(got.get(j));
//                    res.add(cur);
//                }
//            } else {
//                int currentResSize = res.size();
//                for (int j = 0; j < got.size(); j++) {
//                    System.out.println(res + " , " + resIndex + " , " + currentResSize);
//                    System.out.println(got.get(j));
//                    for (int k = resIndex; k < currentResSize; k++) {
//                        if (!res.get(k).contains(got.get(j))) {
//                            List<String> removed = res.get(k);
//                            List<String> cur = new LinkedList<>(removed);
//                            cur.add(got.get(j));
//                            res.add(cur);
//                        }
//                    }
//                }
//                resIndex += currentResSize;
//            }
//        }
////        System.out.println(res);
//        Set<Set<String>> set = new LinkedHashSet<>();
//        for (int i = 0; i < res.size(); i++) {
//            Set<String> cur = new LinkedHashSet<>(res.get(i));
//            if (cur.size() == banned_id.length) {
//                set.add(cur);
//            }
//        }
//        System.out.println(set);
//        answer = set.size();

        answer = globalSet.size();
        return answer;
    }

    public static void recursion(List<List<String>> list, List<String> cur, int nextIndex, int banLength) {
        if (cur.size() == banLength) {
            Set<String> set = new LinkedHashSet<>(cur);
            globalSet.add(set);
            return;
        }
        List<String> next = list.get(nextIndex);
        for (int i = 0; i < next.size(); i++) {
            List<String> temp = new LinkedList<>(cur);
            if (!temp.contains(next.get(i)))
                temp.add(next.get(i));
            else
                continue;
            recursion(list, temp, nextIndex + 1, banLength);
        }
    }

    public static boolean compareString(String user_id, String banned_id) {
        boolean matched = true;
        for (int i = 0; i < user_id.length(); i++) {
            if (user_id.charAt(i) != banned_id.charAt(i)) {
                if (banned_id.charAt(i) != '*') {
                    matched = false;
                    break;
                }
            }
        }
        return matched;
    }
}
