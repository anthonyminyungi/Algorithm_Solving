package com.java;

import java.io.*;

public class VacationHomeWork_5532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int day = Integer.parseInt(br.readLine());
        int totalLang = Integer.parseInt(br.readLine());
        int totalMath = Integer.parseInt(br.readLine());
        int LangPerDay = Integer.parseInt(br.readLine());
        int MathPerDay = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= day; i++) {
            totalLang -= LangPerDay;
            totalMath -= MathPerDay;

            if (totalLang <= 0 && totalMath <= 0) {
                cnt = i;
                break;
            }
        }
        bw.append((day - cnt) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
