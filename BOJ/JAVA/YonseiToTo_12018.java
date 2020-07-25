package com.algorithms.BOJ.JAVA;


import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// 같은 로직이라고 생각하는데 왜 틀렸는지 전혀 모르겠다.
// 결국 정답을 찾아내서 이해하긴 했지만, 아래 코드의 틀렸습니다는 이해가 되지를 않는다.
// reference : https://github.com/sys09270883/Algorithms
// 틀린 코드를 아래에 주석처리해두고 나중에 다시 보기.

public class YonseiToTo_12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        List<Integer> list = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] pl = br.readLine().split(" ");
            int p = Integer.parseInt(pl[0]);
            int l = Integer.parseInt(pl[1]);
            String[] ms = br.readLine().split(" ");
            for (int j = 0; j < p; j++) {
                list.add(Integer.parseInt(ms[j]));
            }
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            if (p < l)
                pq.add(1);
            else
                pq.add(list.get(l - 1));
            list.clear();
        }
        int sum = 0, cnt = 0;
        while (!pq.isEmpty()) {
            if ((sum += pq.poll()) > m)
                break;
            cnt++;
        }
        System.out.println(cnt);
    }
}

//public class YonseiToTo_12018 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] nm = br.readLine().split(" ");
//        int n = Integer.parseInt(nm[0]);
//        int m = Integer.parseInt(nm[1]);
//        List<Subject> subjects = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            String[] pl = br.readLine().split(" ");
//            int p = Integer.parseInt(pl[0]);
//            int l = Integer.parseInt(pl[1]);
//            String[] ms = br.readLine().split(" ");
//            int[] arr = new int[p];
//            for (int j = 0; j < p; j++) {
//                arr[j] = Integer.parseInt(ms[j]);
//            }
//            Arrays.sort(arr);
//            subjects.add(new Subject(p, l, arr));
//        }
//        Collections.sort(subjects);
//        subjects.sort(new Comparator<Subject>() {
//            @Override
//            public int compare(Subject o1, Subject o2) {
//                int o1index = 0;
//                int o2index = 0;
//                if (o1.limit < o1.person) {
//                    o1index = o1.person - o1.limit;
//                }
//                if (o2.limit < o2.person) {
//                    o2index = o2.person - o2.limit;
//                }
//                return Integer.compare(o1.mileage[o1index], o2.mileage[o2index]);
//            }
//        });
//        int subCnt = 0;
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(subjects.get(i).mileage) + " p : " + subjects.get(i).person + "/ l : " + subjects.get(i).limit);
//            if (subjects.get(i).limit > subjects.get(i).person) {
//                m -= 1;
//            } else if (subjects.get(i).limit == subjects.get(i).person && subjects.get(i).mileage[0] <= 36) {
//                m -= subjects.get(i).mileage[0];
//            } else {
//                if (subjects.get(i).mileage[subjects.get(i).person - subjects.get(i).limit] <= 36)
//                    m -= subjects.get(i).mileage[subjects.get(i).person - subjects.get(i).limit];
//            }
//            if (m <= 0) {
//                break;
//            }
//            System.out.println(m);
//            subCnt++;
//        }
//        System.out.println(subCnt);
//    }
//}
//
//class Subject implements Comparable<Subject> {
//    int person;
//    int limit;
//    int[] mileage;
//
//    Subject(int p, int l, int[] m) {
//        this.person = p;
//        this.limit = l;
//        this.mileage = m;
//    }
//
//    @Override
//    public int compareTo(Subject o) {
//        return Integer.compare (o.limit - o.person , limit - person);
//    }
//}