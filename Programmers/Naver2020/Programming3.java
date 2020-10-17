package com.algorithms.Programmers.Naver2020;

import java.util.*;

public class Programming3 {
    static int min = Integer.MAX_VALUE;
    static Tree tree;

    public static void main(String[] args) {
        System.out.println(solution(19, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}, {1, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}, {4, 10}, {4, 11}, {5, 12}, {5, 13}, {6, 14}, {6, 15}, {6, 16}, {8, 17}, {8, 18}}));
        System.out.println(solution(14, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {2, 7}, {3, 8}, {3, 9}, {3, 10}, {4, 11}, {4, 12}, {4, 13}}));
        System.out.println(solution(10, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}}));
    }

    public static int solution(int n, int[][] edges) {
        tree = Tree.makeTree(edges);
        boolean[] disconnected = new boolean[n];
        List<Integer> list = new ArrayList<>(tree.root.child.keySet());

        dfs(list, disconnected);

        return min;
    }

    static void dfs(List<Integer> list, boolean[] disconnected) {
        if (list.isEmpty()) {
            int value = count(disconnected);
            min = Math.min(value, min);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int parentIndex = list.get(i);

            disconnected[parentIndex] = true;
            List<Integer> newList = makeList(list, disconnected);
            dfs(newList, disconnected);
            disconnected[parentIndex] = false;
        }
    }

    static List<Integer> makeList(List<Integer> list, boolean[] disconnected) {
        List<Integer> res = new ArrayList<>();

        for (int childIndex : list) {
            if (!disconnected[childIndex])
                res.addAll(Tree.nodes.get(childIndex).child.keySet());
        }

        return res;
    }

    static int count(boolean[] disconnected) {
        int count = 0;
        Queue<Tree.Node> queue = new LinkedList<>();
        queue.add(tree.root);

        while (!queue.isEmpty()) {
            Tree.Node poll = queue.poll();
            if (disconnected[poll.value]) continue;
            count++;
            queue.addAll(poll.child.values());
        }
        return count;
    }

    static class Tree {
        static Map<Integer, Node> nodes = new HashMap<>();
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public static Tree makeTree(int[][] edges) {
            Node root = new Node(0);

            nodes.put(0, root);
            for (int[] edge : edges) {
                Node parent = nodes.get(edge[0]);
                Node child = new Node(edge[1]);
                parent.addChild(child);
                nodes.put(child.value, child);
            }

            return new Tree(root);
        }

        static class Node {
            int value;
            Map<Integer, Node> child;

            public Node(int value) {
                this.value = value;
                child = new HashMap<>();
            }

            public void addChild(Node child) {
                this.child.put(child.value, child);
            }
        }
    }
}
