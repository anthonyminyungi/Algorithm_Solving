package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineDrink_2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int n = Integer.parseInt(a);

        int ml[] = new int[n + 1]; // 포도주의 양에 대한 배열
        int result[] = new int[n + 1]; // 최대로 마실 수 있는 포도주 양의 합에 대한 배열
        for (int i = 1; i < n + 1; i++) {//일단 나열되어있는 포도주 잔의 양을 모두  배열에 담는다
            String tem = br.readLine();
            int temp = Integer.parseInt(tem);
            ml[i] = temp;

        }
        result[1] = ml[1];//n=1이면 첫잔의 양과 최대로 마실수 있는 양은 동일하다.
        if (n >= 2) {// n이 1을 초과할때
            result[2] = ml[1] + ml[2]; //두번째 잔까지의 최대량은 첫잔과 두번째 잔의 양의 합이다.
            for (int i = 3; i < n + 1; i++) //세번째 잔 이상이 존재할 때에는
                // 연속 3잔 이상을 접근할 수 없으므로
                result[i] = Math.max(result[i - 1], Math.max(result[i - 2] + ml[i], result[i - 3] + ml[i - 1] + ml[i]));
            //직전까지의 최대량(합)과 그 이전에 존재하는 포도주량들에 대해서
            //연속된 3잔이 접근되지 않도록 하면서 그 둘을 서로 비교하여 최대값을 최대량의 배열에 입력한다.
            //이를 n까지 반복하여 결국 배열의 마지막에는 최대량이 존재하게 된다.
        }

        System.out.println(result[n]);
    }
}
