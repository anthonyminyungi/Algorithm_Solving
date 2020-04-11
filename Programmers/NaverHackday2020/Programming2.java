package com.java.Programmers.NaverHackday2020;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Programming2 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"A B C D", "A D", "A B D", "B D"}, 2));
        System.out.println(solution(new String[]{"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"}, 3));
    }

    public static int solution(String[] id_list, int k) {
        int answer = 0;
        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> customerPerDay;
        for (int i = 0; i < id_list.length; i++) {
            String[] customers = id_list[i].split(" ");
            customerPerDay = new LinkedList<>();
            for (int j = 0; j < customers.length; j++) {
                String cur = customers[j];
                if (!customerPerDay.contains(cur))
                    customerPerDay.add(cur);
                else
                    continue;
                if (!map.containsKey(cur)) {
                    map.put(cur, 1);
                    answer++;
                } else {
                    if (map.get(cur) < k) {
                        map.replace(cur, map.get(cur) + 1);
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
