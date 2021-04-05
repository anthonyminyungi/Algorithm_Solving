package com.algorithms.Programmers.DevMatchingBackend2021_1;

import java.util.*;

// 거의 다풀었는데 시간 부족으로 미제출
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
        int[] answer = {};

        Node root = new Node("center", 0);

        Node[] tree = new Node[enroll.length + 1];
        tree[0] = root;

        Map<String, Integer> idxMap = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();
        idxMap.put("center", 0);
        for (int i = 0; i < enroll.length; i++) {
            tree[i + 1] = new Node(enroll[i], 0);
            idxMap.put(enroll[i], i + 1);
            if (referral[i].equals("-")) {
                tree[0].childList.add(tree[i + 1]);
                parentMap.put(enroll[i], "center");
            } else {
                tree[idxMap.get(referral[i])].childList.add(tree[i + 1]);
                parentMap.put(enroll[i], referral[i]);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int sales = 100 * amount[i];
            while (parentMap.containsKey(name)) {
                String ref = parentMap.get(name);
                int upper = (int) Math.round((double) sales / 10);
                Node current = tree[idxMap.get(name)];
                current.earn += (sales - upper);

                name = ref;
                sales = upper;
            }
        }

        answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = tree[i + 1].earn;
        }
        return answer;
    }

    static class Node {
        String name;
        int earn;
        List<Node> childList;

        Node(String n, int e) {
            this.name = n;
            this.earn = e;
            this.childList = new ArrayList<>();
        }
    }
}
