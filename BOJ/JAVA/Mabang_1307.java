package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mabang_1307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        MagicSquare ms = new MagicSquare(a);
        ms.make();
        ms.print();
    }
}

class MagicSquare {
    int row;
    int column;
    int innum = 1;
    int size;
    int matrix[][];

    public MagicSquare(int n) {
        size = n;
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void make() {
        if (size % 2 != 0) {
            int index = 1;
            row = size;
            column = size;
            int newrow = row - 1;
            int newcolumn = column / 2;
            matrix[newrow][newcolumn] = innum;

            while (index < size * size) {
                newcolumn += 1;
                newrow += 1;

                if (newrow > size - 1) {
                    newrow = 0;
                }

                if (newcolumn > size - 1) {
                    newcolumn = 0;
                }

                if (matrix[newrow][newcolumn] == 0) {
                    ++innum;
                    matrix[newrow][newcolumn] = innum;
                } else {
                    ++innum;
                    newrow -= 1;
                    newcolumn -= 1;
                    if (newrow < 0) {
                        newrow = size - 1;
                    }
                    if (newcolumn < 0) {
                        newcolumn = size - 1;
                    }
                    --newrow;
                    matrix[newrow][newcolumn] = innum;

                }
                ++index;
            }
        } else {

        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
