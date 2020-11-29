package com.algorithms.OnCoder.NHNGodo;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{46, 62, 9}));
        System.out.println(solution(new int[]{50, 62, 93}));
        System.out.println(solution(new int[]{5, 31, 15}));
        System.out.println(solution(new int[]{5, 3, 15}));
    }

    public static int solution(int[] goods) {
        Arrays.sort(goods); // 가격 오름차순 정렬
        if (goods[0] >= 50) { // 가장 저렴한 가격이 50달러 이상일 경우 모두 50달러 이상이므로 각자 계산하는것이 가장 좋은 방법이다.
            return (goods[0] - 10) + (goods[1] - 10) + (goods[2] - 10);
        } else if (goods[1] >= 50) { // 두 번째로 저렴한 가격이 50달러 이상일 경우 두 번째, 세 번째는 각자 계산하는 것이 좋고 첫 번째 물건의 가격은 어디에 합쳐도 동일하다.
            return (goods[0] + goods[1] - 10) + (goods[2] - 10);
        } else if (goods[2] >= 50) { // 세 번째 물건이 50달러 이상일 경우 앞의 두 물건의 값의 합이 50달러가 넘는지를 보고 할인을 결정하면 된다.
            if (goods[0] + goods[1] >= 50) {
                return (goods[0] + goods[1] - 10) + (goods[2] - 10);
            } else return (goods[0] + goods[1]) + (goods[2] - 10);
        } else { // 위 모든 경우가 해당되지 않으면 세 물건의 값의 합이 50달러를 넘는지를 확인하고 할인을 결정하면 된다.
            if (goods[0] + goods[1] + goods[2] >= 50) return goods[0] + goods[1] + goods[2] - 10;
            else return goods[0] + goods[1] + goods[2];
        }
    }
}
