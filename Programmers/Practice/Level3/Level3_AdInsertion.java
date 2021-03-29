package com.algorithms.Programmers.Practice.Level3;

public class Level3_AdInsertion {
    public static void main(String[] args) {
        System.out.println(solution("02:03:05", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
        System.out.println(solution("99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));
        System.out.println(solution("50:00:00", "50:00:00", new String[]{"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}));
//        System.out.println(solution("00:00:10", "00:00:03", new String[]{"00:00:00-00:00:01", "00:00:02-00:00:08", "00:00:03-00:00:06"}));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
//        풀이1 - 덱을 활용한 투포인터
//        int[] time_arr = new int[360000];
//
//        for (String log : logs) {
//            String[] split = log.split("-");
//            int start = ttoi(split[0]);
//            int end = ttoi(split[1]);
//            for (int i = start; i < end; i++) time_arr[i]++;
//        }
//
//        int total_len = ttoi(play_time);
//        int ad_len = ttoi(adv_time);
//
//        long sum = 0;
//        Deque<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < ad_len; i++) {
//            sum += time_arr[i];
//            queue.offer(time_arr[i]);
//        }
//
//        long max_sum = sum;
//        int idx = 0;
//
//        for (int i = ad_len; i < total_len; i++) {
//            sum += time_arr[i];
//            queue.offer(time_arr[i]);
//            if (!queue.isEmpty()) sum -= queue.pollFirst();
//
//            if (sum > max_sum) {
//                idx = i - ad_len + 1;
//                max_sum = sum;
//            }
//        }
//
//        answer = itot(idx);
        // 풀이2 - prefix sum
        int total_len = ttoi(play_time);
        int ad_len = ttoi(adv_time);
        int[] time_arr = new int[total_len + 1];
        for (String log : logs) {
            String[] split = log.split("-");
            int start = ttoi(split[0]), end = ttoi(split[1]);
            time_arr[start]++;
            time_arr[end]--;
        }
//        System.out.println(Arrays.toString(time_arr));
        long max, cur = time_arr[0];
        int max_start = 0;

        for (int i = 1; i < total_len; i++) {
            time_arr[i] += time_arr[i - 1];
            if (i < ad_len) cur += time_arr[i];
        }
//        System.out.println(Arrays.toString(time_arr) + " " + cur);

        max = cur;

        for (int s = 0, e = ad_len; e < total_len; s++, e++) {
            cur += time_arr[e] - time_arr[s];
//            System.out.println(Arrays.toString(time_arr) + " / " + max + " / " + cur + " / " + s + ", " + e + " / " + max_start);
            if (max < cur) {
                max = cur;
                max_start = s + 1;
            }
        }

        answer = itot(max_start);
        return answer;
    }

    static int ttoi(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 3600 + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
    }

    static String itot(int n) {
        String s = n % 60 < 10 ? "0" + (n % 60) : "" + (n % 60);
        n /= 60;
        String m = n % 60 < 10 ? "0" + (n % 60) : "" + (n % 60);
        n /= 60;
        String h = n < 10 ? "0" + n : "" + n;
        return h + ":" + m + ":" + s;
    }
}
