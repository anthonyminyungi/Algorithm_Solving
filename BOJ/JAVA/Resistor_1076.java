package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Resistor_1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> values = new HashMap<>();
        Map<String, Long> multipliers = new HashMap<>();
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        for (int i = 0; i < colors.length; i++) {
            values.put(colors[i], i);
            multipliers.put(colors[i], (long) Math.pow(10, i));
        }

        System.out.println(Integer.parseInt(values.get(br.readLine()) + "" + values.get(br.readLine())) * multipliers.get(br.readLine()));
    }
}
