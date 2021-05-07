package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class TreeTraversal_1991 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Tree t = new Tree();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t.add(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
    }

    static class Node {
        char name;
        Node right, left;

        Node(char c) {
            this.name = c;
        }
    }

    static class Tree {
        Node root;

        void add(char c, char left, char right) {
            if (root == null) {
                this.root = new Node(c);
                if (left != '.') root.left = new Node(left);
                if (right != '.') root.right = new Node(right);
            } else search(root, c, left, right);
        }

        void search(Node root, char c, char left, char right) {
            if (root == null) return;
            else if (root.name == c) {
                if (left != '.') root.left = new Node(left);
                if (right != '.') root.right = new Node(right);
            } else {
                search(root.left, c, left, right);
                search(root.right, c, left, right);
            }
        }

        void preOrder(Node root) {
            System.out.print(root.name);
            if (root.left != null) preOrder(root.left);
            if (root.right != null) preOrder(root.right);
        }

        void inOrder(Node root) {
            if (root.left != null) inOrder(root.left);
            System.out.print(root.name);
            if (root.right != null) inOrder(root.right);
        }

        void postOrder(Node root) {
            if (root.left != null) postOrder(root.left);
            if (root.right != null) postOrder(root.right);
            System.out.print(root.name);
        }
    }
}
