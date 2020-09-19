package com.algorithms.Programmers.Kakao2020_Solutions;

import java.util.*;

public class LockAndKey {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 0, 1, 1}, {1, 0, 1, 1}}));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int keySize = key.length;
        int[][] paddedLock = new int[lockSize + 2 * (keySize - 1)][lockSize + 2 * (keySize - 1)];

        List<int[][]> candidates = new ArrayList<>();
        candidates.add(key);

        for (int i = 0; i < 3; i++) {
            int[][] newKey = new int[keySize][keySize];
            for (int p = 0; p < keySize; p++) {
                for (int q = 0; q < keySize; q++) {
                    newKey[q][keySize - 1 - p] = candidates.get(i)[p][q];
                }
            }
            candidates.add(newKey);
        }

        for (int i = 0; i < lockSize; i++) {
            System.arraycopy(lock[i], 0, paddedLock[i + keySize - 1], keySize - 1, lockSize);
        }

        for (int r = 0; r < 4; r++) {
            int[][] canKey = candidates.get(r);
            if (check(canKey, paddedLock))
                return true;
        }

        return false;
    }

    public static boolean check(int[][] key, int[][] paddedLock) {
        int paddedSize = paddedLock.length;
        int keySize = key.length;
        for (int i = 0; i < paddedSize - keySize + 1; i++) {
            for (int j = 0; j < paddedSize - keySize + 1; j++) {
                boolean res = true;
                int[][] currentLock = new int[paddedSize][paddedSize];
                for (int k = 0; k < paddedSize; k++) {
                    System.arraycopy(paddedLock[k], 0, currentLock[k], 0, paddedSize);
                }

                for (int p = 0; p < keySize; p++) {
                    for (int q = 0; q < keySize; q++) {
                        currentLock[p + i][q + j] += key[p][q];
                    }
                }

                for (int p = keySize - 1; p < paddedSize - keySize + 1; p++) {
                    for (int q = keySize - 1; q < paddedSize - keySize + 1; q++) {
                        if (currentLock[p][q] != 1) {
                            res = false;
                            break;
                        }
                    }
                    if (!res)
                        break;
                }
                if (res)
                    return true;
            }
        }
        return false;
    }
}
