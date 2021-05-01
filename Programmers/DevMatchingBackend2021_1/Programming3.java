package com.algorithms.Programmers.DevMatchingBackend2021_1;

import java.util.*;

// 거의 다풀었는데 시간 부족으로 미제출
// 5.1 기존 푼 코드로 실패떠서 다시품
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10})));
        System.out.println(Arrays.toString(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"sam", "emily", "jaimie", "edward"},
                new int[]{2, 3, 5, 4})));
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];


        Map<String, Seller> sellerMap = new HashMap<>();

        sellerMap.put("-", new Seller("-"));
        for (String e : enroll)
            sellerMap.put(e, new Seller(e));

        for (int i = 0; i < referral.length; i++)
            sellerMap.get(enroll[i]).parent = sellerMap.get(referral[i]);

        for (int i = 0; i < seller.length; i++)
            dfs(sellerMap.get(seller[i]), amount[i] * 100);

        for (int i = 0; i < enroll.length; i++)
            answer[i] = sellerMap.get(enroll[i]).profit;

        return answer;
    }

    static void dfs(Seller seller, int profit) {
        int parentProfit = profit / 10;
        if (parentProfit != 0 && seller.parent != null) {
            seller.profit += (profit - parentProfit);
            dfs(seller.parent, parentProfit);
        } else
            seller.profit += profit;
    }

    static class Seller {
        String name;
        int profit;
        Seller parent;

        Seller(String n) {
            this.name = n;
            this.profit = 0;
            this.parent = null;
        }
    }
}
