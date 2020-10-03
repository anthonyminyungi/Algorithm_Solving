package com.algorithms.BOJ.JAVA;

import java.io.*;

public class RubberDuckDebugging_20001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        int problem = 0;
        String in = "";
        while (!(in = br.readLine()).equals("고무오리 디버깅 끝")) {
            if (in.equals("문제"))
                problem++;
            else {
                if (problem == 0)
                    problem += 2;
                else
                    problem--;
            }
        }
        if (problem == 0)
            System.out.println("고무오리야 사랑해");
        else
            System.out.println("힝구");
    }
}
