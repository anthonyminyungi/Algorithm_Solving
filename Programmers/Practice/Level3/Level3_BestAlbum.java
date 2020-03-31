package com.java.Programmers.Practice.Level3;

import java.util.*;

public class Level3_BestAlbum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "pop", "classic", "classic"}, new int[]{400, 600, 150, 2500, 500, 500})));
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop", "rock"}, new int[]{500, 600, 150, 800, 2500, 3800})));
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        String[] set = new HashSet<>(Arrays.asList(genres)).toArray(new String[0]);
        Map<String, List<Plays>> map = new LinkedHashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                List<Plays> tmp = new LinkedList<>();
                tmp.add(new Plays(plays[i], i, plays[i]));
                map.put(genres[i], tmp);
            } else {
                List<Plays> tmp = map.get(genres[i]);
                int newTotal = tmp.get(tmp.size() - 1).totalCount + plays[i];
                tmp.add(new Plays(plays[i], i, newTotal));
                map.replace(genres[i], tmp);
            }
        }
        List<Bests> bests = new LinkedList<>();
        int resultSize = 0;
        for (String s : set) {
            List<Plays> cur = map.get(s);
            int total = cur.get(cur.size() - 1).totalCount;
            cur.sort(new Comparator<Plays>() {
                @Override
                public int compare(Plays o1, Plays o2) {
                    if (o1.playCounts > o2.playCounts)
                        return -1;
                    else if (o1.playCounts == o2.playCounts) {
                        if (o1.number < o2.number)
                            return -1;
                        else
                            return 0;
                    } else {
                        return 1;
                    }
                }
            });
            List<Integer> e = new LinkedList<>();
            e.add(cur.get(0).number);
            if (cur.size() > 1)
                e.add(cur.get(1).number);
            bests.add(new Bests(total, e));
            resultSize += e.size();
        }
        bests.sort(Comparator.comparingInt(o -> -o.total));
        answer = new int[resultSize];
        int index = 0;
        for (Bests best : bests) {
            answer[index++] = best.genres.get(0);
            if (best.genres.size() > 1) {
                answer[index++] = best.genres.get(1);
            }
        }
        return answer;
    }
}

class Plays {
    int playCounts;
    int number;
    int totalCount;

    Plays(int p, int n, int t) {
        this.playCounts = p;
        this.number = n;
        this.totalCount = t;
    }
}

class Bests {
    int total;
    List<Integer> genres;

    Bests(int t, List<Integer> g) {
        this.total = t;
        this.genres = g;
    }
}