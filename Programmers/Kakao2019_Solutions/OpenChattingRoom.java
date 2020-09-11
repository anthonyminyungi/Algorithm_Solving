package com.algorithms.Programmers.Kakao2019_Solutions;

import java.util.*;

public class OpenChattingRoom {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }

    public static String[] solution(String[] record) {
        Map<String, String> idmap = new HashMap<>();

        int cnt = 0;
        for (String str : record) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();
            if (cmd.equals("Enter") || cmd.equals("Leave"))
                cnt++;

            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String id = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                idmap.put(id, name);
            }
        }

        String[] answer = new String[cnt];
        int idx = 0;
        for (String str : record) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();
            if (cmd.equals("Enter")) {
                String id = tokenizer.nextToken();
                answer[idx++] = idmap.get(id) + "님이 들어왔습니다.";
            } else if (cmd.equals("Leave")) {
                String id = tokenizer.nextToken();
                answer[idx++] = idmap.get(id) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
