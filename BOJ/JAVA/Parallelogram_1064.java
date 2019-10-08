package com.java.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parallelogram_1064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int Xa = Integer.parseInt(a[0]);
        int Ya = Integer.parseInt(a[1]);
        int Xb = Integer.parseInt(a[2]);
        int Yb = Integer.parseInt(a[3]);
        int Xc = Integer.parseInt(a[4]);
        int Yc = Integer.parseInt(a[5]);

        if ((Xa == Xb && Ya == Yb || Xa == Xc && Ya == Yc || Xb == Xc && Yb == Yc) || ((Xa == Xb && Xb == Xc) || (Ya == Yb && Yb == Yc))) {
            System.out.println("-1");
        } else {
            if (((Xa - Xb) != 0 && (Xb - Xc != 0)) && Math.abs(((Ya - Yb) * (Xb - Xc))) == Math.abs(((Yb - Yc) * (Xa - Xb)))) {
                System.out.println("-1");
            } else if (((Xa - Xb) != 0 && (Xa - Xc != 0)) && Math.abs(((Ya - Yb) * (Xa - Xc))) == Math.abs(((Ya - Yc) * (Xa - Xb)))) {
                System.out.println("-1");
            } else if (((Xa - Xc) != 0 && (Xb - Xc != 0)) && Math.abs(((Ya - Yc) * (Xb - Xc))) == Math.abs(((Yb - Yc) * (Xa - Xc)))) {
                System.out.println("-1");
            } else
                System.out.println(DiffOfArea(Xa, Ya, Xb, Yb, Xc, Yc));
        }
    }

    private static double DiffOfArea(int xa, int ya, int xb, int yb, int xc, int yc) {
        double dis1, dis2, dis3;
        double max, min;

        dis1 = Math.sqrt(Math.pow((xb - xa), 2) + Math.pow((yb - ya), 2));
        dis2 = Math.sqrt(Math.pow((xc - xb), 2) + Math.pow((yc - yb), 2));
        dis3 = Math.sqrt(Math.pow((xc - xa), 2) + Math.pow((yc - ya), 2));

        max = Math.max(dis1, dis2);
        max = Math.max(max, dis3);
        min = Math.min(dis1, dis2);
        min = Math.min(min, dis3);
        return (max - min) * 2;
    }
}