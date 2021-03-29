package com.algorithms.Programmers.Line2021;

import java.util.*;

public class CLI_Flag_Validator3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("line", new String[]{"-s STRING", "-num NUMBER", "-e NULL", "-n ALIAS -num"},
                new String[]{"line -n 100 -s hi -e", "line -n 100 -e -num 150"})));
        System.out.println(Arrays.toString(solution("trip", new String[]{"-send STRING", "-a ALIAS -amount", "-amount NUMBERS"},
                new String[]{"bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey"})));
    }

    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];

        Map<String, String> ruleMap = new HashMap<>();
        Map<String, Boolean> aliasOccurred = new HashMap<>();
        Map<String, String> aliases = new HashMap<>();

        for (String flag_rule : flag_rules) {
            String[] ruleSplit = flag_rule.split(" ");
            if (ruleSplit[1].equals("ALIAS")) {
                ruleMap.put(ruleSplit[0], ruleMap.get(ruleSplit[2]));
                aliases.put(ruleSplit[0], ruleSplit[2]);
                aliases.put(ruleSplit[2], ruleSplit[0]);
                aliasOccurred.put(ruleSplit[0], false);
                aliasOccurred.put(ruleSplit[2], false);
            } else
                ruleMap.put(ruleSplit[0], ruleSplit[1]);
        }

        int answerIdx = 0;
        for (String command : commands) {
            String[] flagOrAug = command.split(" ");
            String programName = flagOrAug[0];

            boolean isCorrectCommand = true;
            if (programName.equals(program)) {
                label:
                for (int i = 1; i < flagOrAug.length; i++) {
                    if (ruleMap.containsKey(flagOrAug[i])) {
                        if (aliases.containsKey(flagOrAug[i]) && aliasOccurred.get(flagOrAug[i])) {
                            isCorrectCommand = false;
                            break;
                        } else {
                            aliasOccurred.replace(flagOrAug[i], true);
                            aliasOccurred.replace(aliases.get(flagOrAug[i]), true);
                        }
                        switch (ruleMap.get(flagOrAug[i])) {
                            case "NULL":
                                if (i == flagOrAug.length - 1 || flagOrAug[i + 1].startsWith("-")) continue;
                                else {
                                    isCorrectCommand = false;
                                    break label;
                                }
                            case "STRING":
                                if (i + 1 <= flagOrAug.length - 1 && flagOrAug[i + 1].matches("^[a-zA-Z]*$")) {
                                    i += 1;
                                    continue;
                                } else {
                                    isCorrectCommand = false;
                                    break label;
                                }
                            case "NUMBER":
                                if (i + 1 <= flagOrAug.length - 1 && flagOrAug[i + 1].matches("^[0-9]*$")) {
                                    i += 1;
                                    continue;
                                } else {
                                    isCorrectCommand = false;
                                    break label;
                                }
                            case "STRINGS": {
                                List<String> arguments = new ArrayList<>();
                                boolean escape = false;
                                i += 1;
                                while (true) {
                                    if (flagOrAug[i].matches("^[a-zA-Z]*$")) {
                                        arguments.add(flagOrAug[i]);
                                        i += 1;
                                    } else {
                                        escape = true;
                                        break;
                                    }
                                    if (flagOrAug[i].startsWith("-")) break;
                                }
                                i -= 1;

                                if (escape || arguments.size() < 1) {
                                    isCorrectCommand = false;
                                    break label;
                                }
                            }
                            case "NUMBERS": {
                                List<String> arguments = new ArrayList<>();
                                boolean escape = false;
                                i += 1;
                                while (true) {
                                    if (flagOrAug[i].matches("^[0-9]*$")) {
                                        arguments.add(flagOrAug[i]);
                                        i += 1;
                                    } else {
                                        escape = true;
                                        break;
                                    }
                                    if (flagOrAug[i].startsWith("-")) break;
                                }
                                i -= 1;
                                if (escape || arguments.size() < 1) {
                                    isCorrectCommand = false;
                                    break label;
                                }
                            }
                            default:
                                break;
                        }
                    } else {
                        isCorrectCommand = false;
                    }
                }
            } else {
                isCorrectCommand = false;
            }
            answer[answerIdx] = isCorrectCommand;
            answerIdx++;
        }
        return answer;
    }
}