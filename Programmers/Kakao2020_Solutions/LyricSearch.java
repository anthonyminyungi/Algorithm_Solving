package com.algorithms.Programmers.Kakao2020_Solutions;

import java.util.*;

// 출처 : https://leveloper.tistory.com/99
// 다시 읽어보면서 이해하기
public class LyricSearch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));
    }

    public static int[] solution(String[] words, String[] queries) {
        Trie[] tries = new Trie[100001];
        for (String word : words) {
            int len = word.length();
            if (tries[len] == null) tries[len] = new Trie();
            tries[len].insert(word);
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int len = queries[i].length();
            if (tries[len] == null) answer[i] = 0;
            else answer[i] = tries[len].getCount(queries[i]);
        }
        return answer;
    }

    static class Trie {
        TrieNode front;
        TrieNode back;

        Trie() {
            this.front = new TrieNode();
            this.back = new TrieNode();
        }

        public void insert(String word) {
            insertFront(word);
            insertBack(word);
        }

        private void insertFront(String word) {
            TrieNode node = front;
            for (int i = 0; i < word.length(); i++) {
                node.count++;
                node = node.children.computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
        }

        private void insertBack(String word) {
            TrieNode node = back;
            for (int i = word.length() - 1; i >= 0; i--) {
                node.count++;
                node = node.children.computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
        }

        public int getCount(String query) {
            if (query.charAt(0) == '?') return getCountFromBack(query);
            else return getCountFromFront(query);
        }

        private int getCountFromFront(String query) {
            TrieNode node = front;
            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) == '?') break;
                if (!node.children.containsKey(query.charAt(i))) return 0;
                node = node.children.get(query.charAt(i));
            }
            return node.count;
        }

        private int getCountFromBack(String query) {
            TrieNode node = back;
            for (int i = query.length() - 1; i >= 0; i--) {
                if (query.charAt(i) == '?') break;
                if (!node.children.containsKey(query.charAt(i))) return 0;
                node = node.children.get(query.charAt(i));
            }
            return node.count;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        int count;

        TrieNode() {
            this.children = new HashMap<>();
            this.count = 0;
        }
    }
}


