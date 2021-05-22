package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 각 순회 방식별로 서로 관계가 없다고 생각했는데 중위순회와 후위순회의 순서 인덱스에 따라서 전위순회의 결과를 구할수 있다는 것을 처음 알게됨.
// 참고 : https://dundung.tistory.com/47
public class TraversalOfTree_2263 {
    static int[] post;
    static int[] in;
    static int[] inPos;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        post = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        inPos = new int[n + 1];
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            inPos[in[i]] = i;
        }
        dnq(0, n - 1, 0, n - 1);
        System.out.println(sb.toString().trim());
    }

    static void dnq(int inLeftIdx, int inRightIdx, int postLeftIdx, int postRightIdx) {
        if (inRightIdx < inLeftIdx || postRightIdx < postLeftIdx) return;
        int root = post[postRightIdx];
        sb.append(root).append(" ");
        int inRootIdx = inPos[root];
        int leftCnt = inRootIdx - inLeftIdx;

        dnq(inLeftIdx, inRootIdx - 1, postLeftIdx, postLeftIdx + leftCnt - 1);
        dnq(inRootIdx + 1, inRightIdx, postLeftIdx + leftCnt, postRightIdx - 1);
    }
}
