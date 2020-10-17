package com.algorithms.Programmers.Coupang2020;

import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;


// 미제출
public class Programming2 {
    static DateTimeFormatter formatter;

    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"}));
        System.out.println(solution(2, new String[]{"02/28 23:59:00 03", "03/01 00:00:00 02", "03/01 00:05:00 01"}));
    }

    public static int solution(int n, String[] customers) {
        int answer = 0;
        formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        PriorityQueue<Kiosk> kiosks = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            kiosks.add(new Kiosk(i));
        }

        System.out.println(kiosks);

        for (String customer : customers) {
            String[] split = customer.split(" ");
            Kiosk kiosk = kiosks.poll();

            System.out.println(kiosks);

            LocalDateTime plus = LocalDateTime.parse("2020/" + split[0] + " " + split[1], formatter).plus(Long.parseLong(split[2]), ChronoUnit.MINUTES);
            if (kiosk != null) {
                kiosk.setLocalDateTime(plus);
                kiosk.count += 1;
                kiosks.add(kiosk);
            }
        }

        for (Kiosk kiosk : kiosks) {
            answer = Math.max(kiosk.count, answer);
        }

        return answer;
    }

    static class Kiosk implements Comparable<Kiosk> {
        int count;
        int index;
        LocalDateTime localDateTime;

        public Kiosk(int index) {
            count = 0;
            this.index = index;
        }

        public void setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        @Override
        public int compareTo(Kiosk o) {
            if (localDateTime == null && o.localDateTime == null) return Integer.compare(index, o.index);
            if (localDateTime == null) return -1;
            if (o.localDateTime == null) return 1;
            if (localDateTime.equals(o.localDateTime)) return Integer.compare(index, o.index);
            return localDateTime.compareTo(o.localDateTime);
        }
    }
}
