package com.exampel.string;

import java.util.Arrays;

/**
 * @ClassName : ReverseString
 * @Description:
 * @Author : Zhujw
 * @CreateDate : 2022/2/17 9:13
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'H','a','n','n','a','h'};
        System.out.println(Arrays.toString(solution(s)));
    }

    private static char[] solution(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char c = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = c;
        }
        return s;
    }

}
