package com.algorithms.Programmers.Kakao2019_Solutions;

import java.util.*;

// 다시보기
public class CandidateKey {
    static Comparator<Integer> comp = new Comparator<Integer>() {
        int countBits(int n) {
            int ret = 0;
            while (n != 0) {
                if ((n & 1) != 0) ++ret;
                n = n >> 1;
            }
            return ret;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            int x = countBits(o1), y = countBits(o2);
            return Integer.compare(x, y);
        }
    };

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
    }

    public static int solution(String[][] relation) {
        int answer = 0;
        int rowSize = relation.length;
        int colSize = relation[0].length;
        List<Integer> candidates = new LinkedList<>();

        for (int i = 1; i < 1 << colSize; ++i) {
            if (check(relation, rowSize, colSize, i))
                candidates.add(i);
        }
        candidates.sort(comp);

        while (candidates.size() != 0) {
            int n = candidates.remove(0);
            ++answer;
            candidates.removeIf(c -> (n & c) == n);
        }

        return answer;
    }

    public static boolean check(String[][] relation, int rowSize, int colSize, int subset) {
        for (int a = 0; a < rowSize - 1; ++a) {
            for (int b = a + 1; b < rowSize; ++b) {
                boolean isSame = true;
                for (int k = 0; k < colSize; ++k) {
                    if ((subset & 1 << k) == 0) continue;
                    if (!relation[a][k].equals(relation[b][k])) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) return false;
            }
        }
        return true;
    }
}
