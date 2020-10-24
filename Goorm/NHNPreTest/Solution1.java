package com.algorithms.Goorm.NHNPreTest;

import java.io.*;
import java.util.*;

// 수건돌리기 게임
public class Solution1 {
    public static void main(String[] args) throws IOException {
        solution(6, 2, new char[]{'B', 'C'}, 2, new int[]{3, -2});
        solution(17, 5, new char[]{'B', 'D', 'I', 'M', 'P'}, 11, new int[]{3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23});
    }

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] players = new char[numOfAllPlayers];
        List<Character> places = new LinkedList<>();
        Map<Character, Integer> foolCnt = new HashMap<>();
        for (int i = 0; i < numOfAllPlayers; i++) {
            players[i] = (char) ('A' + i);
            if (i > 0) {
                places.add(players[i]);
                foolCnt.put(players[i], 0);
            } else
                foolCnt.put(players[i], 1);
        }

        int foolIdx = 0;
        int currentPlace = 0;
        char fool = players[foolIdx];
        for (int g = 0; g < numOfGames; g++) {
            int numOfMove = numOfMovesPerGame[g];
            if (Arrays.toString(namesOfQuickPlayers).contains(String.valueOf(places.get(calcPlace(places.size(), currentPlace, numOfMove))))) {
                currentPlace = calcPlace(places.size(), currentPlace, numOfMove);
                foolCnt.put(fool, foolCnt.get(fool) + 1);
            } else {
                currentPlace = calcPlace(places.size(), currentPlace, numOfMove);
                char temp = fool;
                fool = places.remove(currentPlace);
                places.add(currentPlace, temp);
                foolCnt.put(fool, foolCnt.get(fool) + 1);
            }
        }
        for (Character c : places) {
            if (c != fool) {
                bw.append(c).append(" ").append(String.valueOf(foolCnt.get(c))).append("\n");
            }
        }
        bw.append(fool).append(" ").append(String.valueOf(foolCnt.get(fool)));
        bw.flush();
        System.out.println();
//        bw.close();
    }

    static int calcPlace(int total, int current, int move) {
        int res = current + move;
        if (res >= total) res -= total;
        else if (res < 0) res += total;
        return res;
    }
}
