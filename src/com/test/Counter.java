package com.test;

public class Counter {
    static String result, exceptionMessage;

    static void count(String s) {
        int operator = getOperator(s);
        if (operator == 4) return;
        String[] nums = s.split("\" *\\+ *\"|\" *- *\"|\" *\\* *|\" */ *");
        nums[0] = nums[0].substring(1);
        if (nums[1].matches(".*\"")) nums[1] = nums[1].substring(0, nums[1].length() - 1);
        if (nums[0].length() > 12 || nums[1].length() > 12) {
            exceptionMessage = "Too big string";
            return;
        }
        switch (operator) {
            case 0: add(nums[0], nums[1]); break;
            case 1: subtract(nums[0], nums[1]); break;
            case 2: multiply(nums[0], nums[1]); break;
            case 3: divide(nums[0], nums[1]); break;
        }
        if (exceptionMessage.length() == 0 && result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }
        result = "\"" + result + "\"";
    }

    static int getOperator(String s) {
        if (s.contains("\" + \"")) return 0;
        else if (s.contains("\" - \"")) return 1;
        else if (s.contains("\" * ")) return 2;
        else if (s.contains("\" / ")) return 3;
        exceptionMessage = "Wrong operator";
        return 4;
    }

    static void add(String num1, String num2) {
        result = num1 + num2;
    }

    static void subtract(String num1, String num2) {
        while (num1.length() > 0 && num2.length() > 0 && num1.charAt(num1.length() - 1) == num2.charAt(num2.length() - 1)) {
            num1 = num1.substring(0, num1.length() - 1);
            num2 = num2.substring(0, num2.length() - 1);
        }
        result = num1;
    }

    static void multiply(String num1, String num2) {
        if (num2.matches("\\d+")) {
            try {
                int ind = Integer.parseInt(num2);
                if (ind < 1 || ind > 10) {
                    exceptionMessage = "Wrong number";
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (ind > 0) {
                        sb.append(num1);
                        ind--;
                    }
                    result = sb.toString();
                }
            } catch (Exception e) {
                exceptionMessage = "Wrong number";
            }
        } else {
            exceptionMessage = "Wrong format";
        }
    }

    static void divide(String num1, String num2) {
        if (num2.matches("\\d+")) {
            try {
                int ind = Integer.parseInt(num2);
                if (ind < 1 || ind > 10) {
                    exceptionMessage = "Wrong number";
                } else {
                    result = num1.substring(0, num1.length() / ind);
                }
            } catch (Exception e) {
                exceptionMessage = "Wrong number";
            }
        } else {
            exceptionMessage = "Wrong format";
        }
    }
}
