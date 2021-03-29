package com.algorithms.Programmers.Line2021;

import java.util.*;

public class CLI_Flag_Validator2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("line", new String[]{"-s STRINGS", "-n NUMBERS", "-e NULL"},
                new String[]{"line -n 100 102 -s hi -e", "line -n id pwd -n 100"})));
        System.out.println(Arrays.toString(solution("trip", new String[]{"-days NUMBERS", "-dest STRING"},
                new String[]{"trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul"})));
    }

    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];

        Map<String, String> ruleMap = new HashMap<>();
        for (String rule : flag_rules) {
            String[] split = rule.split(" ");
            ruleMap.put(split[0], split[1]);
        }

        int idx = 0;
        for (String command : commands) {
            String[] split = command.split(" ");
            String programName = split[0];

            boolean isCorrect = true;
            if (programName.equals(program)) {
                label:
                for (int i = 1; i < split.length; i++) {
                    if (ruleMap.containsKey(split[i])) {
                        switch (ruleMap.get(split[i])) {
                            case "NULL":
                                if (i == split.length - 1 || split[i + 1].startsWith("-")) continue;
                                else {
                                    isCorrect = false;
                                    break label;
                                }
                            case "STRING":
                                if (i + 1 <= split.length - 1 && split[i + 1].matches("^[a-zA-Z]*$")) {
                                    i += 1;
                                    continue;
                                } else {
                                    isCorrect = false;
                                    break label;
                                }
                            case "NUMBER":
                                if (i + 1 <= split.length - 1 && split[i + 1].matches("^[0-9]*$")) {
                                    i += 1;
                                    continue;
                                } else {
                                    isCorrect = false;
                                    break label;
                                }
                            case "STRINGS": {
                                List<String> augs = new ArrayList<>();
                                boolean escape = false;
                                i += 1;
                                while (true) {
                                    if (split[i].matches("^[a-zA-Z]*$")) {
                                        augs.add(split[i]);
                                        i += 1;
                                    } else {
                                        escape = true;
                                        break;
                                    }
                                    if (split[i].startsWith("-")) break;
                                }
                                i -= 1;

                                if (escape || augs.size() < 1) {
                                    isCorrect = false;
                                    break label;
                                }
                                break;
                            }
                            case "NUMBERS": {
                                List<String> augs = new ArrayList<>();
                                boolean escape = false;
                                i += 1;
                                while (true) {

                                    if (split[i].matches("^[0-9]*$")) {
                                        augs.add(split[i]);
                                        i += 1;
                                    } else {
                                        escape = true;
                                        break;
                                    }
                                    if (split[i].startsWith("-")) break;
                                }
                                i -= 1;
                                if (escape || augs.size() < 1) {
                                    isCorrect = false;
                                    break label;
                                }
                                break;
                            }
                            default:
                                break;
                        }
                    } else {
                        isCorrect = false;
                    }
                }
            } else {
                isCorrect = false;
            }
            answer[idx] = isCorrect;
            idx++;
        }
        return answer;
    }
}