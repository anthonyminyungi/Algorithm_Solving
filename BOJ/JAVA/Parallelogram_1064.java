package com.java.BOJ.JAVA;

import java.io.*;

//틀림.......
public class Parallelogram_1064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] a = br.readLine().split(" ");
        int Xa = Integer.parseInt(a[0]);
        int Ya = Integer.parseInt(a[1]);
        int Xb = Integer.parseInt(a[2]);
        int Yb = Integer.parseInt(a[3]);
        int Xc = Integer.parseInt(a[4]);
        int Yc = Integer.parseInt(a[5]);

        if ((Xa == Xb && Ya == Yb || Xa == Xc && Ya == Yc || Xb == Xc && Yb == Yc) || ((Xa == 0 && Xb == 0 && Xc == 0) || (Ya == 0 && Yb == 0 && Yc == 0))) {
            System.out.println("-1");
        } else {
            if (((Xa - Xb) != 0 && (Xb - Xc != 0)) && Math.abs(((Ya - Yb) / (Xa - Xb))) == Math.abs(((Yb - Yc) / (Xb - Xc)))) {
                System.out.println("-1");
            } else if (((Xa - Xb) != 0 && (Xa - Xc != 0)) && Math.abs(((Ya - Yb) / (Xa - Xb))) == Math.abs(((Ya - Yc) / (Xa - Xc)))) {
                System.out.println("-1");
            } else if (((Xa - Xc) != 0 && (Xb - Xc != 0)) && Math.abs(((Ya - Yc) / (Xa - Xc))) == Math.abs(((Yb - Yc) / (Xb - Xc)))) {
                System.out.println("-1");
            } else
                System.out.println(DiffOfArea(Xa, Ya, Xb, Yb, Xc, Yc));
        }
    }

    private static double DiffOfArea(int xa, int ya, int xb, int yb, int xc, int yc) {
        double dis1, dis2, dis3;
        double first = 0, second = 0, third = 0;
        double big, small;

        dis1 = Math.sqrt(Math.pow((xb - xa), 2) + Math.pow((yb - ya), 2));
        dis2 = Math.sqrt(Math.pow((xc - xb), 2) + Math.pow((yc - yb), 2));
        dis3 = Math.sqrt(Math.pow((xc - xa), 2) + Math.pow((yc - ya), 2));
        if (dis1 >= dis2 && dis2 >= dis3) {
            first = dis1;
            second = dis2;
            third = dis3;
        } else if (dis1 >= dis3 && dis3 >= dis2) {
            first = dis1;
            second = dis3;
            third = dis2;
        } else if (dis2 >= dis1 && dis1 >= dis3) {
            first = dis2;
            second = dis1;
            third = dis3;
        } else if (dis2 >= dis3 && dis3 >= dis1) {
            first = dis2;
            second = dis3;
            third = dis1;
        } else if (dis3 >= dis2 && dis2 >= dis1) {
            first = dis3;
            second = dis2;
            third = dis1;
        } else if (dis3 >= dis1 && dis1 >= dis2) {
            first = dis3;
            second = dis1;
            third = dis2;
        }
        big = first * 2 + second * 2;
        small = third * 2 + second * 2;

        return big - small;
    }
}