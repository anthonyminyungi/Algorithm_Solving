package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// 기존 코드로 Test case 1번이 도저히 안풀려서 인터넷 코드 참고.
// 출처 : https://tosuccess.tistory.com/36
public class Level3_TravelPath {
    static List<String> res;
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}})));
//        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "B"}, {"ICN", "B"}, {"A", "B"}})));
    }

    public static String[] solution(String[][] tickets) {
        res = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(res);

        return res.get(0).split(" ");
    }

    static void dfs(int count, String current, String answer, String[][] tickets) {
        if (count == tickets.length) {
            res.add(answer);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(count + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}

//class Solution {
//    static List<String> res;
//    static Map<String, LinkedList<String>> map;
//
//    public static String[] solution(String[][] tickets) {
//        res = new ArrayList<>();
//        map = new HashMap<>();
//        for (String[] ticket : tickets) {
//            if (!map.containsKey(ticket[0])) {
//                map.put(ticket[0], new LinkedList<String>());
//            }
//            LinkedList<String> list = map.get(ticket[0]);
//            list.add(ticket[1]);
//            map.replace(ticket[0], list);
//        }
//
//        for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
//            LinkedList<String> list = map.get(entry.getKey());
//            if (list.isEmpty()) {
//                map.remove(entry.getKey());
//            } else {
//                list.sort(new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        if (!map.containsKey(o1)) return 1;
//                        if (!map.containsKey(o2)) return -1;
//                        return o1.compareTo(o2);
//                    }
//                });
//                map.replace(entry.getKey(), list);
//            }
//        }
//        res.add("ICN");
//
//        dfs("ICN");
//        return res.toArray(new String[0]);
//    }
//
//    static void dfs(String start) {
//        if (map.isEmpty()) return;
//        if (map.containsKey(start)) {
//            LinkedList<String> list = map.get(start);
//            if (!list.isEmpty()) {
//                String next = list.remove(0);
//                res.add(next);
//                if (list.isEmpty()) map.remove(start);
//                else map.replace(start, list);
//
//                dfs(next);
//            } else {
//                map.remove(start);
//                dfs(start);
//            }
//        } else {
//            for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
//                res.add(entry.getKey());
//                dfs(entry.getKey());
//                break;
//            }
//        }
//    }
//}