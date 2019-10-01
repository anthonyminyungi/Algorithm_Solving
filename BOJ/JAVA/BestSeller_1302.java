package com.java.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class BestSeller_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap();
        for (int i = 0; i < N; i++) {
            String a = br.readLine();

            if (i == 0)
                hashMap.put(a, 1);
            else {
                if (hashMap.containsKey(a)) {
                    int num = hashMap.get(a) + 1;
                    hashMap.put(a, num);
                } else
                    hashMap.put(a, 1);
            }
        }

        Iterator it = sortByValue(hashMap).iterator();
        bw.write((String) it.next());
        bw.flush();
        bw.close();
        br.close();
    }

    static List sortByValue(Map map) {
        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                if (!v1.equals(v2))
                    return ((Comparable) v2).compareTo(v1);
                else
                    return ((Comparable) o1).compareTo(o2);
            }
        });
        return list;
    }
}
