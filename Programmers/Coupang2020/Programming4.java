package com.algorithms.Programmers.Coupang2020;

import java.util.*;

// 미제출
public class Programming4 {
    public static void main(String[] args) {
        System.out.println(solution("SEOUL", "DAEGU", "YEOSU", new String[][]{{"ULSAN", "BUSAN"}, {"DAEJEON", "ULSAN"}, {"DAEJEON", "GWANGJU"}, {"SEOUL", "DAEJEON"}, {"SEOUL", "ULSAN"}, {"DAEJEON", "DAEGU"}, {"GWANGJU", "BUSAN"},
                {"DAEGU", "GWANGJU"}, {"DAEGU", "BUSAN"}, {"ULSAN", "DAEGU"}, {"GWANGJU", "YEOSU"}, {"BUSAN", "YEOSU"}}));
        System.out.println(solution("ULSAN", "SEOUL", "BUSAN", new String[][]{{"SEOUL", "DAEJEON"}, {"SEOUL", "ULSAN"},
                {"DAEJEON", "ULSAN"}, {"DAEJEON", "BUSAN"}, {"DAEJEON", "GWANGJU"}, {"ULSAN", "BUSAN"}, {"GWANGJU", "BUSAN"}}));
    }

    public static int solution(String depar, String hub, String dest, String[][] roads) {
        Map<String, City> cityMap = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        Map<String, Integer> dp = new HashMap<>();

        for (String[] road : roads) {
            if (!cityMap.containsKey(road[0])) {
                visited.put(road[0], false);
                dp.put(road[0], 0);
                cityMap.put(road[0], new City(road[0]));
            }

            if (!cityMap.containsKey(road[1])) {
                visited.put(road[1], false);
                dp.put(road[1], 0);
                cityMap.put(road[1], new City(road[1]));
            }

            City from = cityMap.get(road[0]);
            City to = cityMap.get(road[1]);

            to.comeIn.put(road[0], from);
        }

        visited.put(depar, true);
        dp.put(depar, 1);
        dfs(hub, cityMap, dp, visited);

        for (Map.Entry<String, Boolean> entry : visited.entrySet()) {
            if (visited.get(entry.getKey()) && !entry.getKey().equals(hub))
                dp.put(entry.getKey(), 0);
        }

        visited.put(hub, true);
        dfs(dest, cityMap, dp, visited);

        return dp.get(dest) % 10007;
    }

    static void dfs(String dest, Map<String, City> cityMap, Map<String, Integer> dp, Map<String, Boolean> visited) {
        City city = cityMap.get(dest);
        int sum = 0;

        for (City from : city.comeIn.values()) {
            if (!visited.get(from.name)) {
                visited.put(from.name, true);
                dfs(from.name, cityMap, dp, visited);
            }
            sum += dp.get(from.name);
        }
        dp.put(dest, sum);
    }

    static class City {
        String name;
        Map<String, City> comeIn;

        public City(String name) {
            this.name = name;
            this.comeIn = new HashMap<>();
        }
    }
}
