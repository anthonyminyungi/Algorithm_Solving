package com.algorithms.Programmers.Line2020;

import java.util.*;
import java.util.stream.*;

// 후기 풀이 보고 작성.
// 출처 : https://velog.io/@devgosunman/%ED%9B%84%EA%B8%B0-2020%EB%85%84-%ED%95%98%EB%B0%98%EA%B8%B0-SW%EA%B0%9C%EB%B0%9C-%EC%8B%A0%EC%9E%85-LINER-%EA%B3%B5%EA%B0%9C%EC%B1%84%EC%9A%A9-%EC%98%A8%EB%9D%BC%EC%9D%B8-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8

public class Programming6 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"A fabdec 2", "B cebdfa 2", "C ecfadb 2"}, new String[]{"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"})));
        System.out.println(Arrays.toString(solution(new String[]{"A abc 2", "B abc 1"}, new String[]{"a AB 1", "b AB 1", "c AB 1"})));
    }

    public static String[] solution(String[] companies, String[] applicants) {
        String[] answer = new String[companies.length];
        Map<String, List<String>> companyStatus = new HashMap<>();
        List<String> applicantStatus = new ArrayList<>();

        Map<String, Company> companyData = new HashMap<>();
        for (String company : companies) {
            String[] c = company.split(" ");
            companyData.put(c[0], new Company(Integer.parseInt(c[2]), new ArrayList<>(c[1].chars().mapToObj(x -> (char) x).collect(Collectors.toList()))));
            companyStatus.put(c[0], new ArrayList<>());
        }

        Map<String, List<Character>> applicantData = new HashMap<>();
        for (String applicant : applicants) {
            String[] a = applicant.split(" ");
            applicantData.put(a[0], new LinkedList<>(a[1].substring(0, Integer.parseInt(a[2])).chars().mapToObj(x -> (char) x).collect(Collectors.toList())));

            applicantStatus.add(a[0]);
        }

        while (!applicantStatus.isEmpty()) {
            for (String applicant : applicantStatus) {
                if (applicantData.containsKey(applicant)) {
                    char hope = applicantData.get(applicant).remove(0);
                    if (applicantData.get(applicant).isEmpty())
                        applicantData.remove(applicant);
                    companyStatus.get(String.valueOf(hope)).add(applicant);
                }
            }

            applicantStatus = new ArrayList<>();

            for (String company : companyStatus.keySet()) {
                if (companyStatus.get(company).size() > companyData.get(company).max) {
                    int limit = companyData.get(company).max;
                    Set<String> failed = new HashSet<>(companyStatus.get(company));
                    Set<String> passed = new HashSet<>();
                    for (char hope : companyData.get(company).preferences) {
                        if (failed.contains(String.valueOf(hope))) {
                            passed.add(String.valueOf(hope));
                            limit -= 1;
                            if (limit == 0) break;
                        }
                    }
                    for (String p : passed) failed.remove(p);
                    companyStatus.replace(company, new ArrayList<>(passed));
                    applicantStatus.addAll(failed);
                }
            }
        }

        int idx = 0;
        for (String company : companyStatus.keySet()) {
            List<String> cp = companyStatus.get(company);
            Collections.sort(cp);
            StringBuilder pass = new StringBuilder();
            for (String c : cp) {
                pass.append(c);
            }
            answer[idx] = company + "_" + pass;
            idx++;
        }

        return answer;
    }

    static class Company {
        int max;
        List<Character> preferences;

        Company(int m, List<Character> p) {
            this.max = m;
            this.preferences = p;
        }
    }
}
