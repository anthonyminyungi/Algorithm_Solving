package com.java.Programmers.Practice.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Level2_FileNameSort {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files)));
        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        System.out.println(Arrays.toString(solution(files2)));
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<FileName> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String cur = files[i];
            boolean isFirstNumbersStarted = false;
            int startNumberIndex = -1;
            int endNumberIndex = -1;
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) >= 48 && cur.charAt(j) <= 57) {
                    if (!isFirstNumbersStarted && startNumberIndex == -1) {
                        isFirstNumbersStarted = true;
                        startNumberIndex = j;
                    }

                    if (isFirstNumbersStarted) {
                        if (j >= cur.length() - 1 || (cur.charAt(j + 1) < 48 || cur.charAt(j + 1) > 57)) {
                            isFirstNumbersStarted = false;
                            endNumberIndex = j;
                        }
                    }
                }
            }

            String head = cur.substring(0, startNumberIndex);
            String number = cur.substring(startNumberIndex, endNumberIndex + 1);
            String tail = cur.substring(endNumberIndex + 1);
//            System.out.println(head + "    " + number + "    " + tail);
            list.add(new FileName(head, number, tail));
        }
        list.sort(new Comparator<FileName>() {
            @Override
            public int compare(FileName o1, FileName o2) {
                if (o2.head.compareToIgnoreCase(o1.head) < 0) {
                    return 1;
                } else if (o2.head.compareToIgnoreCase(o1.head) == 0) {
                    if (Integer.parseInt(o2.number) < Integer.parseInt(o1.number)) {
                        return 1;
                    } else if (Integer.parseInt(o2.number) == Integer.parseInt(o1.number)) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }

            }
        });

        for (int i = 0; i < files.length; i++) {
            FileName element = list.get(i);
            String ans = element.head + element.number + element.tail;
            answer[i] = ans;
        }

        return answer;
    }
}

class FileName {
    String head;
    String number;
    String tail;

    FileName(String h, String n, String t) {
        this.head = h;
        this.number = n;
        this.tail = t;
    }
}