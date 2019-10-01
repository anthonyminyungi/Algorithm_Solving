package com.java.BOJ.JAVA;

import java.io.*;

public class Robot_13567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] k = br.readLine().split(" ");

        int M = Integer.parseInt(k[0]);
        int n = Integer.parseInt(k[1]);

        boolean east = true;
        boolean west = false;
        boolean north = false;
        boolean south = false;
        boolean isout = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {

            String[] a = br.readLine().split(" ");
            if (a[0].equals("MOVE")) {
                int d = Integer.parseInt(a[1]);
                if (west)
                    x -= d;
                else if (east)
                    x += d;
                else if (north)
                    y += d;
                else if (south)
                    y -= d;
                if ((x > M || x < 0) || (y > M || y < 0)) {
                    isout = true;
                }
            } else if (a[0].equals("TURN")) {
                int dir = Integer.parseInt(a[1]);
                if (east) {
                    east = false;
                    if (dir == 0) {
                        north = true;
                    } else if (dir == 1) {
                        south = true;
                    }
                } else if (west) {
                    west = false;
                    if (dir == 0) {
                        south = true;
                    } else if (dir == 1) {
                        north = true;
                    }
                } else if (south) {
                    south = false;
                    if (dir == 0) {
                        east = true;
                    } else if (dir == 1) {
                        west = true;
                    }
                } else if (north) {
                    north = false;
                    if (dir == 0) {
                        west = true;
                    } else if (dir == 1) {
                        east = true;
                    }
                }

            }


        }
        if (isout) {
            bw.append("-1");
        } else
            bw.append(x + " " + y);

        bw.flush();
    }
}
