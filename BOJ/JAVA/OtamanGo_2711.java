package JAVA;

import java.io.*;

public class OtamanGo_2711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] a = br.readLine().split(" ");
            int index = Integer.parseInt(a[0]) - 1;
            char[] find = a[1].toCharArray();
            String make = "";
            for (int j = 0; j < find.length; j++) {
                if (j != index)
                    make += String.valueOf(find[j]);
            }
            bw.append(make + "\n");
        }
        bw.flush();
    }
}
