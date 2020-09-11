package com.algorithms.Programmers.Kakao2019_Solutions;

import java.util.*;

public class NavigationGame {
    static int idx = 0;
    static List<Node> nodes = new ArrayList<>();
    static Comparator<Node> comp = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.y == o2.y)
                return Integer.compare(o1.x, o2.x);
            return Integer.compare(o2.y, o1.y);
        }
    };

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}})));
    }

    public static int[][] solution(int[][] nodeinfo) {
        int size = nodeinfo.length;

        for (int i = 0; i < size; ++i) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        nodes.sort(comp);
        Node root = nodes.get(0);
        for (int i = 1; i < size; ++i) {
            addNode(root, nodes.get(i));
        }
        int[][] answer = new int[2][size];

        preOrder(answer, root);
        idx = 0;
        postOrder(answer, root);

        return answer;
    }

    public static void addNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null)
                parent.left = child;
            else
                addNode(parent.left, child);
        } else {
            if (parent.right == null)
                parent.right = child;
            else
                addNode(parent.right, child);
        }
    }

    public static void preOrder(int[][] answer, Node node) {
        if (node == null) return;
        answer[0][idx++] = node.id;
        preOrder(answer, node.left);
        preOrder(answer, node.right);
    }

    public static void postOrder(int[][] answer, Node node) {
        if (node == null) return;
        postOrder(answer, node.left);
        postOrder(answer, node.right);
        answer[1][idx++] = node.id;
    }

    static class Node {
        int id;
        int x, y;
        Node left;
        Node right;

        Node(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }
}
