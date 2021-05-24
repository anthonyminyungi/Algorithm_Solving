package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 문제에 나온 그대로 A 에서 B 로 변환하려다보니 String 을 사용하게 되고 어려워짐.
// target 인 B 에서 숫자 그대로 활용해서 규칙의 반대로 적용해서 A와 같아지는 경우를 찾도록 하는 것이 더 쉬움.
public class AtoB_16953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (true) {
            if (a == b) {
                cnt++;
                break;
            } else if (b < a) { // 끝자리 1을 제거하기 위해 10으로 나누거나 2로 나누므로 a와 같아지지 않으면 반드시 작아짐. (넘어감)
                cnt = -1;
                break;
            }

            if (b % 10 == 1) {
                b /= 10;
            } else if (b % 2 == 0) {
                b /= 2;
            } else { // 2로도 나누어 떨어지지 않고 끝자리가 1이 아닌 경우도 규칙에 위배되어 이 조건이 없으면 무한 루프를 돌게 됨.
                cnt = -1;
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
