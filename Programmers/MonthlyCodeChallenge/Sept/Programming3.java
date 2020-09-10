package com.algorithms.Programmers.MonthlyCodeChallenge.Sept;

import java.util.*;
import java.util.stream.*;

// 20점
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, -1, -5}));
        System.out.println(solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }

    public static int solution(int[] a) {
        int answer = 0;
        List<Integer> list;
        int lowDelete;
        for (int i = 0; i < a.length; i++) {
            int target = a[i];
            lowDelete = 0;
            list = Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayList::new));
            int idx = 0;
            int cnt = 0;
            while (list.size() > 1) {
                if (idx < list.size() - 1) {
                    int current = list.get(idx);
                    int next = list.get(idx + 1);
                    if (current < next) {
                        if (next == target) {
                            if (list.size() == 2 && lowDelete == 0) {
                                list.remove(idx);
                                lowDelete++;
                            } else {
                                idx++;
                            }
                        } else {
                            list.remove(idx + 1);
                        }
                    } else {
                        if (current == target) {
                            if (list.size() == 2 && lowDelete == 0) {
                                list.remove(idx + 1);
                                lowDelete++;
                            } else {
                                idx++;
                            }
                        } else {
                            list.remove(idx);
                        }
                    }
                } else {
                    idx = 0;
                }
                cnt++;

                if (cnt > a.length)
                    break;
            }
//            System.out.println(list);
            if (list.get(0) == target)
                answer++;
        }

        return answer;
    }
}
