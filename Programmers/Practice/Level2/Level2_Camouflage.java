package com.java.Programmers.Practice.Level2;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Level2_Camouflage {
    public static void main(String[] args) {
        String[][] tc1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] tc2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(tc1));
        System.out.println(solution(tc2));
    }


    public static int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1]))
                map.replace(clothes[i][1], map.get(clothes[i][1]) + 1);
            else {
                map.put(clothes[i][1], 1);
                list.add(clothes[i][1]);
            }
        }
        int cases = 1;
        for (int i = 0; i < list.size(); i++) {
            cases *= (map.get(list.get(i)) + 1);
        }
        answer = cases - 1;
        return answer;
    }
}
