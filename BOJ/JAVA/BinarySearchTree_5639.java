package com.algorithms.BOJ.JAVA;

import java.io.*;

public class BinarySearchTree_5639 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int root = Integer.parseInt(br.readLine());
        Tree tree = new Tree(root);
        String in;
        while (!(in = br.readLine()).equals("")) {
            tree.add(tree.root, Integer.parseInt(in));
        }

        tree.postOrder(tree.root);
        System.out.println(tree.sb);
    }

    static class Node {
        int key;
        Node right, left;

        Node(int c) {
            this.key = c;
        }
    }

    static class Tree {
        Node root;
        StringBuilder sb;

        Tree(int root) {
            this.root = new Node(root);
            this.sb = new StringBuilder();
        }

        void add(Node root, int key) {
            if (key < root.key) {
                if (root.left == null) {
                    root.left = new Node(key);
                } else {
                    add(root.left, key);
                }
            } else {
                if (root.right == null) {
                    root.right = new Node(key);
                } else {
                    add(root.right, key);
                }
            }
        }

        void postOrder(Node root) {
            if (root.left != null) postOrder(root.left);
            if (root.right != null) postOrder(root.right);
            this.sb.append(root.key).append("\n");
        }
    }
}

