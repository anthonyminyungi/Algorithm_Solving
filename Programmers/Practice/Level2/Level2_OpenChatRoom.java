package com.java.Programmers.Practice.Level2;

import java.util.*;

public class Level2_OpenChatRoom {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        Map<String, String> map = new LinkedHashMap<>();
        List<String> results = new ArrayList<>(); // 아니 왜 LinkedList 로 했을때 느리고 ArrayList 가 통과하는거지??????
        // reference : https://dogcowking.tistory.com/37 , https://nnoco.tistory.com/73 
        // 삭제 로직이 없고 단순 삽입과 접근(탐색)만을 하는 경우 ArrayList 가 월등히 빠른 성능을 보인다.
        StringTokenizer st;
        String inst;
        String uid;
        String name;
        String[] query;
        for (String s : record) {
            query = s.split(" ");
            inst = query[0];
            uid = query[1];

            if (inst.equals("Leave"))
                results.add(uid + " " + inst);

            else if (inst.equals("Enter")) {
                name = query[2];
                map.put(uid, name);
                results.add(uid + " " + inst);
            } else {
                name = query[2];
                map.put(uid, name);
            }

        }
        answer = new String[results.size()];
        String got;
        String str;
        String[] tmp;
        for (int i = 0; i < answer.length; i++) {
            tmp = results.get(i).split(" ");
            got = map.get(tmp[0]);
            if (tmp[1].equals("Enter"))
                str = "님이 들어왔습니다.";
            else
                str = "님이 나갔습니다.";
            answer[i] = got + str;
        }

        return answer;
    }
}
