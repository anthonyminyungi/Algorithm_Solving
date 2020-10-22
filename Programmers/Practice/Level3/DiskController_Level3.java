package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// Heap
// 문제의 조건을 단순화하여 코드를 설계하는게 복잡한 문제.
// 초기 발상은 유사하게 접근했으나 로직 설계가 어려워 인터넷 코드를 참고하였다.
// 출처 : https://velog.io/@sa833591/%EB%94%94%EC%8A%A4%ED%81%AC-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.3
public class DiskController_Level3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        List<Task> taskList = new ArrayList<>();
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for (int[] job : jobs) {
            taskList.add(new Task(job[0], job[1]));
        }
        int sum = 0, prevEnd = 0;
        while (!taskList.isEmpty() || !pq.isEmpty()) {
            Iterator<Task> it = taskList.iterator();
            while (it.hasNext()) {
                Task task = it.next();
                if (task.start > prevEnd) break;

                pq.add(task);
                it.remove();
            }

            if (pq.isEmpty()) {
                Task newTask = taskList.remove(0);
                sum += newTask.need;
                prevEnd = newTask.start + newTask.need;
            } else {
                Task pending = pq.poll();
                sum += (prevEnd - pending.start) + pending.need;
                prevEnd += pending.need;
            }
        }

        return sum / jobs.length;
    }

    static class Task implements Comparable<Task> {
        int start;
        int need;

        Task(int s, int n) {
            this.start = s;
            this.need = n;
        }

        @Override
        public int compareTo(Task o) {
            return need - o.need;
        }
    }
}
