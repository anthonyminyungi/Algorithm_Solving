package com.algorithms.Programmers.Practice.Level2;

import java.util.LinkedHashMap;

public class Level2_Cache {
    public static void main(String[] args) {
        int size = 3;
        String[] test1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoull", "NewYork", "LA"};
        String[] test2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] test3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] test4 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        String[] test5 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(size, test1));
        System.out.println(solution(size, test2));
        System.out.println(solution(size, test3));
        System.out.println(solution(size, test4));
        System.out.println(solution(size, test5));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) return cities.length * 5;
        if (cacheSize >= cities.length) return cities.length;

        LinkedHashMap<String, Integer> lurMap = new LinkedHashMap<String, Integer>() {
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<String, Integer> eldest) {
                return cacheSize > 0 && size() > cacheSize;
            }
        };

        for (String key : cities) {
            if (lurMap.containsKey(key.toUpperCase())) {
                lurMap.remove(key.toUpperCase());
                lurMap.put(key.toUpperCase(), 0);
                answer += 1;
            } else {
                lurMap.put(key.toUpperCase(), 0);
                answer += 5;
            }
        }
        return answer;
    }
}
