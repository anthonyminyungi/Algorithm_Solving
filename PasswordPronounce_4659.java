package com.java;

import java.io.*;

public class PasswordPronounce_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        String vowelstring = "aeiou";
        char[] conso = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        String consostring = "bcdfghjklmnpqrstvwxyz";

        boolean hasVowel = false;
        boolean isTripleVowel = true;
        boolean isTripleConso = true;
        boolean isDoubleSame = true;
        while (true) {
            String a = br.readLine();
            char first = a.charAt(0);

            if (a.equals("end"))
                break;
            if (a.contains(vowel[0] + "") || a.contains(vowel[1] + "") || a.contains(vowel[2] + "") || a.contains(vowel[3] + "") || a.contains(vowel[4] + "")) {
                hasVowel = true;
                if (a.length() > 2) {
                    for (int i = 1; i < a.length(); i++) {
                        if (a.charAt(i) == a.charAt(i - 1)) {
                            if ((a.charAt(i) == 'e' && a.charAt(i - 1) == 'e') || (a.charAt(i) == 'o' && a.charAt(i - 1) == 'o')) {
                                isDoubleSame = false;
                            } else {
                                isDoubleSame = true;
                                break;
                            }
                        } else {
                            isDoubleSame = false;
                        }
                    }
                    for (int i = 2; i < a.length(); i++) {
                        if (consostring.contains(a.charAt(i) + "") && consostring.contains(a.charAt(i - 1) + "") && consostring.contains(a.charAt(i - 2) + "")) {
                            isTripleConso = true;
                            break;
                        } else
                            isTripleConso = false;
                        if (vowelstring.contains(a.charAt(i) + "") && vowelstring.contains(a.charAt(i - 1) + "") && vowelstring.contains(a.charAt(i - 2) + "")) {
                            isTripleVowel = true;
                            break;
                        } else
                            isTripleVowel = false;
                    }
                } else if (a.length() == 2) {
                    char second = a.charAt(1);
                    if (first == second) {
                        if (a.equals("ee") || a.equals("oo"))
                            isDoubleSame = false;
                        else
                            isDoubleSame = true;
                    } else {
                        isDoubleSame = false;
                    }
                    isTripleConso = false;
                    isTripleVowel = false;
                } else {
                    isTripleConso = false;
                    isTripleVowel = false;
                    isDoubleSame = false;
                }
            } else {
                hasVowel = false;
            }
            boolean isAll = false;
            if (isTripleConso && isTripleVowel) {
                isAll = false;
            } else if (isTripleConso && !isTripleVowel) {
                isAll = false;
            } else if (!isTripleConso && isTripleVowel) {
                isAll = false;
            } else if (!isTripleConso && !isTripleVowel) {
                isAll = true;
            }
            if (hasVowel && !isDoubleSame && isAll) {
                bw.append("<" + a + "> is acceptable. \n");
            } else
                bw.append("<" + a + "> is not acceptable. \n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
