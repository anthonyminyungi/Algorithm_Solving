package com.algorithms.Programmers.Line2021;

import java.util.*;

public class CLI_Flag_Validator {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("line", new String[]{"-s STRING", "-n NUMBER", "-e NULL"},
                new String[]{"line -n 100 -s hi -e", "lien -s Bye"})));
        System.out.println(Arrays.toString(solution("line", new String[]{"-s STRING", "-n NUMBER", "-e NULL"},
                new String[]{"line -s 123 -n HI", "line fun"})));
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
                for (int i = 1; i < split.length; i++) {
                    if (ruleMap.containsKey(split[i])) {
                        if (ruleMap.get(split[i]).equals("NULL")) {
                            if (i == split.length - 1 || split[i + 1].startsWith("-")) continue;
                            else {
                                isCorrect = false;
                                break;
                            }
                        } else if (ruleMap.get(split[i]).equals("STRING")) {
                            if (i + 1 <= split.length - 1 && split[i + 1].matches("^[a-zA-Z]*$")) {
                                i += 1;
                                continue;
                            } else {
                                isCorrect = false;
                                break;
                            }
                        } else {
                            if (i + 1 <= split.length - 1 && split[i + 1].matches("^[0-9]*$")) {
                                i += 1;
                                continue;
                            } else {
                                isCorrect = false;
                                break;
                            }
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
