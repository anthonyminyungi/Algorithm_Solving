package com.algorithms.LeetCode;

import java.util.*;

public class CountItemsMatchingRule_1773 {
    public static void main(String[] args) {
        //[["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
        String[][] items = {{"phone", "blue", "pixel"}, {"computer", "silver", "lenovo"}, {"phone", "gold", "iphone"}};
        List<List<String>> al = new ArrayList<>();
        List<String> temp;
        for (String[] strings : items) {
            temp = new ArrayList<>(Arrays.asList(strings));
            al.add(temp);
        }
        System.out.println(countMatches(al, "color", "silver"));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int answer = 0, idx = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        for (List<String> list : items) {
            if (list.get(idx).equals(ruleValue))
                answer++;
        }
        return answer;
    }
}
