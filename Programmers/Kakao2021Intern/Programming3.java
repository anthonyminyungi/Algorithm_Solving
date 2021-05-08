package com.algorithms.Programmers.Kakao2021Intern;

import java.util.*;

// 효율성 0 여기에 시간 너무 많이 씀.
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        List<Integer> table = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> deletedIdx = new HashMap<>();
        for (int i = 0; i < n; i++) table.add(i);

        StringTokenizer st;
        int cursor = k;
        for (String c : cmd) {
            st = new StringTokenizer(c);
            String dir = st.nextToken();
            int stride = c.length() > 1 ? Integer.parseInt(st.nextToken()) : 0;
            switch (dir) {
                case "U":
                    cursor -= stride;
                    break;
                case "D":
                    cursor += stride;
                    break;
                case "C":
                    int deleted = table.remove(cursor);
                    stack.push(deleted);
                    deletedIdx.put(deleted, cursor);
                    if (cursor > table.size() - 1) cursor = table.size() - 1;
                    break;
                default:
                    int curPoint = table.get(cursor);
                    int recover = stack.pop();
                    table.add(deletedIdx.get(recover), recover);
                    deletedIdx.remove(recover);
                    cursor = Collections.binarySearch(table, curPoint);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (deletedIdx.containsKey(i)) {
                sb.append('X');
            } else {
                sb.append('O');
            }
        }

        return sb.toString();
    }
}
