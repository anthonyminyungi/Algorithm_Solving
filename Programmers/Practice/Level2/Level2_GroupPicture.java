package com.algorithms.Programmers.Practice.Level2;

import java.util.*;
import java.util.stream.*;

public class Level2_GroupPicture {

    static int count;
    static List<String> combis;

    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(solution(2, new String[]{"M~C<2", "C~M>1"}));
    }

    public static int solution(int n, String[] data) {
        // {A = 1, C = 2, F = 3, J = 4, M = 5, N = 6, R = 7, T = 8}
        count = 0;
        String[] characters = {"A", "C", "F", "J", "M", "N", "R", "T"};
        Map<String, String> map = new HashMap<>();
        combis = new ArrayList<>();
        for (int i = 0; i < characters.length; i++) {
            map.put(characters[i], String.valueOf(i + 1));
        }
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        combis.add("12345678");
        while (nextPermutation(a)) {
        }
        System.out.println(combis);
        for (int i = 0; i < data.length; i++) {
            char[] query = data[i].toCharArray();
            String p = map.get(String.valueOf(query[0]));
            String q = map.get(String.valueOf(query[2]));
//            int v = Integer.parseInt(String.valueOf(query[4]));
            int v = (int) query[4] - '0';
            if (query[3] == '<') {
                combis = combis.stream().filter(c -> (Math.abs(c.indexOf(p) - c.indexOf(q)) - 1 < v)).collect(Collectors.toList());
            } else if (query[3] == '>') {
                combis = combis.stream().filter(c -> (Math.abs(c.indexOf(p) - c.indexOf(q)) - 1 > v)).collect(Collectors.toList());
            } else {
                combis = combis.stream().filter(c -> (Math.abs(c.indexOf(p) - c.indexOf(q)) - 1 == v)).collect(Collectors.toList());
            }
        }

        return combis.size();
    }

    static boolean nextPermutation(int[] array) {
        // i는 증가하지 않은 가장 긴 접미사 인덱스
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }

        // 마지막 변경이 되었을 때 4321일 경우 i는 위의 접미사 인덱스를 구하는 과정에서 -1이 됨.
        if (i <= 0)
            return false;

        // array[i - 1] 요소를 피벗으로 정함.
        // 위의 피벗과 스왑할 위의 피벗을 초과한 가장 큰 오른쪽 요소를 찾음.
        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }
        // array[j] <= array[i - 1] 조건인 이유는.
        // array[j]는  array[i - 1]보다 항상 커야하기 때문이다.
        // => 사전 순으로 모든 경우의 수를 들려야하기 때문.
        // array[i - 1] 와 array[j]를 이용하여 새로운 피벗 구함.
        // array[j] 요소가 새로운 피벗이 된다.
        // Assertion: j >= i

        // 피벗 2개는 서로 스왑에 이용하기 위해 사용됨.
        // 새로운 피벗을 이용하여 스왑.
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // 위의 과정이 일어나더라도 사전순으로 되지 않음.
        // 접미사 인덱스를 활용하여 반대로 만들어준다.
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        count++;
        String str = Arrays.toString(array);
        str = str.substring(1, str.length() - 1).replace(", ", "");
        combis.add(str);
        return true;
    }
}
