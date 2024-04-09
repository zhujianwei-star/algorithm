package com.exampel.string;

/**
 * @ClassName : MyAtoi
 * @Description: 将输入的字符串转换为数字
 * @Author : Zhujw
 * @CreateDate : 2022/2/21 15:31
 */
public class MyAtoi {

    public static void main(String[] args) {
        String s = "    -12    ";
//        System.out.println(officialSolution(s));
        System.out.println(solution(s));
    }

    /*private static int officialSolution(String s) {
        s = s.trim();
        int index = 0;
        int res = 0;
        int sign = 1;
        int length = s.length();
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            if (s.charAt(index++) == '-') {
                sign = -1;
            }
        }
        for (;index < length; ++index) {
            int i = s.charAt(index) - '0';

            if (i > 9 || i < 0) {
                break;
            }

            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && i > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + i;
        }
        return res * sign;
    }*/

    private static int solution(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int index = 0;
        int sign = 1;
        int res = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index > s.length() -1) {
            return 0;
        }
        if ((s.charAt(index) == '-') || (s.charAt(index) == '+')) {
            if (s.charAt(index) == '-') sign = -1;
            index++;
        }
        while (index < s.length()) {
            int n = s.charAt(index) - '0';
            if ((n < 0) || (n > 9)) {
                break;
            }
            index++;

            if ((res > Integer.MAX_VALUE / 10) || ((res == Integer.MAX_VALUE / 10) && (n > Integer.MAX_VALUE % 10))) {
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            res = res * 10 + n;
        }
        return res * sign;
    }
}
