package com.java.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {
        ListNode ff = new ListNode(1);
        ListNode fs = new ListNode(2);
        ListNode ft = new ListNode(4);
        ff.next = fs;
        fs.next = ft;
        ListNode sf = new ListNode(1);
        ListNode ss = new ListNode(3);
        ListNode st = new ListNode(4);
        sf.next = ss;
        ss.next = st;

        System.out.println(mergeTwoLists(ff, sf));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }
        int len = list.size();
        if (len == 0)
            return null;
        ListNode[] nodes = new ListNode[len];
        Collections.sort(list);
        nodes[0] = new ListNode(list.get(0));

        for (int i = 1; i < len; i++) {
            nodes[i] = new ListNode(list.get(i));
            nodes[i - 1].next = nodes[i];
        }
        return nodes[0];
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
