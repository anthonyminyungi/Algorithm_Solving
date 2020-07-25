package com.algorithms.BOJ.JAVA;

import java.io.*;

public class ThreePrimesProblem_11502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        for (int i = 2; i <= 1000; i++) {
//            boolean isPrime = true;
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//
//
//                }
//            if(isPrime)
//                System.out.print(i+",");
//            }
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
//            int temp = K;
            int sum = 0;
            int j = 0, k = 0, l = 0;
            boolean iscorrect = false;
            for (j = 0; j < primes.length; j++) {
                for (k = 0; k < primes.length; k++) {
                    for (l = 0; l < primes.length; l++) {
                        sum = primes[j] + primes[k] + primes[l];
                        if (sum > K) {
                            sum = 0;
                            break;
                        }
                        if (sum == K) {
                            iscorrect = true;
                            break;
                        }
                    }
                    if (sum > K) {
                        sum = 0;
                        break;
                    }
                    if (iscorrect) {
                        break;
                    }
                }
                if (iscorrect)
                    break;

            }
            if (sum == K)
                bw.append(primes[j] + " " + primes[k] + " " + primes[l] + "\n");
        }
        bw.flush();
    }
}
