package com.algorithms.Programmers.Kakao2019_Solutions;

import java.util.*;

public class MatchingScore {
    public static void main(String[] args) {
        System.out.println(solution("blind", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"}));
        System.out.println(solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}));
    }

    public static int solution(String word, String[] pages) {
        int wordSize = word.length();
        Map<String, Integer> pageMap = new HashMap<>();
        List<Page> pageList = new ArrayList<>();
        word = word.toLowerCase();
        for (int i = 0; i < pages.length; ++i) {
            String p = pages[i].toLowerCase();
            int mid = 0, posL = 0, posR = 0;
            while (mid <= posL) {
                posL = p.indexOf("<meta", posL + 1);
                posR = p.indexOf(">", posL);
                mid = p.lastIndexOf("https://", posR);
            }
            posR = p.indexOf("\"", mid);
            String url = p.substring(mid, posR);

            posL = p.indexOf("<bod>", posR);
            int basic = 0;
            for (int start = posL; ; ) {
                start = p.indexOf(word, start + 1);
                if (start == -1) break;
                if (!Character.isLetter(p.charAt(start - 1)) && !Character.isLetter(p.charAt(start + wordSize))) {
                    basic++;
                    start += wordSize;
                }
            }

            int link = 0;
            for (int start = posL; ; ) {
                start = p.indexOf("<a href", start + 1);
                if (start == -1) break;
                link++;
            }
            pageMap.put(url, i);
            pageList.add(new Page(i, basic, link, basic));
        }

        for (int i = 0; i < pages.length; ++i) {
            String s = pages[i];
            for (int posL = 0, posR = 0; ; ) {
                posL = s.indexOf("<a href", posR);
                if (posL == -1) break;
                posL = s.indexOf("https://", posL);
                posR = s.indexOf("\"", posL);
                String linkUrl = s.substring(posL, posR);

                Integer value = pageMap.get(linkUrl);
                if (value != null) {
                    pageList.get(value).score += (double) pageList.get(i).basic / pageList.get(i).link;
                }
            }
        }

        pageList.sort(new Comp());
        return pageList.get(0).index;
    }

    static class Page {
        int index;
        int basic, link;
        double score;

        Page(int i, int b, int link, double score) {
            this.index = i;
            this.basic = b;
            this.link = link;
            this.score = score;
        }
    }

    static class Comp implements Comparator<Page> {
        @Override
        public int compare(Page o1, Page o2) {
            if (o1.score == o2.score) {
                return Integer.compare(o1.index, o2.index);
            } else if (o1.score < o2.score) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
