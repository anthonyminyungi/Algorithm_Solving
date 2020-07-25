package com.algorithms.BOJ.JAVA;

import java.io.*;

public class CPUs_16506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] reg = {"000", "001", "010", "011", "100", "101", "110", "111"};
        int opn = Integer.parseInt(br.readLine());
        for (int i = 0; i < opn; i++) {
            String a = br.readLine();
            String[] aa = a.split(" ");
            String op = aa[0];
            int rd = Integer.parseInt(aa[1]);
            int ra = Integer.parseInt(aa[2]);
            int rbc = Integer.parseInt(aa[3]);
            if (op == "MOV" || op == "MOVC" || op == "NOT")
                ra = 0;
            if (instruct(op).charAt(instruct(op).length() - 1) == '1') {
                bw.write(instruct(op) + "0" + reg[rd] + reg[ra] + String.format("%04d", Integer.parseInt(Integer.toBinaryString(rbc))) + "\n");
            } else if (instruct(op).charAt(instruct(op).length() - 1) == '0') {
                bw.write(instruct(op) + "0" + reg[rd] + reg[ra] + reg[rbc] + "0\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static String instruct(String op) {
        switch (op) {
            case "ADD":
                return "00000";
            case "ADDC":
                return "00001";
            case "SUB":
                return "00010";
            case "SUBC":
                return "00011";
            case "AND":
                return "00110";
            case "ANDC":
                return "00111";
            case "MOV":
                return "00100";
            case "MOVC":
                return "00101";
            case "OR":
                return "01000";
            case "ORC":
                return "01001";
            case "NOT":
                return "01010";
            case "MULT":
                return "01100";
            case "MULTC":
                return "01101";
            case "LSFTL":
                return "01110";
            case "LSFTLC":
                return "01111";
            case "LSFTR":
                return "10000";
            case "LSFTRC":
                return "10001";
            case "ASFTR":
                return "10010";
            case "ASFTRC":
                return "10011";
            case "RL":
                return "10100";
            case "RLC":
                return "10101";
            case "RR":
                return "10110";
            case "RRC":
                return "10111";
            default:
                return "";
        }
    }
}
