package com.java.Programmers.Kakao2020;

import java.util.*;

// 효율성 0

public class Programming3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.println("-----");
        System.out.println(Arrays.toString(solution(new String[]{"AA", "AB", "AC", "AA", "AC"})));
        System.out.println("-----");
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XYZ", "XYZ"})));
        System.out.println("-----");
        System.out.println(Arrays.toString(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
        System.out.println("-----");
    }

    public static int[] solution(String[] gems) {
        int[] answer = {};
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(gems));
        List<int[]> distances = new ArrayList<>();
        List<String> tmp;
        for (int i = 0; i < gems.length; i++) {
            if ((gems.length) - i < set.size())
                break;
            tmp = new ArrayList<>();
            for (int j = i; j < gems.length; j++) {
                if (!tmp.contains(gems[j]))
                    tmp.add(gems[j]);
                if (tmp.size() == set.size()) {
                    distances.add(new int[]{i + 1, j + 1});
                    break;
                }
            }
        }
        if (distances.size() == 1)
            return distances.get(0);
        else {
            distances.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int distance1 = o1[1] - o1[0];
                    int distance2 = o2[1] - o2[0];
                    if (distance1 > distance2) {
                        return 1;
                    } else if (distance2 > distance1) {
                        return -1;
                    } else {
                        if (o1[0] < o2[0])
                            return -1;
                        else
                            return 0;
                    }
                }
            });
            for (int i = 0; i < distances.size(); i++) {
                System.out.println(Arrays.toString(distances.get(i)));
            }
            answer = distances.get(0);
            return answer;
        }
    }
}
