package com.algorithms.Goorm.SaramIn;

import java.io.*;
import java.util.*;

public class ReferenceList {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine().trim();
        List<String> refSequence = new ArrayList<>();
        Map<String, Integer> refMap = new HashMap<>();
        Map<String, int[]> refGroupMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        boolean isRef = false;
        int refNum = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '[') {
                isRef = true;
                continue;
            }
            if (isRef && text.charAt(i) == ']') {
                String[] temp = sb.toString().trim().split(",");
                for (int j = 0; j < temp.length; j++) {
                    if (!refMap.containsKey(temp[j].trim())) {
                        refMap.put(temp[j].trim(), refNum++);
                        refSequence.add(temp[j].trim());
                    }
                }
                refGroupMap.put(sb.toString(), new int[temp.length]);
                isRef = false;
                sb = new StringBuilder();
            } else if (isRef && text.charAt(i) != ']') {
                sb.append(text.charAt(i));
            }
        }

        for (Map.Entry<String, int[]> entry : refGroupMap.entrySet()) {
            String[] temp = entry.getKey().trim().split(",");
            int[] nums = entry.getValue();
            for (int i = 0; i < temp.length; i++) {
                nums[i] = refMap.get(temp[i].trim());
            }

            Arrays.sort(nums);

            StringBuilder replacement = new StringBuilder();
            replacement.append(" ");
            for (int i = 0; i < temp.length; i++) {
                if (i == temp.length - 1) {
                    replacement.append(nums[i]);
                } else {
                    replacement.append(nums[i]).append(",");
                }
                replacement.append(" ");
            }

            text = text.replace(entry.getKey(), replacement.toString());
        }
        StringBuilder result = new StringBuilder(text);
        result.append("\n");
        for (int i = 0; i < refSequence.size(); i++) {
            result.append("[").append(i + 1).append("]").append(" ").append(refSequence.get(i).trim()).append("\n");
        }
        System.out.println(result);
    }
}
