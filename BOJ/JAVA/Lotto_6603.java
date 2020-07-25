package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Lotto_6603 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] a = br.readLine().split(" ");
            if (Integer.parseInt(a[0]) == 0)
                break;

            int[] arr = new int[Integer.parseInt(a[0])];
            for (int i = 0; i < Integer.parseInt(a[0]); i++) {
                arr[i] = Integer.parseInt(a[i + 1]);
//                System.out.println(arr[i]);
            }
            int[] combarr = new int[6];
            doCombination(combarr, arr.length, 6, 0, 0, arr);
            bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) throws IOException {
//        System.out.println("=> " + n + " " + r + " " + index + " " + target);

        // r ==0 이란 것은 뽑을 원소를 다 뽑았다는 뜻.
        if (r == 0) {
//            System.out.println(Arrays.toString(combArr));
            for (int i = 0; i < index; i++)
                bw.append(arr[combArr[i]] + " ");
//                System.out.print(arr[combArr[i]] + " ");

            bw.append("\n");
//            System.out.println();

            //끝까지 다 검사한 경우..1개를 뽑은 상태여도 실패한 경우임 무조건 return 으로 종료
        } else if (target == n) {

            return;

        } else {
            combArr[index] = target;
            // (i) 뽑는 경우
            // 뽑으니까, r-1
            // 뽑았으니 다음 index + 1 해줘야 함
            doCombination(combArr, n, r - 1, index + 1, target + 1, arr);

            //(ii) 안 뽑는경우
            // 안뽑으니까 그대로 r
            // 안뽑았으니, index는 그대로!
            // index를 그대로하면, 예를 들어 현재 1번 구슬을 comArr에 넣엇어도 다음 재귀에 다시 엎어쳐서 결국 1구슬을 뽑지 않게 된다.
            doCombination(combArr, n, r, index, target + 1, arr);

        }
    }


}
