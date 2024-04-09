package com.exampel.string;

import java.util.Locale;

/**
 * @ClassName : IsPalindrome
 * @Description: 验证传入的字符是否为回文串
 * @Author : Zhujw
 * @CreateDate : 2022/2/21 14:45
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        System.out.println(solution(s));
        System.out.println(officialSolution(s));
    }

    private static boolean solution(String s) {
        s = s.toLowerCase(Locale.ROOT);
        int length = s.length();
        int left = 0, right = length - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    private static boolean officialSolution(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        String s1 = new StringBuffer(s).reverse().toString();
        return s.equals(s1);
    }

}
