package com.algorithms.Programmers.Kakao2019InternTest;

import java.util.*;

//어케푸는거냐..
public class Solution3 {
    static Set<Set<String>> globalSet;

    public static void main(String[] args) {
        String[] userid = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banedid1 = {"fr*d*", "abc1**"};
        String[] banedid2 = {"*rodo", "*rodo", "******"};
        String[] banedid3 = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(userid, banedid1));
        System.out.println(solution(userid, banedid2));
        System.out.println(solution(userid, banedid3));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        Map<String, List<String>> map = new LinkedHashMap<>();
        globalSet = new LinkedHashSet<>();
        for (String value : banned_id) {
            map.put(value, new LinkedList<>());
            for (String s : user_id) {
                if (value.length() == s.length() && compareString(s, value)) {
                    if (!map.get(value).contains(s)) {
                        List<String> got = map.get(value);
                        got.add(s);
                        map.replace(value, got);
                    }
                }
            }
        }

        List<List<String>> res = new LinkedList<>();
        for (String s : banned_id) {
            res.add(map.get(s));
        }
        recursion(res, new LinkedList<>(), 0, banned_id.length);
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

