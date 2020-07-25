package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Y2007_1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String[] aa = a.split(" ");
        int x = Integer.parseInt(aa[0]);
        int y = Integer.parseInt(aa[1]);
        int someday = 0;
        for (int i = 1; i < x; i++) {
            someday += getDay(i);
        }
        someday += y;
        if (someday % 7 == 0)
            System.out.println("SUN");
        else if (someday % 7 == 1)
            System.out.println("MON");
        else if (someday % 7 == 2)
            System.out.println("TUE");
        else if (someday % 7 == 3)
            System.out.println("WED");
        else if (someday % 7 == 4)
            System.out.println("THU");
        else if (someday % 7 == 5)
            System.out.println("FRI");
        else if (someday % 7 == 6)
            System.out.println("SAT");


    }

    static int getDay(int x) {
        if (x == 1 || x == 3 || x == 5 || x == 7 || x == 8 || x == 10 || x == 12) {
            return 31;
        } else if (x == 4 || x == 6 || x == 9 || x == 11) {
            return 30;
        } else
            return 28;
    }
}
